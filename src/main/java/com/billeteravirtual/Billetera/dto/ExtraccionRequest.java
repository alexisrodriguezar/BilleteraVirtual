package com.billeteravirtual.Billetera.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;

public record ExtraccionRequest(@NotNull @Positive BigDecimal monto) {}