package com.argprom.portfolio.service;

import com.argprom.portfolio.Entitiy.Proyecto;
import com.argprom.portfolio.repository.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProyectoImplement implements ProyectoService{
    @Autowired
    private ProyectoRepository repository;


    @Override
    public void saveProyecto(Proyecto proyecto) {
        repository.save(proyecto);
    }

    @Override
    public List<Proyecto> getProyecto() {
        return repository.findAll();
    }

    @Override
    public void deleteProyecto(Long id) {

    }
}
