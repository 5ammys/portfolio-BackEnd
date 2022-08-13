package com.argprom.portfolio.repository;

import com.argprom.portfolio.Entitiy.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectoRepository extends JpaRepository<Proyecto,Long> {
}
