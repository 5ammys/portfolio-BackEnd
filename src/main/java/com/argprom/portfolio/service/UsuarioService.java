package com.argprom.portfolio.service;

import com.argprom.portfolio.Entitiy.Usuario;

public interface UsuarioService {
    public void saveUsuario(Usuario usuario);
    public Usuario findUsuario(Long id);
    public void deleteUsuario(Long id);
}
