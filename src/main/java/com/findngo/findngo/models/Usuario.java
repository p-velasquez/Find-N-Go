package com.findngo.findngo.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @Getter @Setter @Column(name = "ID_USUARIO", nullable = false)
    private Integer id;

    @Getter @Setter @Column(name = "TIPO", nullable = false)
    private Integer tipo;

    @Getter @Setter @Column(name = "CORREO", nullable = false)
    private String correo;

    @Getter @Setter @Column(name = "CONTRASENA", nullable = false)
    private String contrasena;

}