package com.argprom.portfolio.repository;

import com.argprom.portfolio.Entitiy.Habilidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabilidadRepository extends JpaRepository<Habilidad,Long> {

}
