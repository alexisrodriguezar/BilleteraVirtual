package modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Deposito extends Transaccion{

    public Deposito() {
    }

    public Deposito(Long id, BigDecimal monto, LocalDateTime fecha, Cuenta cuenta) {
        super(id, monto, fecha, cuenta);
    }
}
