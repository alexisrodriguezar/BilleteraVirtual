package com.billeteravirtual.Billetera.controller;

import com.billeteravirtual.Billetera.dto.*;
import com.billeteravirtual.Billetera.model.Cuenta;
import com.billeteravirtual.Billetera.service.BilleteraServicio;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/cuentas")
public class CuentaController {

    private final BilleteraServicio servicio;

    public CuentaController(BilleteraServicio servicio) {
        this.servicio = servicio;
    }

    @PostMapping("/{cvu}/depositos")
    public ResponseEntity<CuentaResponse> depositar(@PathVariable String cvu, @Valid @RequestBody DepositoRequest request) {
        Cuenta cuenta = servicio.depositar(cvu, request.monto());
        return ResponseEntity.ok(CuentaResponse.desde(cuenta));
    }

    @PostMapping("/{cvu}/extracciones")
    public ResponseEntity<CuentaResponse> extraer(@PathVariable String cvu, @Valid @RequestBody ExtraccionRequest request){
        Cuenta cuenta = servicio.extraer(cvu, request.monto());
        return ResponseEntity.ok(CuentaResponse.desde(cuenta));
    }

    @GetMapping("/{cvu}/saldo")
    public ResponseEntity<BigDecimal> consultarSaldo(@PathVariable String cvu) {
        return ResponseEntity.ok(servicio.consultarSaldo(cvu));
    }

    @GetMapping("/{cvu}/historial")
    public ResponseEntity<List<TransaccionResponse>> historial(@PathVariable String cvu) {
        List<TransaccionResponse> historial = servicio.consultarHistorial(cvu).stream()
                .map(TransaccionResponse::desde)
                .toList();
        return ResponseEntity.ok(historial);
    }
}