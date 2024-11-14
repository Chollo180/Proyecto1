package com.administrador.services;

import com.administrador.controller.request.AhorroRequest;
import com.administrador.controller.response.AhorroResponse;
import com.administrador.entitys.Ahorros;
import com.administrador.entitys.repository.AhorrosRepository;
import com.administrador.services.service.AhorrosService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AhorroServiceImplement implements AhorrosService {
    private final AhorrosRepository ahorrosRepository;


    @Override
    public List<Ahorros> getListAhorros() {
        List<Ahorros> listAhorros = ahorrosRepository.listAhorros();
        return  listAhorros;
    }

    @Override
    public void deleteAhorros(Long id) {
        ahorrosRepository.deleteById(id);
    }

    @Override
    public AhorroResponse searchAhorros(Long id) {
        Ahorros ahorros = ahorrosRepository.searchAhorros(id);
        return (Objects.nonNull(ahorros))?
                buildAhorroResponse(ahorros):
                AhorroResponse.builder().build();


    }




    @Override
    public void updateAhorros(AhorroRequest ahorroRequest) {
        if (Objects.nonNull(ahorroRequest)){
            Optional<Ahorros> ahorros = ahorrosRepository.findById(ahorroRequest.getId());
            if (ahorros.isPresent()) {
                Ahorros ahorroActualizado = buildAhorroEntity(ahorroRequest);
                ahorrosRepository.save(ahorroActualizado);
            }else{
                Ahorros ahorroGuardar = buildAhorroEntity(ahorroRequest);
                ahorrosRepository.save(ahorroGuardar);
            }


        }
    }

    private static Ahorros buildAhorroEntity(AhorroRequest ahorroRequest) {
        return Ahorros.builder()
                .id(ahorroRequest.getId())
                .capital(ahorroRequest.getCapital())
                .build();
    }

    @Override
    public void saveAhorros(AhorroRequest ahorroRequest) {
        Ahorros ahorros = new Ahorros();

        if (Objects.nonNull(ahorroRequest)){
            ahorros.setCapital(ahorroRequest.getCapital());
            ahorrosRepository.save(ahorros);
        }
    }


    private static AhorroResponse buildAhorroResponse(Ahorros ahorros) {
        return AhorroResponse
                .builder()
                .id(ahorros.getId())
                .capital(ahorros.getCapital())
                .build();
    }
}
