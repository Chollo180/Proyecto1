package com.administrador.services.service;

import com.administrador.controller.request.DocumentoRequest;
import com.administrador.controller.response.DocumentoResponse;
import com.administrador.entitys.Documentos;

import java.util.List;

public interface DocumentosService {
    List<Documentos> getListDocuments();
    void deleteDocuments(Long id);
    DocumentoResponse searchDocuments(Long id);
    void updateDocuments(DocumentoRequest documentoRequest);
    void saveDocuments(DocumentoRequest documentoRequest);
}
