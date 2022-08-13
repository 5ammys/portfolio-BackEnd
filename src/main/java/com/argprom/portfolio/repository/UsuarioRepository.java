package com.argprom.portfolio.repository;

import com.argprom.portfolio.Entitiy.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository <Usuario,Long> {

}
