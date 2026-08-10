package com.billeteravirtual.Billetera.dto;

import com.billeteravirtual.Billetera.model.Usuario;

public record UsuarioResponse(String nombre, String apellido, String email) {

    public static UsuarioResponse desde(Usuario usuario) {
        return new UsuarioResponse(usuario.getNombre(), usuario.getApellido(), usuario.getEmail());
    }
}