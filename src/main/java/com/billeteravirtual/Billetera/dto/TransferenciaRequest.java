package com.billeteravirtual.Billetera.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;

public record TransferenciaRequest(
        @NotEmpty String cvuOrigen,
        @NotEmpty String cvuDestino,
        @NotNull @Positive BigDecimal monto
) {}