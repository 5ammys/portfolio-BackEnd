package com.argprom.portfolio.service;

import com.argprom.portfolio.Entitiy.ExperienciaLaboral;

import java.util.List;

public interface ExperienciaService {
    public void saveExperiencia(ExperienciaLaboral experienciaLaboral);
    public List<ExperienciaLaboral> getExperienciaByIdUser(Long id);
    public void deleteExperiencia(Long id);
    
}
