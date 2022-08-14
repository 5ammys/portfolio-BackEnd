package com.argprom.portfolio.repository;

import com.argprom.portfolio.Entitiy.Educacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EducacionRepository extends JpaRepository<Educacion,Long> {
    @Query("select e from Educacion e join e.usuario u where e.usuario.id=:idUsuario")
    public List<Educacion> findEducacionByIdUsuario(@Param("idUsuario") Long id);
}
