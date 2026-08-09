package com.billeteravirtual.Billetera.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@DiscriminatorValue("EXTRACCION")
public class Extraccion extends Transaccion{

    public Extraccion() {
    }

    public Extraccion(Long id, BigDecimal monto, LocalDateTime fecha, Cuenta cuenta) {
        super(id, monto, fecha, cuenta);
    }
}
