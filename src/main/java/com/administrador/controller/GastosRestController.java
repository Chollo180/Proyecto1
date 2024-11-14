package com.administrador.controller;

import com.administrador.controller.request.GastoRequest;
import com.administrador.controller.response.GastoResponse;
import com.administrador.entitys.Gastos;
import com.administrador.services.service.GastosService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "v1/gastos")
@RequiredArgsConstructor
public class GastosRestController {
    private final GastosService gastosService;

    @GetMapping(value = "/list")
    public ResponseEntity<List<Gastos>> listGastoApi(){
        List<Gastos> gastosList = gastosService.getListGastos();
        return new ResponseEntity<>(gastosList, HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/delete")
    public ResponseEntity<String> deleteGastoApi(@Param(value = "id")Long id){
        gastosService.deleteGastos(id);
        return ResponseEntity.accepted().body("La accion se realizo con exito");
    }

    @GetMapping(value = "/search/{id}")
    public ResponseEntity<GastoResponse> searchGastoApi(Long id){
        GastoResponse gastoResponse = gastosService.searchGastos(id);
        return ResponseEntity.accepted().body(gastoResponse);
    }

    @PostMapping(value = "/update")
    public ResponseEntity<String> updateGastoApi(@RequestBody GastoRequest gastoRequest){
        gastosService.updateGastos(gastoRequest);
        return ResponseEntity.accepted().body("La accion se realizo con exito");
    }

    @PostMapping(value = "/save")
    public ResponseEntity<String> saveGastoApi(@RequestBody GastoRequest gastoRequest){
        gastosService.saveGastos(gastoRequest);
        return ResponseEntity.accepted().body("La accion se realizo con exito");
    }
}
