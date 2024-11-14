package com.administrador.controller.request;


import lombok.*;


@Builder
@Data
public class PersonaRequest {




    private Long id;
    private String nombre;
    private String apellido;
    private Long fk_documentos;
    private Long fk_tarjetas;




}



