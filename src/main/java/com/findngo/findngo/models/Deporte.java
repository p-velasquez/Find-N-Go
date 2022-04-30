package com.findngo.findngo.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "deporte")
public class Deporte {
    @Id
    @Getter @Setter @Column(name = "ID_DEPORTE", nullable = false)
    private Integer id;

    @Getter @Setter @Column(name = "NOMBRE", nullable = false)
    private String nombre;

    @Getter @Setter @OneToMany(mappedBy = "idDeporte")
    private Set<Espaciodeporte> espaciodeportes = new LinkedHashSet<>();
}