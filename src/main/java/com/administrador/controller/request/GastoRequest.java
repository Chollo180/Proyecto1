package com.administrador.controller.request;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class GastoRequest {

    private  Long id;
    private Long consumo;
    private String descripcion;

}
