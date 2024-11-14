package com.administrador.entitys.repository;

import com.administrador.entitys.Saldos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SaldosRepository extends JpaRepository<Saldos, Long> {
    @Query(value = "SELECT * FROM saldos", nativeQuery = true)
    List<Saldos> listSaldos();

    @Query (value = "SELECT * FROM saldos WHERE id=:id", nativeQuery = true)
    Saldos searchSaldos (@Param(value = "id")Long id);
}
