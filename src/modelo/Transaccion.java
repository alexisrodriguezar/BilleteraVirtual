package modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public abstract class Transaccion {
    private Long id;
    private BigDecimal monto;
    private LocalDateTime fecha;
    private Cuenta cuenta;

    public Transaccion() {
    }

    public Transaccion(Long id, BigDecimal monto, LocalDateTime fecha, Cuenta cuenta) {
        this.id = id;
        this.monto = monto;
        this.fecha = fecha;
        this.cuenta = cuenta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
}
