package com.billeteravirtual.Billetera.dto;

import com.billeteravirtual.Billetera.model.Cuenta;
import java.math.BigDecimal;

public record CuentaResponse(String cvu, BigDecimal saldo, String nombreTitular) {

    public static CuentaResponse desde(Cuenta cuenta) {
        return new CuentaResponse(
                cuenta.getCvu(),
                cuenta.getSaldo(),
                cuenta.getUsuario().getNombre() + " " + cuenta.getUsuario().getApellido()
        );
    }
}