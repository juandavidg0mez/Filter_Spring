package com.bike.bike.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class bicicletas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "This Item Is priority")
    @NotEmpty
    @Column(columnDefinition = "DECIMAL(10,2)" )
    private String precio;


    private Integer stock;


    @ManyToOne
    @JoinColumn(name = "Modelo_id")
    @JsonIgnore
    private modelo Modelo;

    @ManyToOne
    @JoinColumn(name = "Marca_id")
    @JsonIgnore
    private marca Marca;

    @OneToMany(mappedBy = "bicicletas")
    private List<detalles_ventas> detalles_ventas;
}
