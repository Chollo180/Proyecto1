package com.administrador.entitys.repository;

import com.administrador.entitys.Personas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonasRepository extends JpaRepository<Personas, Long> {
    @Query(value = "SELECT * FROM personas", nativeQuery = true)
    List<Personas> listPersonas();

    @Query(value = "SELECT * FROM personas WHERE id=:id", nativeQuery = true)
    Personas searchPersonas(@Param(value = "id") Long id);


}
