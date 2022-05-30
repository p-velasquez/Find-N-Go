package com.findngo.findngo.models;

import javax.persistence.*;

@Entity
@Table(name = "recinto", indexes = {
        @Index(name = "ID_DIRECCION", columnList = "ID_DIRECCION", unique = true)
})
public class Recinto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_RECINTO", nullable = false)
    private Integer id;

    @Column(name = "NOMBRE", nullable = false)
    private String nombre;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_DIRECCION", nullable = false)
    private Direccion idDireccion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Direccion getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(Direccion idDireccion) {
        this.idDireccion = idDireccion;
    }

}