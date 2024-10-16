package com.administrador.entitys.repository;

import com.administrador.entitys.Documentos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DocumentosRepository extends JpaRepository<Documentos, Long> {
    @Query(value = "SELECT * FROM documentos", nativeQuery = true)
    List<Documentos> listDocumentos();

}
