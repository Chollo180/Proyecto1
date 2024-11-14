package com.administrador.services;

import com.administrador.controller.request.SaldoRequest;
import com.administrador.controller.response.AhorroResponse;
import com.administrador.controller.response.GastoResponse;
import com.administrador.controller.response.SaldoResponse;
import com.administrador.entitys.Ahorros;
import com.administrador.entitys.Gastos;
import com.administrador.entitys.Saldos;
import com.administrador.entitys.repository.SaldosRepository;
import com.administrador.services.service.SaldosService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SaldosServiceImplement implements SaldosService {

    private final SaldosRepository saldosRepository;


    @Override
    public List<Saldos> getListSaldos() {
        List<Saldos> listSaldos = saldosRepository.listSaldos();
        return listSaldos;
    }

    @Override
    public void deleteSaldos(Long id) {
        saldosRepository.deleteById(id);
    }

    @Override
    public SaldoResponse searchSaldos(Long id) {
        Saldos saldo = saldosRepository.searchSaldos(id);

         return (Objects.nonNull(saldo))?
            buildSaldoResponse(saldo):
            SaldoResponse.builder().build();
    }





    @Override
    public void updateSaldos(SaldoRequest saldoRequest) {

        if (Objects.nonNull(saldoRequest)){
            Optional<Saldos> saldos = saldosRepository.findById(saldoRequest.getId());
            if (saldos.isPresent()){
                Saldos saldoActualizado = buildSaldoEntity(saldoRequest);
                saldosRepository.save(saldoActualizado);
            }else {
                Saldos saldoGuardar =buildSaldoEntity(saldoRequest);
                saldosRepository.save(saldoGuardar);
            }
        }
    }



    @Override
    public void saveSaldos(SaldoRequest saldoRequest) {
        Saldos saldos = new Saldos();
        Gastos gastos = new Gastos();
        Ahorros ahorros = new Ahorros();
        if (Objects.nonNull(saldoRequest)){
            gastos.setId(saldoRequest.getId());
            ahorros.setId(saldoRequest.getId());
            saldos.setMonto(saldoRequest.getMonto());
            saldos.setFk_gastos(gastos);
            saldos.setFk_ahorros(ahorros);
            saldosRepository.save(saldos);
        }

    }





    private static SaldoResponse buildSaldoResponse(Saldos saldo) {
        return SaldoResponse
                .builder()
                .id(saldo.getId())
                .monto(saldo.getMonto())
                .gastoResponse(buildGastoResponse(saldo))
                .ahorroResponse(buildAhorroResponse(saldo))
                .build();
    }


    private static GastoResponse buildGastoResponse(Saldos saldo) {
        return GastoResponse
                .builder()
                .id(saldo.getFk_gastos().getId())
                .consumo(saldo.getFk_gastos().getConsumo())
                .descripcion(saldo.getFk_gastos().getDescripcion())
                .build();
    }

    private static AhorroResponse buildAhorroResponse(Saldos saldo) {
        return AhorroResponse
                .builder()
                .id(saldo.getFk_ahorros().getId())
                .capital(saldo.getFk_ahorros().getCapital())
                .build();
    }


    private static Saldos buildSaldoEntity(SaldoRequest saldoRequest) {
        return Saldos.builder()
                .monto(saldoRequest.getMonto())
                .fk_gastos(buildGastoEntity(saldoRequest))
                .fk_ahorros(buildAhorroEntity(saldoRequest))
                .build();
    }


    private static Gastos buildGastoEntity(SaldoRequest saldoRequest) {
        return Gastos.builder()
                .id(saldoRequest.getFk_gastos())
                .build();
    }

    private static Ahorros buildAhorroEntity(SaldoRequest saldoRequest) {
        return Ahorros.builder()
                .id(saldoRequest.getFk_ahorros())
                .build();
    }
}
