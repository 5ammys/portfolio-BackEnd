package com.argprom.portfolio.controller;

import com.argprom.portfolio.security.entity.Usuario;
import com.argprom.portfolio.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    //@PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{username}")
    public ResponseEntity<Usuario> get(@PathVariable("username") String username){
        return new ResponseEntity<>(usuarioService.findUsuario(username), HttpStatus.ACCEPTED);
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
