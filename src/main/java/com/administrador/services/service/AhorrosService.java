package com.administrador.services.service;

import com.administrador.controller.request.AhorroRequest;
import com.administrador.controller.response.AhorroResponse;
import com.administrador.entitys.Ahorros;

import java.util.List;

public interface AhorrosService {
    List<Ahorros> getListAhorros();
    void deleteAhorros(Long id);
    AhorroResponse searchAhorros(Long id);
    void updateAhorros(AhorroRequest ahorroRequest);
    void saveAhorros(AhorroRequest ahorroRequest);
}
