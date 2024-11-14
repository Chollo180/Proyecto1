package com.administrador.controller.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class GastoResponse {

    private  Long id;
    private Long consumo;
    private String descripcion;

}
