package com.administrador.entitys.repository;

import com.administrador.entitys.Tarjetas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TarjetasRepository extends JpaRepository<Tarjetas, Long> {
    @Query(value = "SELECT * FROM tarjetas", nativeQuery = true)
    List<Tarjetas> listTarjetas();

}
