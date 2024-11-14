package com.administrador.services;

import com.administrador.controller.request.GastoRequest;
import com.administrador.controller.response.GastoResponse;
import com.administrador.entitys.Gastos;
import com.administrador.entitys.repository.GastosRepository;
import com.administrador.services.service.GastosService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GastosServiceImplement implements GastosService {

    private final GastosRepository gastosRepository;

    @Override
    public List<Gastos> getListGastos() {
        List<Gastos> listGastos = gastosRepository.listGastos();
        return listGastos;
    }

    @Override
    public void deleteGastos(Long id) {
        gastosRepository.deleteById(id);
    }

    @Override
    public GastoResponse searchGastos(Long id) {
        Gastos gastos = gastosRepository.searchGastos(id);

        return (Objects.nonNull(gastos))?
                buildGastoResponse(gastos):
                GastoResponse.builder().build();

    }



    @Override
    public void updateGastos(GastoRequest gastoRequest) {
        if (Objects.nonNull(gastoRequest)){
            Optional<Gastos> gastos = gastosRepository.findById(gastoRequest.getId());
            if (gastos.isPresent()){
                Gastos gastoActualizado = buildGastoEntity(gastoRequest);
                gastosRepository.save(gastoActualizado);
            }else{
                Gastos gastoGuardar =  buildGastoEntity(gastoRequest);
                gastosRepository.save(gastoGuardar);
            }
        }

    }



    @Override
    public void saveGastos(GastoRequest gastoRequest) {
        Gastos gasto = new Gastos();
        if (Objects.nonNull(gastoRequest)){
            gasto.setConsumo(gastoRequest.getConsumo());
            gasto.setDescripcion(gastoRequest.getDescripcion());
            gastosRepository.save(gasto);
        }

    }


    private static GastoResponse buildGastoResponse(Gastos gastos) {
        return GastoResponse
                .builder()
                .id(gastos.getId())
                .consumo(gastos.getConsumo())
                .descripcion(gastos.getDescripcion())
                .build();
    }



    private static Gastos buildGastoEntity(GastoRequest gastoRequest) {
        return Gastos
                .builder()
                .id(gastoRequest.getId())
                .consumo(gastoRequest.getConsumo())
                .descripcion(gastoRequest.getDescripcion())
                .build();
    }
}
