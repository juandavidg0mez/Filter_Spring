package com.bike.bike.domain;


import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class modelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "VARCHAR(100)")
    private  String nombre;
    @Column(columnDefinition = "VARCHAR(200)")
    private String descripcion;
    

    @OneToMany(mappedBy = "Modelo")
    private List<bicicletas> bicicletas;

    @OneToMany(mappedBy = "modelo")
    private List<Repuesto> repuestos;
}
