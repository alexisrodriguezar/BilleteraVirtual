package com.billeteravirtual.Billetera.repository;

import com.billeteravirtual.Billetera.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {
}