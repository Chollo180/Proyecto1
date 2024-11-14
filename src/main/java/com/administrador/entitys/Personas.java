package com.administrador.entitys;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "personas")
@Getter
@Builder
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Personas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombres")
    private String nombre;

    @Column(name = "apellidos")
    private String apellido;


    @ManyToOne
    @JoinColumn(name = "fk_documentos", referencedColumnName = "id")
    private Documentos fk_documentos;

    @ManyToOne
    @JoinColumn(name = "fk_tarjetas", referencedColumnName = "id")
    private Tarjetas fk_tarjetas;
}
