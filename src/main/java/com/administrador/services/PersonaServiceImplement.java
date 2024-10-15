package com.administrador.services;

import com.administrador.entitys.Personas;
import com.administrador.entitys.repository.PersonasRepository;
import com.administrador.services.service.PersonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonaServiceImplement implements PersonaService {

    private final PersonasRepository personasRepository;


    @Override
    public List<Personas> getListPersons() {
        List<Personas> listPersonas= personasRepository.listPersonas();
        return listPersonas;
    }
}
