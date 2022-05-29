package com.findngo.findngo.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "dia", indexes = {
        @Index(name = "ID_HORARIO", columnList = "ID_HORARIO")
})
public class Dia {
    @Id
    @Getter @Setter @Column(name = "ID_DIA", nullable = false)
    private Integer id;

    @Getter @Setter @Column(name = "NOMBRE", nullable = false, length = 250)
    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @Getter @Setter @JoinColumn(name = "ID_HORARIO", nullable = false)
    private Horario idHorario;

}