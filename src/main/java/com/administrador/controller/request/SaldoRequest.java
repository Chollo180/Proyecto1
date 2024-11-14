package com.administrador.controller.request;

import com.administrador.entitys.Ahorros;
import com.administrador.entitys.Gastos;
import lombok.Builder;
import lombok.Data;

@Builder
@Data

public class SaldoRequest {

    private Long id;
    private Float monto;
    private Long fk_gastos;
    private Long fk_ahorros;
}
