package com.administrador.controller;

import com.administrador.controller.request.PersonaRequest;
import com.administrador.controller.response.PersonaResponse;
import com.administrador.entitys.Personas;
import com.administrador.services.service.PersonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/person")
@RequiredArgsConstructor
public class PersonaRestController {

    private final PersonaService personaService;

    @GetMapping(value = "/list")
    public ResponseEntity<List<Personas>> listPersonasApi(){
        List<Personas> personaList = personaService.getListPersons();
        return new ResponseEntity<>(personaList, HttpStatus.ACCEPTED);

    }


    @GetMapping(value = "/delete")
    public ResponseEntity<String> deletePersonasApi(@RequestParam (name = "id") Long id){
        personaService.deletePersonas(id);
        return ResponseEntity.accepted().body("La accion se realizo");
    }

    @GetMapping(value = "/search/{id}")
    public ResponseEntity<PersonaResponse> searchPersonasApi(Long id){
        PersonaResponse personaResponse = personaService.searchPersonas(id);
        return ResponseEntity.accepted().body(personaResponse);

    }

    @PostMapping(value = "/update")
    public ResponseEntity<String> updatePersonasApi(@RequestBody PersonaRequest personaRequest){
        personaService.updatePersonas(personaRequest);
        return ResponseEntity.accepted().body("La accion se realizo");
    }

    @PostMapping(value = "/save")
    public ResponseEntity<String> savePersonasApi(@RequestBody PersonaRequest personaRequest){
        personaService.savePersonas(personaRequest);
        return ResponseEntity.accepted().body("La accion se realizo");
    }

}
