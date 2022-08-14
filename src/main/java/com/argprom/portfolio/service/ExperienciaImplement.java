package com.argprom.portfolio.service;

import com.argprom.portfolio.Entitiy.ExperienciaLaboral;
import com.argprom.portfolio.repository.ExperienciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienciaImplement implements ExperienciaService{
    @Autowired
    private ExperienciaRepository repository;


    @Override
    public void saveExperiencia(ExperienciaLaboral experienciaLaboral) {
        repository.save(experienciaLaboral);
    }

    @Override
    public List<ExperienciaLaboral> getExperienciaByIdUser(Long id) {
        return repository.findExperienciaLaboralByUser(id);
    }

    @Override
    public void deleteExperiencia(Long id) {
        repository.deleteById(id);
    }
}
