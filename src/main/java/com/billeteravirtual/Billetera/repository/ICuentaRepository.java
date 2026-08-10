package com.billeteravirtual.Billetera.repository;

import com.billeteravirtual.Billetera.model.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ICuentaRepository extends JpaRepository<Cuenta, Long> {

    Optional<Cuenta> findByCvu(String cvu);

}
