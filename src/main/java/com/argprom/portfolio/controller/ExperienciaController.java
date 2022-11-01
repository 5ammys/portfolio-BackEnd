package com.argprom.portfolio.controller;

import com.argprom.portfolio.Entitiy.ExperienciaLaboral;
import com.argprom.portfolio.service.EducacionService;
import com.argprom.portfolio.service.ExperienciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/experiencia")
@CrossOrigin
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class ExperienciaController {
    @Autowired private ExperienciaService experienciaService;

    @GetMapping("/{id}")
    public List<ExperienciaLaboral> get(@PathVariable("id") Long id){
        return experienciaService.getExperienciaByIdUser(id);
    }

    @PostMapping("/create")
    public void create(@RequestBody ExperienciaLaboral experienciaLaboral){
        experienciaService.saveExperiencia(experienciaLaboral);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id){
        experienciaService.deleteExperiencia(id);
    }
}
