package com.argprom.portfolio.service;

import com.argprom.portfolio.Entitiy.Habilidad;
import com.argprom.portfolio.repository.HabilidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabilidadImplement implements HabilidadService{
    @Autowired
    private HabilidadRepository repository;


    @Override
    public void saveHabilidad(Habilidad habilidad) {
        repository.save(habilidad);
    }

    @Override
    public List<Habilidad> getHabilidades() {
        return repository.findAll();
    }

    @Override
    public void deleteHabilidad(Long id) {

    }
}
