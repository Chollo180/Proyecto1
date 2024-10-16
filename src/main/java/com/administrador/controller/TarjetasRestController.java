package com.administrador.controller;

import com.administrador.entitys.Documentos;
import com.administrador.entitys.Tarjetas;
import com.administrador.services.service.TarjetasService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class TarjetasRestController {
    private final TarjetasService tarjetasService;

    public ResponseEntity<List<Tarjetas>> listResponseAPi(){
        List<Tarjetas> tarjetasList = tarjetasService.getListTarjetas();
        return new ResponseEntity<>(tarjetasList, HttpStatus.ACCEPTED);
    }

}
