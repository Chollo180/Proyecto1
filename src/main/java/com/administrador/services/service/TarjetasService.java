package com.administrador.services.service;

import com.administrador.controller.request.TarjetaRequest;
import com.administrador.controller.response.TarjetaResponse;
import com.administrador.entitys.Tarjetas;

import java.util.List;

public interface TarjetasService {
    List<Tarjetas> getListTarjetas();
    void deleteTarjeta(Long id);
    TarjetaResponse searchTarjeta(Long id);
    void updateTarjeta(TarjetaRequest tarjetaRequest);
    void saveTarjeta(TarjetaRequest tarjetaRequest);


}
