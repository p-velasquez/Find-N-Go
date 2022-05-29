package com.findngo.findngo.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "espaciodeportivo", indexes = {
        @Index(name = "ID_RECINTO", columnList = "ID_RECINTO"),
        @Index(name = "ID_USUARIO", columnList = "ID_USUARIO"),
        @Index(name = "ID_DEPORTE", columnList = "ID_DEPORTE")
})
public class Espaciodeportivo {
    @Id
    @Getter @Setter @Column(name = "ID_ED", nullable = false)
    private Integer id;

    @Getter @Setter @Column(name = "APERTURA", nullable = false)
    private LocalTime apertura;

    @Getter @Setter @Column(name = "CIERRE", nullable = false)
    private LocalTime cierre;

    @Getter @Setter @Column(name = "VALOR", nullable = false)
    private Integer valor;

    @Getter @Setter @Column(name = "FOTO", nullable = false)
    private byte[] foto;

    @Getter @Setter @Column(name = "DESCRIPCION", nullable = false, length = 250)
    private String descripcion;

    @Getter @Setter @Column(name = "TIEMPO_BLOQUE", nullable = false)
    private LocalTime tiempoBloque;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @Getter @Setter @JoinColumn(name = "ID_USUARIO", nullable = false)
    private Usuario idUsuario;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_RECINTO", nullable = false)
    private Recinto idRecinto;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_DEPORTE", nullable = false)
    private Deporte idDeporte;

}