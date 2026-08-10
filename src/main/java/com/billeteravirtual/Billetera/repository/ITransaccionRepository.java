package com.billeteravirtual.Billetera.repository;

import com.billeteravirtual.Billetera.model.Transaccion;
import com.billeteravirtual.Billetera.model.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ITransaccionRepository extends JpaRepository<Transaccion, Long> {

    List<Transaccion> findByCuenta_Cvu(String cvu);

    @Query("SELECT t FROM Transferencia t WHERE t.cuentaDestino.cvu = :cvu")
    List<Transferencia> findTransferenciasRecibidas(@Param("cvu") String cvu);

}