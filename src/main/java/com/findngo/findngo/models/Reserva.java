package com.findngo.findngo.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "reserva", indexes = {
        @Index(name = "ID_USUARIO", columnList = "ID_USUARIO"),
        @Index(name = "ID_ED", columnList = "ID_ED")
})
public class Reserva {
    @Id
    @Getter @Setter @Column(name = "ID_RESERVA", nullable = false)
    private Integer id;

    @Getter @Setter @Column(name = "FECHA", nullable = false)
    private LocalDate fecha;

    @Getter @Setter @Column(name = "HORA_INICIO", nullable = false)
    private LocalTime horaInicio;

    @Getter @Setter @Column(name = "HORA_TERMINO", nullable = false)
    private LocalTime horaTermino;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @Getter @Setter @JoinColumn(name = "ID_ED", nullable = false)
    private Espaciodeportivo idEd;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @Getter @Setter @JoinColumn(name = "ID_USUARIO", nullable = false)
    private Usuario idUsuario;

}