package com.administrador.services;


import com.administrador.controller.request.DocumentoRequest;
import com.administrador.controller.response.DocumentoResponse;
import com.administrador.entitys.Documentos;
import com.administrador.entitys.repository.DocumentosRepository;
import com.administrador.services.service.DocumentosService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DocumentosServiceImplement implements DocumentosService {

    private final DocumentosRepository documentosRepository;


    @Override
    public List<Documentos> getListDocuments() {
        List<Documentos> listDocumentos= documentosRepository.listDocumentos();
        return  listDocumentos;
    }

    @Override
    public void deleteDocuments(Long id) {
        documentosRepository.deleteById(id);
    }

    @Override
    public DocumentoResponse searchDocuments(Long id) {
        Documentos documentos = documentosRepository.searchDocumentos(id);

        return Objects.nonNull(documentos)?
                buildDocumentoResponse(documentos):
                DocumentoResponse.builder().build();

    }


    @Override
    public void saveDocuments(DocumentoRequest documentoRequest) {
        Documentos documentos = new Documentos();
        if (Objects.nonNull(documentoRequest)){
            documentos.setTipo_documento(documentoRequest.getTipo_documento());
            documentosRepository.save(documentos);
        }

    }




    @Override
    public void updateDocuments(DocumentoRequest documentoRequest) {
        if (Objects.nonNull(documentoRequest)){
            Optional<Documentos> documentos = documentosRepository.findById(documentoRequest.getId());
            if (documentos.isPresent()){
                Documentos documentoActualizado = buildPersonaEntity(documentoRequest);
                documentosRepository.save(documentoActualizado);
            }else {
                Documentos documentoGuardar = buildPersonaEntity(documentoRequest);
                documentosRepository.save(documentoGuardar);
            }

        }

    }



    private static DocumentoResponse buildDocumentoResponse(Documentos documentos) {
        return DocumentoResponse.builder()
                .id(documentos.getId())
                .tipo_documento(documentos.getTipo_documento())
                .build();
    }


    private static Documentos buildPersonaEntity(DocumentoRequest documentoRequest) {
        return Documentos
                .builder()
                .id(documentoRequest.getId())
                .tipo_documento(documentoRequest.getTipo_documento())
                .build();
    }

}
