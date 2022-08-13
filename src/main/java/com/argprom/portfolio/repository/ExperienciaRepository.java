package com.argprom.portfolio.repository;

import com.argprom.portfolio.Entitiy.ExperienciaLaboral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienciaRepository extends JpaRepository<ExperienciaLaboral,Long> {
}
