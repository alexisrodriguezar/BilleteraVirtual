package modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transferencia extends Transaccion{
    private Cuenta cuentaDestino;

    public Transferencia() {
    }

    public Transferencia(Long id, BigDecimal monto, LocalDateTime fecha, Cuenta cuentaOrigen, Cuenta cuentaDestino) {
        super(id, monto, fecha, cuentaOrigen);
        this.cuentaDestino = cuentaDestino;
    }

    public Cuenta getCuentaDestino() {
        return cuentaDestino;
    }

    public void setCuentaDestino(Cuenta cuentaDestino) {
        this.cuentaDestino = cuentaDestino;
    }
}
