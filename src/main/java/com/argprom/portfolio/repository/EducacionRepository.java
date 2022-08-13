package com.argprom.portfolio.repository;

import com.argprom.portfolio.Entitiy.Educacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducacionRepository extends JpaRepository<Educacion,Long> {
}
