package com.administrador.controller;

import com.administrador.controller.request.DocumentoRequest;
import com.administrador.controller.response.DocumentoResponse;
import com.administrador.entitys.Documentos;
import com.administrador.services.service.DocumentosService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/documents")
@RequiredArgsConstructor
public class DocumentosRestController {

    private final DocumentosService documentosService;



    @GetMapping(value = "/list")
    public ResponseEntity<List<Documentos>> listDocumentoApi(){
        List<Documentos> documentosList = documentosService.getListDocuments();
        return new ResponseEntity<>(documentosList, HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/delete")
    public ResponseEntity<String> deleteDocumentoApi(@RequestParam(value = "id")Long id){
        documentosService.deleteDocuments(id);
        return ResponseEntity.accepted().body("La accion se realizo con exito");
    }

    @GetMapping(value = "/search/{id}")
    public ResponseEntity<DocumentoResponse> searchDocumentoApi(Long id){
        DocumentoResponse documentoResponse = documentosService.searchDocuments(id);
        return ResponseEntity.accepted().body(documentoResponse);
    }

    @PostMapping(value = "/update")
    public ResponseEntity<String> updateDocumentoApi(@RequestBody DocumentoRequest documentoRequest){
        documentosService.updateDocuments(documentoRequest);
        return ResponseEntity.accepted().body("La accion se realizo con exito");
    }

    @PostMapping(value = "/save")
    public ResponseEntity<String> saveDocumentoApi(@RequestBody DocumentoRequest documentoRequest){
        documentosService.saveDocuments(documentoRequest);
        return ResponseEntity.accepted().body("La accion se realizo con exito");
    }
}
