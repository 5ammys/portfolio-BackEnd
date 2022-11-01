package com.argprom.portfolio.security.service;

import com.argprom.portfolio.security.entity.Usuario;
import com.argprom.portfolio.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public Optional<Usuario> getByUsuario(String username){
        return usuarioRepository.findUserByUsername(username);
    }

    public Boolean existsByUsuario(String nombreUsuario){
        return usuarioRepository.existsByUsername(nombreUsuario);
    }

    public Boolean existsByEmail(String email){
        return usuarioRepository.existsByEmail(email);
    }

    public void save(Usuario usuario){
        usuarioRepository.save(usuario);
    }


}
