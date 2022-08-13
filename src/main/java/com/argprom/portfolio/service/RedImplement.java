package com.argprom.portfolio.service;

import com.argprom.portfolio.Entitiy.Redes;
import com.argprom.portfolio.repository.RedesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RedImplement implements RedService{
    @Autowired
    private RedesRepository repository;


    @Override
    public void saveRedes(Redes redes) {
        repository.save(redes);
    }

    @Override
    public List<Redes> getRedes() {
        return null;
    }

    @Override
    public void deleteRed(Long id) {

    }
}
