package com.administrador.services;

import com.administrador.controller.request.TarjetaRequest;
import com.administrador.controller.response.SaldoResponse;
import com.administrador.controller.response.TarjetaResponse;
import com.administrador.entitys.Saldos;
import com.administrador.entitys.Tarjetas;
import com.administrador.entitys.repository.TarjetasRepository;
import com.administrador.services.service.TarjetasService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TarjetasServiceImplement implements TarjetasService {

    private final TarjetasRepository tarjetasRepository;


    @Override
    public List<Tarjetas> getListTarjetas() {
        List<Tarjetas> listTarjetas= tarjetasRepository.listTarjetas();
        return listTarjetas;
    }

    @Override
    public void deleteTarjeta(Long id) {
        tarjetasRepository.deleteById(id);
    }

    @Override
    public TarjetaResponse searchTarjeta(Long id) {
        Tarjetas tarjetas = tarjetasRepository.searchTarjetas(id);

        return  (Objects.nonNull(tarjetas))?
                buildTarjetaResponse(tarjetas):
                TarjetaResponse.builder().build();

    }



    @Override
    public void updateTarjeta(TarjetaRequest tarjetaRequest) {
        if (Objects.nonNull(tarjetaRequest)){
            Optional<Tarjetas> tarjetas= tarjetasRepository.findById(tarjetaRequest.getId());
            if (tarjetas.isPresent()){
                Tarjetas tarjetasActualizar = buildTarjetaEntity(tarjetaRequest);
                tarjetasRepository.save(tarjetasActualizar);
            }else{
                Tarjetas tarjetasGuardar = buildTarjetaEntity(tarjetaRequest);
                tarjetasRepository.save(tarjetasGuardar);
            }


        }



    }



    @Override
    public void saveTarjeta(TarjetaRequest tarjetaRequest) {
        Tarjetas tarjetas = new Tarjetas();
        Saldos saldos = new Saldos();
        if (Objects.nonNull(tarjetaRequest)){
            saldos.setId(tarjetaRequest.getFk_saldo());
            tarjetas.setBanco(tarjetaRequest.getBanco());
            tarjetas.setFk_saldo(saldos);
            tarjetasRepository.save(tarjetas);
        }



    }




    private static TarjetaResponse buildTarjetaResponse(Tarjetas tarjetas) {
        return TarjetaResponse
                .builder()
                .id(tarjetas.getId())
                .banco(tarjetas.getBanco())
                .saldoResponse(buildSaldoResponseEntity(tarjetas))
                .build();
    }

    private static SaldoResponse buildSaldoResponseEntity(Tarjetas tarjetas) {
        return SaldoResponse
                .builder()
                .id(tarjetas.getFk_saldo().getId())
                .monto(tarjetas.getFk_saldo().getMonto())
                .build();
    }



    private static Tarjetas buildTarjetaEntity(TarjetaRequest tarjetaRequest) {
        return Tarjetas.builder()
                .id(tarjetaRequest.getId())
                .banco(tarjetaRequest.getBanco())
                .fk_saldo(buildSaldoEntity(tarjetaRequest))
                .build();
    }

    private static Saldos buildSaldoEntity(TarjetaRequest tarjetaRequest) {
        return Saldos.builder()
                .id(tarjetaRequest.getFk_saldo())
                .build();
    }
}
