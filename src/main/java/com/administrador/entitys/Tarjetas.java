package com.administrador.entitys;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tarjetas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Tarjetas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "banco")
    private String banco;

    @Column(name = "saldo")
    private Long fk_saldo;

}
