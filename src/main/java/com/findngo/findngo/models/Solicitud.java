package com.findngo.findngo.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "solicitud", indexes = {
        @Index(name = "ID_RECINTO", columnList = "ID_RECINTO"),
        @Index(name = "ID_USUARIO", columnList = "ID_USUARIO")
})
public class Solicitud {
    @Id
    @Getter @Setter @Column(name = "ID_SOLICITUD", nullable = false)
    private Integer id;

    @Getter @Setter @Column(name = "TIPO", nullable = false)
    private Integer tipo;

    @Getter @Setter @Column(name = "DETALLE", nullable = false)
    private String detalle;

    @Getter @Setter @Column(name = "ESTADO", nullable = false)
    private Integer estado;

    @Getter @Setter @Column(name = "FECHA", nullable = false)
    private LocalDate fecha;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @Getter @Setter @JoinColumn(name = "ID_USUARIO", nullable = false)
    private Usuario idUsuario;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @Getter @Setter @JoinColumn(name = "ID_RECINTO", nullable = false)
    private Recinto idRecinto;

}