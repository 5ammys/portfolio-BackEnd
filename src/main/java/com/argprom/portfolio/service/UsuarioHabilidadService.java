package com.argprom.portfolio.service;

import com.argprom.portfolio.Entitiy.UsuarioHabilidad;

import java.util.List;

public interface UsuarioHabilidadService {
    void saveUsuarioHabilidad(UsuarioHabilidad usuario);
    List<UsuarioHabilidad> findUsuarioHabilidadByIdUsuario(Long id);
    void deleteUsuarioHabilidad(Long id);
}
