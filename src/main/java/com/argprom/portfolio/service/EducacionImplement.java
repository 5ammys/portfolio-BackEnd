package com.argprom.portfolio.service;

import com.argprom.portfolio.Entitiy.Educacion;
import com.argprom.portfolio.repository.EducacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducacionImplement implements EducacionService{
    @Autowired
    private EducacionRepository repository;


    @Override
    public void guardarEducacion(Educacion educacion) {
        repository.save(educacion);
    }

    @Override
    public List<Educacion> findEducacion() {
        return repository.findAll();
    }

    @Override
    public void deleteEducacion(Long id) {
        repository.deleteById(id);
    }
}
