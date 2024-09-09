package com.bike.bike.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data 
@NoArgsConstructor
@Entity
public class Detalle_Compras {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Can't Black Space")
    private Integer cantidad;

    @NotEmpty(message = "Can't Black Space")
    @Column(columnDefinition = "DECIMAL(10,2)")
    private String precio_Utario;

    @ManyToOne
    @JoinColumn(name = "compras_id")
    @JsonIgnore
    @NotNull(message = "Missing Id Compras")
    private Compras compras;

    @ManyToOne
    @JoinColumn(name = "repuesto_id")
    @JsonIgnore
    @NotNull(message = "Missing Id Repuestos")
    private Repuesto repuesto;

    
}
