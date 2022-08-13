package com.argprom.portfolio.controller;

import com.argprom.portfolio.Entitiy.Proyecto;
import com.argprom.portfolio.service.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/proyecto")
public class ProyectoController {
    @Autowired private ProyectoService proyectoService;

    @GetMapping("/")
    public List<Proyecto> get(){
        return proyectoService.getProyecto();
    }
    @PostMapping("/create")
    public void save(@RequestBody Proyecto proyecto){
        proyectoService.saveProyecto(proyecto);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id){
        proyectoService.deleteProyecto(id);
    }
}
