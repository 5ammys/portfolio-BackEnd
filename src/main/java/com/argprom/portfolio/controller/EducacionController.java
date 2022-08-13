package com.argprom.portfolio.controller;

import com.argprom.portfolio.Entitiy.Educacion;
import com.argprom.portfolio.service.EducacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/educacion")
public class EducacionController {
    @Autowired private EducacionService educacionService;

    @GetMapping("/")
    public List<Educacion> get(){
        return educacionService.findEducacion();
    }

    @PostMapping("/create")
    public void save(@RequestBody Educacion educacion){
        educacionService.guardarEducacion(educacion);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id){
        educacionService.deleteEducacion(id);
    }

}
