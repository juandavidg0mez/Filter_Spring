package com.bike.bike.infraestructure.repository.DetallesVenta;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.bike.bike.application.IDetallesVentaService;
import com.bike.bike.domain.detalles_ventas;

public class DetallesApapter implements IDetallesVentaService{
    @Autowired
    private DetallesRepository detallesRepository;

    @Override
    public List<detalles_ventas> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public detalles_ventas create(detalles_ventas detalles_ventas) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public Optional Update(Long id, detalles_ventas detalles_ventas) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Update'");
    }

    @Override
    public Optional findByID(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByID'");
    }

    @Override
    public void deleteById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }
}
