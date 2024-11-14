package com.administrador.services.service;

import com.administrador.controller.request.SaldoRequest;
import com.administrador.controller.response.SaldoResponse;
import com.administrador.entitys.Saldos;

import java.util.List;

public interface SaldosService {
    List<Saldos> getListSaldos();
    void deleteSaldos(Long id);
    SaldoResponse searchSaldos(Long id);
    void updateSaldos(SaldoRequest saldoRequest);
    void saveSaldos(SaldoRequest saldoRequest);
}
