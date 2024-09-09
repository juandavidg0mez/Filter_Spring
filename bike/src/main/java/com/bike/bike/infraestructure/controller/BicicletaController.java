package com.bike.bike.infraestructure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bike.bike.application.IBicicletasService;
import com.bike.bike.domain.bicicletas;
import com.bike.bike.domain.DTO.BicicletaDTO;

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

}


