package com.administrador.services.service;

import com.administrador.controller.request.PersonaRequest;
import com.administrador.controller.response.PersonaResponse;
import com.administrador.entitys.Personas;

import java.util.List;

public interface PersonaService {
    List<Personas> getListPersons();
    void deletePersonas(Long id);
    PersonaResponse searchPersonas(Long id);
    void updatePersonas(PersonaRequest personaRequest);
    void savePersonas(PersonaRequest personaRequest);


}
