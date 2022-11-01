package com.argprom.portfolio.service;

import com.argprom.portfolio.security.entity.Usuario;
import com.argprom.portfolio.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioImplement implements UsuarioService{
    @Autowired
    private UsuarioRepository repository;

    @Override
    public void saveUsuario(Usuario usuario) {
        repository.save(usuario);
    }

    @Override
    public Usuario findUsuario(String username) {
        return repository.findUserByUsername(username).orElse(null);
    }

    @Override
    public void deleteUsuario(Long id) {
        repository.deleteById(id);
    }
}
