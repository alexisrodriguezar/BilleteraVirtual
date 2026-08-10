package com.billeteravirtual.Billetera.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public record UsuarioRequest(
        @NotEmpty String dni,
        @NotEmpty String nombre,
        @NotEmpty String apellido,
        @NotEmpty @Email String email
) {}