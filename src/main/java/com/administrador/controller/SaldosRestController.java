package com.administrador.controller;

import com.administrador.controller.request.GastoRequest;
import com.administrador.controller.request.SaldoRequest;
import com.administrador.controller.response.SaldoResponse;
import com.administrador.entitys.Saldos;
import com.administrador.services.service.GastosService;
import com.administrador.services.service.SaldosService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/saldos")
@RequiredArgsConstructor
public class SaldosRestController {

    private final SaldosService saldosService;
    private final GastosService gastosService;


    @GetMapping(value = "/list")
    public ResponseEntity<List<Saldos>> listSaldosApi(){
        List<Saldos> saldosList = saldosService.getListSaldos();
        return new ResponseEntity<>(saldosList, HttpStatus.ACCEPTED);
    }



    @GetMapping(value = "/delete")
    public ResponseEntity<String> deleteSaldoApi(@RequestParam(name = "id") Long id){
        saldosService.deleteSaldos(id);
        return ResponseEntity.accepted().body("La accion se realizo con exito");
    }

    @GetMapping(value = "/search/{id}")
    public ResponseEntity<SaldoResponse> searchSaldoApi(Long id){
        SaldoResponse saldoResponse =saldosService.searchSaldos(id);
        return ResponseEntity.accepted().body(saldoResponse);

    }

    @PostMapping(value = "/update")
    public ResponseEntity<String> updateSaldoApi(@RequestBody SaldoRequest saldoRequest){
        saldosService.updateSaldos(saldoRequest);
        return ResponseEntity.accepted().body("La accion se realizo con exito");
    }

    @PostMapping(value = "/save")
    public ResponseEntity<String> saveSaldoApi(@RequestBody SaldoRequest saldoRequest){
        saldosService.saveSaldos(saldoRequest);
        return ResponseEntity.accepted().body("La accion se realizo con exito");
    }

    public ResponseEntity<String> saveGastoApi(@RequestBody GastoRequest gastoRequest){
    gastosService.saveGastos(gastoRequest);
    return ResponseEntity.accepted().body("");
    }
}

