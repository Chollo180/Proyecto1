package com.administrador.controller;

import com.administrador.entitys.Documentos;
import com.administrador.services.service.DocumentosService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(name = "v1/documents")
@RequiredArgsConstructor
public class DocumentosRestController {

    private final DocumentosService documentosService;

    public ResponseEntity<List<Documentos>> listResponseApi(){
        List<Documentos> documentosList = documentosService.getListDocuments();
        return new ResponseEntity<>(documentosList, HttpStatus.ACCEPTED);
    }
}
