package com.administrador.controller.response;


import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DocumentoResponse {

    private Long id;
    private String tipo_documento;
}
