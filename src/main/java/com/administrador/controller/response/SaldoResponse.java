package com.administrador.controller.response;

import com.administrador.entitys.Ahorros;
import com.administrador.entitys.Gastos;
import lombok.Builder;
import lombok.Data;

@Builder
@Data

public class SaldoResponse {

    private Long id;
    private Float monto;
    private GastoResponse gastoResponse;
    private AhorroResponse ahorroResponse;
}
