package com.argprom.portfolio.service;

import com.argprom.portfolio.Entitiy.UsuarioHabilidad;
import com.argprom.portfolio.repository.UsuarioHabilidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioHabilidadImplement implements UsuarioHabilidadService{
    @Autowired
    private UsuarioHabilidadRepository repository;
    @Override
    public void saveUsuarioHabilidad(UsuarioHabilidad usuario) {
        repository.save(usuario);
    }

    @Override
    public List<UsuarioHabilidad> findUsuarioHabilidadByIdUsuario(Long id) {
        return repository.getUsuarioHabilidadByIdUsuario(id);
    }

    @Override
    public void deleteUsuarioHabilidad(Long id) {
        repository.deleteByIdUsuarioAndHabilidad(id);
    }
}
