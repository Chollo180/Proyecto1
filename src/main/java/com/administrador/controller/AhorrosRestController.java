package com.administrador.controller;

import com.administrador.controller.request.AhorroRequest;
import com.administrador.controller.response.AhorroResponse;
import com.administrador.controller.response.DocumentoResponse;
import com.administrador.entitys.Ahorros;
import com.administrador.services.service.AhorrosService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/ahorros")
@RequiredArgsConstructor
public class AhorrosRestController {

    private final AhorrosService ahorrosService;

    @GetMapping(value = "/list")
    public ResponseEntity<List<Ahorros>> listAhorrosApi(){
        List<Ahorros> ahorrosList = ahorrosService.getListAhorros();
        return new ResponseEntity<>(ahorrosList, HttpStatus.ACCEPTED);
    }


    @GetMapping(value = "/delete")
    public ResponseEntity<String> deleteResponseApi(@RequestParam(value = "id") Long id){
        ahorrosService.deleteAhorros(id);
        return ResponseEntity.accepted().body("La accion se realizo con exito");
    }


    @GetMapping(value = "/search{id}")
    public ResponseEntity<AhorroResponse> searchResponseApi(Long id){
        AhorroResponse ahorroResponse = ahorrosService.searchAhorros(id);
        return ResponseEntity.accepted().body(ahorroResponse);
    }




    @PostMapping("/update")
    public ResponseEntity<String> updateResponseApi(@RequestBody AhorroRequest ahorroRequest){
        ahorrosService.updateAhorros( ahorroRequest);
        return ResponseEntity.accepted().body(null);
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveResponseApi(@RequestBody AhorroRequest ahorroRequest){

        return ResponseEntity.accepted().body(null);
    }
}
