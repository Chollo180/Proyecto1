package com.administrador.entitys;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ahorros")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Ahorros {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  Long id;

    @Column(name = "capital")
    private Float capital;
}
