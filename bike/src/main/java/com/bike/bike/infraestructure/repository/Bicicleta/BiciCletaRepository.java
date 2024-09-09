package com.bike.bike.infraestructure.repository.Bicicleta;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bike.bike.domain.bicicletas;

public interface BiciCletaRepository  extends JpaRepository<bicicletas, Long>{
    
}
