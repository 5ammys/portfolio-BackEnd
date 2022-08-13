package com.argprom.portfolio.service;

import com.argprom.portfolio.Entitiy.Educacion;

import java.util.List;

public interface EducacionService {
    public void guardarEducacion(Educacion educacion);
    public List<Educacion> findEducacion();
    public void deleteEducacion(Long id);
}
