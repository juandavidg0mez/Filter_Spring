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

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class detalles_ventas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "This Item Is priority")
    @NotEmpty
    @ManyToOne
    @JoinColumn(name = "Ventas_id")
    @JsonIgnore
    private ventas ventas;

    @NotNull(message = "This Item Is priority")
    @NotEmpty
    @ManyToOne
    @JoinColumn(name = "Bicicletas_id")
    @JsonIgnore
    private bicicletas bicicletas;

    @NotNull(message = "This Item Is priority")
    @NotEmpty
    private Integer cantidad;

    @NotNull(message = "This Item Is priority")
    @NotEmpty
    @Column(columnDefinition = "DECIMAL(10,2)")
    private String precio_Unitario;
    

}
