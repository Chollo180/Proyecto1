package com.administrador.entitys;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tarjetas")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor


public class Tarjetas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "banco")
    private String banco;

    @ManyToOne
    @JoinColumn(name = "fk_saldo", referencedColumnName = "id")
    private Saldos fk_saldo;



}
