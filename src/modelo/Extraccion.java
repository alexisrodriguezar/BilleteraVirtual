package modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Extraccion extends Transaccion{

    public Extraccion() {
    }

    public Extraccion(Long id, BigDecimal monto, LocalDateTime fecha, Cuenta cuenta) {
        super(id, monto, fecha, cuenta);
    }
}
