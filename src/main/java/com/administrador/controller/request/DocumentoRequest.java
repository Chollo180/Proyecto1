package com.administrador.controller.request;

import lombok.Builder;
import lombok.Data;

@Builder
@Data

public class DocumentoRequest {

    private Long id;
    private String tipo_documento;
}
