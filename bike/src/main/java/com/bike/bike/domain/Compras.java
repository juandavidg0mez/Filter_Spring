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
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Compras {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Missing De id Provedor")
    @ManyToOne
    @JoinColumn(name = "proveedor_id")
    @JsonIgnore
    private Provedores provedores;

    @NotNull(message = "Missing Total About 'Compras'. ")
    @Column(columnDefinition = "DECIMAL(10,2)")
    private String total;

    @NotNull(message = "This Item Is Priority")
    @Column(columnDefinition = "DATETIME")
    private String fecha;

    @OneToMany(mappedBy = "compras")
    private List<Detalle_Compras> detalle_Compras;





    

}
