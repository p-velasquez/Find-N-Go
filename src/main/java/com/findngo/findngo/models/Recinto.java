package com.findngo.findngo.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "recinto", indexes = {
        @Index(name = "ID_DIRECCION", columnList = "ID_DIRECCION")
})
public class Recinto {
    @Id
    @Getter @Setter @Column(name = "ID_RECINTO", nullable = false)
    private Integer id;

    @Getter @Setter @Column(name = "NOMBRE", nullable = false)
    private String nombre;

    @Getter @Setter @Column(name = "ESTADO", nullable = false)
    private Integer estado;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @Getter @Setter @JoinColumn(name = "ID_DIRECCION", nullable = false)
    private Direccion idDireccion;

    @OneToMany(mappedBy = "idRecinto")
    @Getter @Setter
    private Set<Espaciodeportivo> espaciodeportivos = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idRecinto")
    @Getter @Setter
    private Set<Solicitud> solicituds = new LinkedHashSet<>();
}