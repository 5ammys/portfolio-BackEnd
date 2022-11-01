package com.argprom.portfolio.repository;

import com.argprom.portfolio.Entitiy.UsuarioHabilidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioHabilidadRepository extends JpaRepository<UsuarioHabilidad,Long> {
    @Query("select uh from UsuarioHabilidad uh where uh.usuario.id=:idUsuario")
    List<UsuarioHabilidad> getUsuarioHabilidadByIdUsuario(@Param("idUsuario") Long id);
    @Modifying
    @Query("delete from UsuarioHabilidad u WHERE u.idUsuarioHabilidad=:id")
    void deleteByIdUsuarioAndHabilidad(@Param("id") Long id);
}
