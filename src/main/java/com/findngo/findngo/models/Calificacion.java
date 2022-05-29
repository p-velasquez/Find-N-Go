package com.findngo.findngo.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "calificacion", indexes = {
        @Index(name = "ID_USUARIO", columnList = "ID_USUARIO"),
        @Index(name = "ID_ED", columnList = "ID_ED")
})
public class Calificacion {
    @Id
    @Getter @Setter @Column(name = "ID_CALIFICACION", nullable = false)
    private Integer id;

    @Getter @Setter @Column(name = "NOTA", nullable = false)
    private Integer nota;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @Getter @Setter @JoinColumn(name = "ID_USUARIO", nullable = false)
    private Usuario idUsuario;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @Getter @Setter @JoinColumn(name = "ID_ED", nullable = false)
    private Espaciodeportivo idEd;


}