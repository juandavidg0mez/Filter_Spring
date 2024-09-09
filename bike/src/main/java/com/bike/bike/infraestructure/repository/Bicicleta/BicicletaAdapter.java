package com.bike.bike.infraestructure.repository.Bicicleta;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bike.bike.application.IBicicletasService;
import com.bike.bike.domain.bicicletas;
import com.bike.bike.domain.marca;
import com.bike.bike.domain.modelo;
import com.bike.bike.domain.DTO.BicicletaDTO;
import com.bike.bike.infraestructure.repository.Marca.MarcaRepository;
import com.bike.bike.infraestructure.repository.Modelo.ModeloRepository;

@Service
public class BicicletaAdapter implements IBicicletasService {
    @Autowired
    private BiciCletaRepository biciCletaRepository;
    @Autowired
    private MarcaRepository marcaRepository;

    @Autowired 
    private ModeloRepository modeloRepository;

    @Override
    public List<bicicletas> findAll() {
        return biciCletaRepository.findAll();
    }

    @Override
    public Optional<?> findByID(Long id) {
        return biciCletaRepository.findById(id);
    }

    @Override
    public void update(Long id, BicicletaDTO bicicletas) {
        Optional<bicicletas> ExistsBicicletas = biciCletaRepository.findById(id);
        if (ExistsBicicletas.isPresent()) {
            
            bicicletas Bike = ExistsBicicletas.get();

            Long marca_id = bicicletas.getMarca_id();
            Long modelo_id = bicicletas.getModelo_id();
            Optional<marca> suOptionalMarca= marcaRepository.findById(marca_id);
            Optional<modelo> suOptionalModelo = modeloRepository.findById(modelo_id);

            if (suOptionalMarca.isPresent() && suOptionalModelo.isPresent()) {
                
                Bike.setMarca(suOptionalMarca.get());
                Bike.setModelo(suOptionalModelo.get());
                Bike.setPrecio(bicicletas.getPrecio());
                Bike.setStock(bicicletas.getStock());

                bicicletas Create = biciCletaRepository.save(Bike);
                Optional.of(Create);
            }
            
        }
       Optional.empty();
        
    }

   
    @Override
    public bicicletas create(BicicletaDTO bicicletas) {
        Long marca_id = bicicletas.getMarca_id();
        Long modelo_id = bicicletas.getModelo_id();
        Optional<marca> suOptionalMarca= marcaRepository.findById(marca_id);
        Optional<modelo> suOptionalModelo = modeloRepository.findById(modelo_id);

        bicicletas bike = new bicicletas();

        bike.setMarca(suOptionalMarca.get());
        bike.setModelo(suOptionalModelo.get());
        bike.setPrecio(bicicletas.getPrecio());
        bike.setStock(bicicletas.getStock());
        return biciCletaRepository.save(bike);
         
    }

    @Override
    public void deleteById(Long id) {
        biciCletaRepository.deleteById(id);
    }
}
