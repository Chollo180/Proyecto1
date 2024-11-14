package com.administrador.services;

import com.administrador.controller.request.PersonaRequest;
import com.administrador.controller.response.DocumentoResponse;
import com.administrador.controller.response.PersonaResponse;
import com.administrador.controller.response.SaldoResponse;
import com.administrador.controller.response.TarjetaResponse;
import com.administrador.entitys.Documentos;
import com.administrador.entitys.Personas;
import com.administrador.entitys.Tarjetas;
import com.administrador.entitys.repository.PersonasRepository;
import com.administrador.services.service.PersonaService;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonaServiceImplement implements PersonaService {

    private final PersonasRepository personasRepository;


    @Override
    public List<Personas> getListPersons() {
        List<Personas> listPersonas= personasRepository.listPersonas();
        return listPersonas;
    }

    @Override
    public void deletePersonas(Long id) {
        personasRepository.deleteById(id);

    }

    @Override
    public PersonaResponse searchPersonas(Long id) {
        Personas personas = personasRepository.searchPersonas(id);

        return (Objects.nonNull(personas)) ?
                buildPersonaResponse(personas):
                PersonaResponse.builder().build();
        }




    private static PersonaResponse buildPersonaResponse(Personas personas) {
        return PersonaResponse
                .builder()
                .id(personas.getId())
                .nombre(personas.getNombre())
                .apellido(personas.getApellido())
                .documentosResponse(buildDocumentoResponse(personas.getFk_documentos()))
                .tarjetaResponse(buildTarjetaResponse(personas.getFk_tarjetas()))
                .build();

    }

    @Override
    public void updatePersonas(PersonaRequest personaRequest) {

        if (Objects.nonNull(personaRequest)) {
            Optional<Personas> personas = personasRepository.findById(personaRequest.getId());
            if (personas.isPresent()){
                Personas personaActualizada =buildPersonaEntity(personaRequest);
                personasRepository.save(personaActualizada);
            }else {
                Personas personaGuardar =buildPersonaEntity(personaRequest);
                personasRepository.save(personaGuardar);

            }



        }

    }

    private static  Personas buildPersonaEntity(PersonaRequest personaRequest) {
        return Personas.builder()
                .id(personaRequest.getId())
                .nombre(personaRequest.getNombre())
                .apellido(personaRequest.getApellido())
                .fk_documentos(buildDocumentoEntity(personaRequest))
                .fk_tarjetas(buildTarjetasEntity(personaRequest))
                .build();
    }

    private static Tarjetas buildTarjetasEntity(PersonaRequest personaRequest) {
        return Tarjetas
                .builder()
                .id(personaRequest.getFk_tarjetas())
                .build();
    }

    private static Documentos buildDocumentoEntity(PersonaRequest personaRequest) {
        return Documentos.builder()
                .id(personaRequest.getFk_documentos())
                .build();
    }

    @Override
    public void savePersonas(PersonaRequest personaRequest) {
        Personas personas = new Personas();
        Documentos documentos = new Documentos();
        Tarjetas tarjetas = new Tarjetas();
        if (Objects.nonNull(personaRequest)) {
                documentos.setId(personaRequest.getFk_documentos());
                tarjetas.setId(personaRequest.getFk_tarjetas());
                personas.setNombre(personaRequest.getNombre());
                personas.setApellido(personaRequest.getApellido());
                personas.setFk_documentos(documentos);
                personas.setFk_tarjetas(tarjetas);
                personasRepository.save(personas);


        }

    }

    private static DocumentoResponse buildDocumentoResponse(Documentos documentos){
        return DocumentoResponse.builder()
                .id(documentos.getId())
                .tipo_documento(documentos.getTipo_documento())
                .build();

    }

    private static TarjetaResponse buildTarjetaResponse(Tarjetas tarjetas){
        return TarjetaResponse
                .builder()
                .id(tarjetas.getId())
                .banco(tarjetas.getBanco())
                .saldoResponse(SaldoResponse
                        .builder()
                        .id(tarjetas.getFk_saldo().getId())
                        .build())
                .build();

    }

}
