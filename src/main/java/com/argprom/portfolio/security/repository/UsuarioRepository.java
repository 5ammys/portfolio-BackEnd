package com.argprom.portfolio.security.repository;

import com.argprom.portfolio.security.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    @Query("SELECT u from Usuario u where u.username=:username")
    Optional<Usuario> findUserByUsername(@Param("username") String nombreUsuario);
    boolean existsByUsername (String username);
    boolean existsByEmail (String email);
}
