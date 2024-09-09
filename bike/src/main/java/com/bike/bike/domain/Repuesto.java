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

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Repuesto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Missin Name Repuesto")
    @NotNull
    private String nombre;

    @NotEmpty(message = "Mussing Description Repuesto")
    @NotNull
    private String descripcion;

    @NotEmpty(message = "Sapa")
    @NotNull
    @Column(columnDefinition = "DECIMAL(10,2)")
    private String precio;

    @NotEmpty(message = "Missing Stock")
    @NotNull
    private Integer stock;


    @ManyToOne
    @JoinColumn(name = "provedor_id")
    @JsonIgnore
    @NotEmpty
    private Provedores provedores;

    @ManyToOne
    @JoinColumn(name = "modelo_id")
    @JsonIgnore
    @NotEmpty
    private modelo  modelo;

    @ManyToOne
    @JoinColumn(name = "marca_id")
    @JsonIgnore
    @NotEmpty
    private marca  marca;

    @OneToMany(mappedBy = "repuesto")
    private List<Detalle_Compras> detalle_Compras;





    


}
