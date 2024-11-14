package com.administrador.controller.response;


import com.administrador.entitys.Saldos;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TarjetaResponse {
    private Long id;
    private String banco;
    private SaldoResponse saldoResponse;
}
