package com.bike.bike.domain.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BicicletaDTO {
    private Long modelo_id;
    private Long marca_id;
    private String precio;
    private Integer Stock;
}
