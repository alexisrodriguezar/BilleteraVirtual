package com.billeteravirtual.Billetera.service;

import com.billeteravirtual.Billetera.exception.*;
import com.billeteravirtual.Billetera.model.*;
import com.billeteravirtual.Billetera.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class BilleteraServicio {

    private final IUsuarioRepository usuarioRepository;
    private final ICuentaRepository cuentaRepository;
    private final ITransaccionRepository transaccionRepository;

    public BilleteraServicio(IUsuarioRepository usuarioRepository,
                             ICuentaRepository cuentaRepository,
                             ITransaccionRepository transaccionRepository) {
        this.usuarioRepository = usuarioRepository;
        this.cuentaRepository = cuentaRepository;
        this.transaccionRepository = transaccionRepository;
    }

    @Transactional
    public Cuenta registrarUsuario(String dni, String nombre, String apellido, String email) {
        Usuario nuevoUsuario = new Usuario(null, nombre, apellido, dni, email);
        usuarioRepository.save(nuevoUsuario);

        String cvuGenerado = "CVU" + dni;
        Cuenta nuevaCuenta = new Cuenta(null, cvuGenerado, BigDecimal.ZERO, nuevoUsuario);
        return cuentaRepository.save(nuevaCuenta);
    }

    public Usuario consultarPerfilUsuario(String dni) {
        return usuarioRepository.findByDni(dni)
                .orElseThrow(() -> new RecursoNoEncontradoException(
                        "No existe un usuario registrado con el DNI " + dni));
    }

    private Cuenta buscarCuentaPorCvu(String cvu) {
        return cuentaRepository.findByCvu(cvu)
                .orElseThrow(() -> new RecursoNoEncontradoException("No se encontró la cuenta con CVU " + cvu));
    }

    public BigDecimal consultarSaldo(String cvu) {
        return buscarCuentaPorCvu(cvu).getSaldo();
    }

    @Transactional
    public Cuenta depositar(String cvu, BigDecimal monto) {
        if (monto.compareTo(BigDecimal.ZERO) <= 0) {
            throw new OperacionInvalidaException("El monto a depositar debe ser mayor a $0.");
        }

        Cuenta cuenta = buscarCuentaPorCvu(cvu);
        cuenta.setSaldo(cuenta.getSaldo().add(monto));
        cuentaRepository.save(cuenta);

        transaccionRepository.save(new Deposito(null, monto, LocalDateTime.now(), cuenta));

        return cuenta;
    }

    @Transactional
    public void transferir(String cvuOrigen, String cvuDestino, BigDecimal monto) {
        if (cvuOrigen.equals(cvuDestino)) {
            throw new OperacionInvalidaException("No podés transferir dinero a tu propia cuenta.");
        }
        if (monto.compareTo(BigDecimal.ZERO) <= 0) {
            throw new OperacionInvalidaException("El monto a transferir debe ser mayor a $0.");
        }

        Cuenta cuentaOrigen = buscarCuentaPorCvu(cvuOrigen);
        Cuenta cuentaDestino = buscarCuentaPorCvu(cvuDestino);

        if (cuentaOrigen.getSaldo().compareTo(monto) < 0) {
            throw new SaldoInsuficienteException("Saldo insuficiente para realizar la transferencia.");
        }

        cuentaOrigen.setSaldo(cuentaOrigen.getSaldo().subtract(monto));
        cuentaDestino.setSaldo(cuentaDestino.getSaldo().add(monto));
        cuentaRepository.save(cuentaOrigen);
        cuentaRepository.save(cuentaDestino);

        transaccionRepository.save(new Transferencia(null, monto, LocalDateTime.now(), cuentaOrigen, cuentaDestino));
    }

    public List<Transaccion> consultarHistorial(String cvu) {
        buscarCuentaPorCvu(cvu);
        return transaccionRepository.findHistorialByCvu(cvu);
    }
}