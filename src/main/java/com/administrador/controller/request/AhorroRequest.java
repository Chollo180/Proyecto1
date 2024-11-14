package com.administrador.controller.request;

import lombok.Builder;
import lombok.Data;

@Builder
@Data

public class AhorroRequest {

    private  Long id;
    private Float capital;
}
