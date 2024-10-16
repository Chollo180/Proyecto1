package com.administrador.services;

import com.administrador.entitys.Documentos;
import com.administrador.entitys.Tarjetas;
import com.administrador.entitys.repository.TarjetasRepository;
import com.administrador.services.service.TarjetasService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TarjetasServiceImplement implements TarjetasService {

    private final TarjetasRepository tarjetasRepository;


    @Override
    public List<Tarjetas> getListTarjetas() {
        List<Tarjetas> listDocumentos= tarjetasRepository.listTarjetas();
        return listDocumentos;
    }
}
