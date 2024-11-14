package com.administrador.controller;

import com.administrador.controller.request.TarjetaRequest;
import com.administrador.controller.response.TarjetaResponse;
import com.administrador.entitys.Tarjetas;
import com.administrador.services.service.TarjetasService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/tarjetas")
@RequiredArgsConstructor
public class TarjetasRestController {
    private final TarjetasService tarjetasService;

    @GetMapping(value = "/list")
    public ResponseEntity<List<Tarjetas>> listTarjetaAPi(){
        List<Tarjetas> tarjetasList = tarjetasService.getListTarjetas();
        return new ResponseEntity<>(tarjetasList, HttpStatus.ACCEPTED);
    }



    @GetMapping(value = "/delete")
    public ResponseEntity<String> deleteTarjetaAPi(@RequestParam (value = "id") Long id){
        tarjetasService.deleteTarjeta(id);
        return ResponseEntity.accepted().body("La accion se realizo");
    }



    @GetMapping(value = "/search{id}")
    public ResponseEntity<TarjetaResponse> searchTarjetaAPi(Long id){
        TarjetaResponse tarjetaResponse = tarjetasService.searchTarjeta(id);
        return ResponseEntity.accepted().body(tarjetaResponse);
    }



    @PostMapping(value = "/update")
    public ResponseEntity<String> updateTarjetaAPi(@RequestBody TarjetaRequest tarjetaRequest){
        tarjetasService.updateTarjeta(tarjetaRequest);
        return ResponseEntity.accepted().body("La accion se realizo");
    }


    @PostMapping (value = "/save")
    public ResponseEntity<String>saveTarjetaAPi(@RequestBody TarjetaRequest tarjetaRequest){
        tarjetasService.saveTarjeta(tarjetaRequest);
        return ResponseEntity.accepted().body("La accion se realizo");    }

}
