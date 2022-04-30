package com.findngo.findngo.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @Getter @Setter @Column(name = "ID_USUARIO", nullable = false)
    private Integer id;

    @Getter @Setter @Column(name = "TIPO", nullable = false)
    private Integer tipo;

    @Getter @Setter @Column(name = "ESTADO", nullable = false)
    private Integer estado;

    @Getter @Setter @Column(name = "CORREO", nullable = false)
    private String correo;

    @Getter @Setter @Column(name = "CONTRASENA", nullable = false)
    private String contrasena;

    @OneToMany(mappedBy = "idUsuario")
    @Getter @Setter
    private Set<Espaciodeportivo> espaciodeportivos = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idUsuario")
    @Getter @Setter
    private Set<Reserva> reservas = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idUsuario")
    @Getter @Setter
    private Set<Solicitud> solicituds = new LinkedHashSet<>();
}