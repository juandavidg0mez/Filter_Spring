package com.bike.bike.application;

import java.util.List;
import java.util.Optional;

import com.bike.bike.domain.detalles_ventas;

public interface IDetallesVentaService {
    List<detalles_ventas> findAll();
    detalles_ventas create(detalles_ventas detalles_ventas);
    Optional<detalles_ventas> Update(Long id ,detalles_ventas detalles_ventas);
    Optional<?> findByID(Long id);
    void deleteById(Long id);



}
