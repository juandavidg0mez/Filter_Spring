package com.bike.bike.infraestructure.repository.DetallesVenta;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bike.bike.domain.detalles_ventas;

public interface DetallesRepository extends JpaRepository<detalles_ventas, Long> {

}
