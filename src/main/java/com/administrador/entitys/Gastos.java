package com.administrador.entitys;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "gastos")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Gastos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  Long id;

    @Column(name = "consumo")
    private Long consumo;

    @Column(name = "descripcion")
    private String descripcion;
}



