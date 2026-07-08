package modelo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Cuenta {
    private Long id;
    private String cvu;
    private BigDecimal saldo;
    private Usuario usuario;
    private List<Transaccion> historial;

    public Cuenta() {
    }

    public Cuenta(Long id, String cvu, BigDecimal saldo, Usuario usuario) {
        this.id = id;
        this.cvu = cvu;
        this.saldo = saldo;
        this.usuario = usuario;
        this.historial = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCvu() {
        return cvu;
    }

    public void setCvu(String cvu) {
        this.cvu = cvu;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Transaccion> getHistorial() {
        return historial;
    }

    public void setHistorial(List<Transaccion> historial) {
        this.historial = historial;
    }
}
