package com.administrador.controller;

import com.administrador.entitys.Personas;
import com.administrador.services.service.PersonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(name = "v1/person")
@RequiredArgsConstructor
public class PersonaRestController {

    private final PersonaService personaService;

    @GetMapping(name = "/list")
    public ResponseEntity<List<Personas>> listPersonasApi(){
        List<Personas> personaList = personaService.getListPersons();
        return new ResponseEntity<>(personaList, HttpStatus.ACCEPTED);
    }
}
