package com.findngo.findngo.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "recinto", indexes = {
        @Index(name = "ID_DIRECCION", columnList = "ID_DIRECCION", unique = true)
})
public class Recinto {
    @Id
    @Getter @Setter @Column(name = "ID_RECINTO", nullable = false)
    private Integer id;

    @Getter @Setter @Column(name = "NOMBRE", nullable = false)
    private String nombre;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @Getter @Setter @JoinColumn(name = "ID_DIRECCION", nullable = false)
    private Direccion idDireccion;

}