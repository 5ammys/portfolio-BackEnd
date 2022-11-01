package com.argprom.portfolio.service;

import com.argprom.portfolio.security.entity.Usuario;

public interface UsuarioService {
    public void saveUsuario(Usuario usuario);
    public Usuario findUsuario(String username);
    public void deleteUsuario(Long id);
}
