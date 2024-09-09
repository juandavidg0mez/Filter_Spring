package com.bike.bike.domain;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Provedores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull(message = "This Item Is priority")
    private String nombre;

    @NotNull(message = "This Item Is priority")
    private String Contacto;

    @NotNull(message = "This Item Is priority")
    private String email;

    @NotNull(message = "This Item Is priority")
    private String Telefono;


    @ManyToOne
    @JoinColumn(name =  "Ciudad_id")
    @JsonIgnore
    private Ciudades ciudades;


    @OneToMany(mappedBy = "provedores")
    private List<Repuesto> repuestos;
    

}
