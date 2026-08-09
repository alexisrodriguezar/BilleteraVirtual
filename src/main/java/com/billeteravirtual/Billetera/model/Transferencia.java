package com.billeteravirtual.Billetera.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@DiscriminatorValue("TRANSFERENCIA")
public class Transferencia extends Transaccion{

    @ManyToOne
    @JoinColumn(name = "cuenta_destino_id")
    private Cuenta cuentaDestino;

    public Transferencia() {
    }

    public Transferencia(Long id, BigDecimal monto, LocalDateTime fecha, Cuenta cuentaOrigen, Cuenta cuentaDestino) {
        super(id, monto, fecha, cuentaOrigen);
        this.cuentaDestino = cuentaDestino;
    }

    public Cuenta getCuentaDestino() {
        return cuentaDestino;
    }

    public void setCuentaDestino(Cuenta cuentaDestino) {
        this.cuentaDestino = cuentaDestino;
    }
}
