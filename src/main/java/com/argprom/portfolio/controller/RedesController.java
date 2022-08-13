package com.argprom.portfolio.controller;

import com.argprom.portfolio.Entitiy.Redes;
import com.argprom.portfolio.service.RedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/redes")
public class RedesController {
    @Autowired private RedService redService;

    @GetMapping("/")
    public List<Redes> getRedes(){
        return redService.getRedes();
    }
}
