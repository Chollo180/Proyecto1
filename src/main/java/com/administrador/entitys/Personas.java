package com.administrador.entitys;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "personas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Personas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "documento")
    private String documento;

    @Column(name = "correo")
    private String correo;

    @Column(name = "celular")
    private String celular;

    @Column(name = "edad")
    private int edad;


    @ManyToOne
    @JoinColumn(name = "fk_documentos", referencedColumnName = "id")
    private Documentos fk_documentos;

    @Column(name = "fk_tarjetas")
    private Long fk_tarjetas;
}
