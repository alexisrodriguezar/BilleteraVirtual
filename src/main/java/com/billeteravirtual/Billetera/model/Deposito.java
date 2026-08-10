package com.billeteravirtual.Billetera.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@DiscriminatorValue("DEPOSITO")
public class Deposito extends Transaccion{

    public Deposito() {
    }

    public Deposito(Long id, BigDecimal monto, LocalDateTime fecha, Cuenta cuenta) {
        super(id, monto, fecha, cuenta);
    }
}
