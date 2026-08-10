package com.billeteravirtual.Billetera.controller;

import com.billeteravirtual.Billetera.dto.TransferenciaRequest;
import com.billeteravirtual.Billetera.service.BilleteraServicio;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transferencias")
public class TransferenciaController {

    private final BilleteraServicio servicio;

    public TransferenciaController(BilleteraServicio servicio) {
        this.servicio = servicio;
    }

    @PostMapping
    public ResponseEntity<Void> transferir(@Valid @RequestBody TransferenciaRequest request) {
        servicio.transferir(request.cvuOrigen(), request.cvuDestino(), request.monto());
        return ResponseEntity.noContent().build();
    }
}