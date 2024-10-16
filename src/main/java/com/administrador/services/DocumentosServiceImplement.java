package com.administrador.services;


import com.administrador.entitys.Documentos;
import com.administrador.entitys.repository.DocumentosRepository;
import com.administrador.services.service.DocumentosService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DocumentosServiceImplement implements DocumentosService {

    private final DocumentosRepository documentosRepository;

    @Override
    public List<Documentos> getListDocuments() {
        List<Documentos> listDocumentos= documentosRepository.listDocumentos();
        return  listDocumentos;
    }
}
