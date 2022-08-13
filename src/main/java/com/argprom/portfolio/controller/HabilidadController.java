package com.argprom.portfolio.controller;

import com.argprom.portfolio.Entitiy.Habilidad;
import com.argprom.portfolio.service.HabilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/habilidad")
public class HabilidadController {
    @Autowired private HabilidadService habilidadService;

    @GetMapping("/")
    public List<Habilidad> get(){
        return habilidadService.getHabilidades();
    }

    @PostMapping("/create")
    public void save(@RequestBody Habilidad habilidad){
        habilidadService.saveHabilidad(habilidad);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id){
        habilidadService.deleteHabilidad(id);
    }
}
