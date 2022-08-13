package com.argprom.portfolio.controller;

import com.argprom.portfolio.Entitiy.Usuario;
import com.argprom.portfolio.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/{id}")
    public Usuario get(@PathVariable("id") Long id){
        return usuarioService.findUsuario(id);
    }

    @PostMapping("/crear")
    public void save(@RequestBody Usuario usuario){
        usuarioService.saveUsuario(usuario);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id){
        usuarioService.deleteUsuario(id);
    }
}
