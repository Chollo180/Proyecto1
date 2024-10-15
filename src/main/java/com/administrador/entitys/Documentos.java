package com.administrador.entitys;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "documentos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Documentos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "siglas")
    private String siglas;

    @Column(name = "tipo_documento")
    private String tipo_documento;
}
