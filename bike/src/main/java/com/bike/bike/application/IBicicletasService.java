package com.bike.bike.application;

import java.util.List;
import java.util.Optional;

import com.bike.bike.domain.bicicletas;
import com.bike.bike.domain.DTO.BicicletaDTO;

public interface IBicicletasService {
    List<bicicletas> findAll();
    Optional findByID(Long id);
    void update(Long id, BicicletaDTO bicicletasDTO);
    bicicletas create(BicicletaDTO bicicletasDTO);
    void deleteById(Long id);
    
}
