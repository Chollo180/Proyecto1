package com.administrador.entitys.repository;

import com.administrador.entitys.Personas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonasRepository extends JpaRepository<Personas, Long> {
    @Query(value = "SELECT * FROM personas", nativeQuery = true)
    List<Personas> listPersonas();

    @Override
    List<Personas> findAll();
}
