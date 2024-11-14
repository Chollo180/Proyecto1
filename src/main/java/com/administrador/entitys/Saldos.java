package com.administrador.entitys;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "saldos")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Saldos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = ("monto_total"))
    private Float monto;

    @ManyToOne
    @JoinColumn(name = "fk_gastos", referencedColumnName = "id")
    private  Gastos fk_gastos;

    @ManyToOne
    @JoinColumn(name = "fk_ahorros", referencedColumnName = "id")
    private  Ahorros fk_ahorros;


}
