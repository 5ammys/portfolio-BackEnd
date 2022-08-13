package com.argprom.portfolio.service;

import com.argprom.portfolio.Entitiy.Redes;

import java.util.List;

public interface RedService {
    public void saveRedes(Redes redes);
    public List<Redes> getRedes();
    public void deleteRed(Long id);
}
