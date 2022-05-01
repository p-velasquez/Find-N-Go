package com.findngo.findngo.models;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.LinkedHashSet;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name = "espaciodeportivo", indexes = {
        @Index(name = "ID_RECINTO", columnList = "ID_RECINTO"),
        @Index(name = "ID_USUARIO", columnList = "ID_USUARIO")
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

    @Getter @Setter @Column(name = "FOTO")
    private byte[] foto;

    @Getter @Setter @Column(name = "DESCRIPCION", nullable = false, length = 250)
    private String descripcion;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @Getter @Setter @JoinColumn(name = "ID_USUARIO", nullable = false)
    private Usuario idUsuario;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @Getter @Setter @JoinColumn(name = "ID_RECINTO", nullable = false)
    private Recinto idRecinto;

    @OneToMany(mappedBy = "idEd")
    @Getter @Setter
    private Set<Reserva> reservas = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idEd")
    @Getter @Setter
    private Set<Espaciodeporte> espaciodeportes = new LinkedHashSet<>();

}