package com.administrador.controller.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data

public class AhorroResponse {

    private  Long id;
    private Float capital;
}
