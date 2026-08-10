package com.billeteravirtual.Billetera.repository;

import com.billeteravirtual.Billetera.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByDni(String dni);
}