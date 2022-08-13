package com.argprom.portfolio.service;

import com.argprom.portfolio.Entitiy.Habilidad;

import java.util.List;

public interface HabilidadService {
    public void saveHabilidad(Habilidad habilidad);

    public List<Habilidad> getHabilidades();

    public void deleteHabilidad(Long id);
}
