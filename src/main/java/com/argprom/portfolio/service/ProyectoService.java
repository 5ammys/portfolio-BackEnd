package com.argprom.portfolio.service;

import com.argprom.portfolio.Entitiy.Proyecto;

import java.util.List;

public interface ProyectoService {
    public void saveProyecto(Proyecto proyecto);
    public List<Proyecto> getProyecto();
    public void deleteProyecto(Long id);
}
