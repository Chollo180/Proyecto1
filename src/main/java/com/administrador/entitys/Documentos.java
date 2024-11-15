package com.administrador.entitys;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "documentos")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Documentos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "tipo_documento")
    private String tipo_documento;
}
