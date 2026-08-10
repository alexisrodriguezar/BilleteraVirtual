package com.billeteravirtual.Billetera.dto;

import com.billeteravirtual.Billetera.model.Transaccion;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TransaccionResponse(String tipo, BigDecimal monto, LocalDateTime fecha) {

    public static TransaccionResponse desde(Transaccion t) {
        return new TransaccionResponse(t.getClass().getSimpleName(), t.getMonto(), t.getFecha());
    }
}