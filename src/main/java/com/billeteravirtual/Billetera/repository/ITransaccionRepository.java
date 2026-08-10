package com.billeteravirtual.Billetera.repository;

import com.billeteravirtual.Billetera.model.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ITransaccionRepository extends JpaRepository<Transaccion, Long> {

    @Query("SELECT t FROM Transaccion t " +
            "WHERE t.cuenta.cvu = :cvu " +
            "OR (TYPE(t) = Transferencia AND TREAT(t AS Transferencia).cuentaDestino.cvu = :cvu) " +
            "ORDER BY t.fecha DESC")
    List<Transaccion> findHistorialByCvu(@Param("cvu") String cvu);
}