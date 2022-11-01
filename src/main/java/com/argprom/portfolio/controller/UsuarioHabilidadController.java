package com.argprom.portfolio.controller;

import com.argprom.portfolio.Entitiy.UsuarioHabilidad;
import com.argprom.portfolio.service.UsuarioHabilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/usuariohabilidad")
public class UsuarioHabilidadController {
    @Autowired private UsuarioHabilidadService usuarioHabilidadService;

    @GetMapping("/{id}")
    public List<UsuarioHabilidad> get(@PathVariable("id") Long id){
        return usuarioHabilidadService.findUsuarioHabilidadByIdUsuario(id);
    }

    @PostMapping("/create")
    public void save(@RequestBody UsuarioHabilidad usuarioHabilidad){
        usuarioHabilidadService.saveUsuarioHabilidad(usuarioHabilidad);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id){
        usuarioHabilidadService.deleteUsuarioHabilidad(id);
    }
}
