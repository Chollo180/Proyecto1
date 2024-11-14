package com.administrador.controller.response;


import com.administrador.entitys.Documentos;
import com.administrador.entitys.Tarjetas;
import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class PersonaResponse {


    private Long id;
    private String nombre;
    private String apellido;
    private DocumentoResponse documentosResponse;
    private TarjetaResponse tarjetaResponse;




}



