package com.administrador.services.service;

import com.administrador.controller.request.GastoRequest;
import com.administrador.controller.response.GastoResponse;
import com.administrador.entitys.Gastos;

import java.util.List;

public interface GastosService {
    List<Gastos> getListGastos();
    void deleteGastos(Long id);
    GastoResponse searchGastos(Long id);
    void updateGastos(GastoRequest gastoRequest);
    void saveGastos(GastoRequest gastoRequest);
}
