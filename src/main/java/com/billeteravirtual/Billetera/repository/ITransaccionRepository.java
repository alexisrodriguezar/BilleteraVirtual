package com.billeteravirtual.Billetera.repository;

import com.billeteravirtual.Billetera.model.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ITransaccionRepository extends JpaRepository<Transaccion, Long> {

    List<Transaccion> findByCuenta_Cvu(String cvu);
}
