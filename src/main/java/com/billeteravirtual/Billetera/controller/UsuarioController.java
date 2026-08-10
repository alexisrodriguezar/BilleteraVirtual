package com.billeteravirtual.Billetera.controller;

import com.billeteravirtual.Billetera.dto.*;
import com.billeteravirtual.Billetera.model.Cuenta;
import com.billeteravirtual.Billetera.model.Usuario;
import com.billeteravirtual.Billetera.service.BilleteraServicio;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final BilleteraServicio servicio;

    public UsuarioController(BilleteraServicio servicio) {
        this.servicio = servicio;
    }

    @PostMapping
    public ResponseEntity<CuentaResponse> registrar(@Valid @RequestBody UsuarioRequest request) {
        Cuenta cuenta = servicio.registrarUsuario(
                request.dni(), request.nombre(), request.apellido(), request.email());
        return ResponseEntity.status(HttpStatus.CREATED).body(CuentaResponse.desde(cuenta));
    }

    @GetMapping("/{dni}")
    public ResponseEntity<UsuarioResponse> consultarPerfil(@PathVariable String dni) {
        Usuario usuario = servicio.consultarPerfilUsuario(dni);
        return ResponseEntity.ok(UsuarioResponse.desde(usuario));
    }
}