package com.administrador.entitys.repository;

import com.administrador.entitys.Gastos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GastosRepository extends JpaRepository<Gastos, Long> {
    @Query(value = "SELECT * FROM gastos", nativeQuery = true)
    List<Gastos> listGastos();

    @Query(value = "SELECT * FROM gastos WHERE id=:id", nativeQuery = true)
    Gastos searchGastos  (@Param(value = "id")Long id);
}
