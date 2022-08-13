package com.argprom.portfolio.repository;

import com.argprom.portfolio.Entitiy.Redes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedesRepository extends JpaRepository<Redes,Long> {
}
