package com.findngo.findngo.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Recinto")

public class Recinto {
    @Id
    @Getter @Setter @Column(name = "id_recinto")
    private Long id;

    @Getter @Setter @Column(name = "nombre")
    private String nombre;

    @Getter @Setter @Column(name = "estado")
    private String estado;

    @Getter @Setter @Column(name = "direccion")
    private String direccion;

}
