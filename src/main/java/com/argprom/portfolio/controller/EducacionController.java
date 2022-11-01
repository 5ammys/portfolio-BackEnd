package com.argprom.portfolio.controller;

import com.argprom.portfolio.Entitiy.Educacion;
import com.argprom.portfolio.service.EducacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/educacion")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class EducacionController {
    @Autowired private EducacionService educacionService;

    @GetMapping("/{id}")
    public ResponseEntity<List<Educacion>> getEduByUser(@PathVariable("id") Long fkUsuario){
        List<Educacion> list=educacionService.findEducacionByIdUsuario(fkUsuario);
        return new ResponseEntity<>(list, HttpStatus.OK);
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
