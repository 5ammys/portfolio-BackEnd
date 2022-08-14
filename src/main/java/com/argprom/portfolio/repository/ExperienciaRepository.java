package com.argprom.portfolio.repository;


import com.argprom.portfolio.Entitiy.ExperienciaLaboral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExperienciaRepository extends JpaRepository<ExperienciaLaboral,Long> {
    @Query("select e from ExperienciaLaboral e join e.usuario u where e.usuario.id=:idUsuario")
    public List<ExperienciaLaboral> findExperienciaLaboralByUser(@Param("idUsuario") Long id);
}
