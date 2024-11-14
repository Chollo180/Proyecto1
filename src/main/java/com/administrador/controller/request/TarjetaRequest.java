package com.administrador.controller.request;

import lombok.Builder;
import lombok.Data;


@Builder
@Data

public class TarjetaRequest {


    private Long id;
    private String banco;
    private Long fk_saldo;
}
