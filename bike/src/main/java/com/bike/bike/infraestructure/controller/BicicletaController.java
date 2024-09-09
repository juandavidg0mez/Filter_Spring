package com.bike.bike.infraestructure.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bike.bike.application.IBicicletasService;
import com.bike.bike.domain.bicicletas;
import com.bike.bike.domain.DTO.BicicletaDTO;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/biciletas")
public class BicicletaController {
    @Autowired
    private IBicicletasService iBicicletasService;

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody BicicletaDTO bicicletaDTO){
        try {
              bicicletas newBiciletas = iBicicletasService.create(bicicletaDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(newBiciletas); 
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


    @GetMapping("/All")
    public List<bicicletas> list(){
        return iBicicletasService.findAll();
    }

    @DeleteMapping("/Detele/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        Optional<bicicletas> cOptional = iBicicletasService.findByID(id);
        if (cOptional.isPresent()) {
            iBicicletasService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

       @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody BicicletaDTO bicicletaDTO, @PathVariable Long id) {
        try {
            // Llama al servicio para actualizar la subpregunta
            iBicicletasService.update(id, bicicletaDTO);

            // Si el método update no lanza excepción, se asume que la actualización fue
            // exitosa
            return ResponseEntity.ok("bici updated successfully");

        } catch (EntityNotFoundException e) {
            // Devuelve una respuesta 404 si no se encuentra la entidad
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entity not found: " + e.getMessage());
        } catch (Exception e) {
            // Maneja otras posibles excepciones
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }


}


