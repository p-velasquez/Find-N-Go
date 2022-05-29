package com.findngo.findngo.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "horario", indexes = {
        @Index(name = "ID_ED", columnList = "ID_ED")
})
public class Horario {
    @Id
    @Getter @Setter @Column(name = "ID_HORARIO", nullable = false)
    private Integer id;

    @Getter @Setter @Column(name = "APERTURA", nullable = false)
    private LocalTime apertura;

    @Getter @Setter @Column(name = "CIERRE", nullable = false)
    private LocalTime cierre;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @Getter @Setter @JoinColumn(name = "ID_ED", nullable = false)
    private Espaciodeportivo idEd;

}