package servicio;

import modelo.Cuenta;
import modelo.Deposito;
import modelo.Transferencia;
import modelo.Usuario;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class BilleteraServicio {

    private final Map<String, Usuario> usuarios;
    private final Map<String, Cuenta> cuentas;

    public BilleteraServicio() {
        this.usuarios = new HashMap<>();
        this.cuentas = new HashMap<>();
    }

    public void registrarUsuario(String dni, String nombre, String apellido, String email) {
        Usuario nuevoUsuario = new Usuario(null, nombre, apellido, dni, email);
        String cvuGenerado = "CVU" + dni;
        Cuenta nuevaCuenta = new Cuenta(null, cvuGenerado, BigDecimal.ZERO, nuevoUsuario);

        usuarios.put(dni, nuevoUsuario);
        cuentas.put(cvuGenerado, nuevaCuenta);

        System.out.println("Usuario " + nombre + " registrado con éxito. CVU: " + cvuGenerado);

    }

    public void consultarPerfilUsuario(String dni){
        Usuario usuario = usuarios.get(dni);

        if (usuario != null){
            System.out.println("\n--- PERFIL DE USUARIO ---");
            System.out.println("Nombre: " + usuario.getNombre() + " " + usuario.getApellido());
            System.out.println("Email: " + usuario.getEmail());
        } else {
            System.out.println("Error: No existe un usuario registrado con el DNI " + dni);
        }
    }

    public void consultarSaldo (String cvu){
        Cuenta cuenta = cuentas.get(cvu);

        if (cuenta != null){
            System.out.println("El saldo actual de la cuenta " + cvu + " es $" + cuenta.getSaldo());
        } else {
            System.out.println("Error: No se encontró la cuenta.");
        }
    }

    public void depositar(String cvu, BigDecimal monto){
        Cuenta cuenta = cuentas.get(cvu);

        if (monto.compareTo(BigDecimal.ZERO) <= 0){
            System.out.println("Error: El monto a depositar debe ser mayor a $0.");
            return;
        }

        if (cuenta != null) {
            BigDecimal nuevoSaldo = cuenta.getSaldo().add(monto);
            cuenta.setSaldo(nuevoSaldo);

            Deposito deposito = new Deposito(null, monto, java.time.LocalDateTime.now(), cuenta);
            cuenta.getHistorial().add(deposito);

            System.out.println("Déposito éxitoso. Acreditaste: $" + monto);
        } else {
            System.out.println("Error: No se encontró ninguna cuenta con ese CVU.");
        }
    }

    public void transferir(String cvuOrigen, String cvuDestino, BigDecimal monto){
        Cuenta cuentaOrigen = cuentas.get(cvuOrigen);
        Cuenta cuentaDestino = cuentas.get(cvuDestino);

        if (cvuOrigen.equals(cvuDestino)) {
            System.out.println("Error: No podés transferir dinero a tu propia cuenta.");
            return;
        }

        if (monto.compareTo(BigDecimal.ZERO) <= 0) {
            System.out.println("Error: El monto a transferir debe ser mayor a $0.");
            return;
        }

        if (cuentaOrigen == null || cuentaDestino == null){
            System.out.println("Error: Una de las cuentas indicadas no existe.");
            return;
        }

        if (cuentaOrigen.getSaldo().compareTo(monto) < 0){
            System.out.println("Error: Saldo insuficiente para realizar la transferencia.");
            return;
        }

        cuentaOrigen.setSaldo(cuentaOrigen.getSaldo().subtract(monto));
        cuentaDestino.setSaldo(cuentaDestino.getSaldo().add(monto));

        Transferencia comprobante = new Transferencia(null, monto, java.time.LocalDateTime.now(), cuentaOrigen, cuentaDestino);

        cuentaOrigen.getHistorial().add(comprobante);
        cuentaDestino.getHistorial().add(comprobante);
        System.out.println("Transferencia exitosa. Enviaste $" + monto + " al CVU: " + cvuDestino);
    }

    public void consultarHistorial(String cvu) {
        Cuenta cuenta = cuentas.get(cvu);

        if (cuenta == null) {
            System.out.println("Error: No se encontró la cuenta.");
            return;
        }

        if (cuenta.getHistorial().isEmpty()) {
            System.out.println("Aún no tenés movimientos en esta cuenta.");
            return;
        }

        System.out.println("\n--- HISTORIAL DE MOVIMIENTOS ---");
        for (modelo.Transaccion t : cuenta.getHistorial()) {
            String fecha = t.getFecha().toLocalDate().toString();
            String tipoOperacion = t.getClass().getSimpleName();

            System.out.println(fecha + " | " + tipoOperacion + " | $" + t.getMonto());
        }
    }
}
