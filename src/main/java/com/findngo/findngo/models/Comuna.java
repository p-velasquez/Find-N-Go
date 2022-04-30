package com.findngo.findngo.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "comuna")
public class Comuna {
    @Id
    @Getter @Setter @Column(name = "ID_COMUNA", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @Getter @Setter @JoinColumn(name = "ID_CIUDAD")
    private Ciudad idCiudad;

    @Getter @Setter @Column(name = "NOMBRE", nullable = false)
    private String nombre;

    @Getter @Setter @OneToMany(mappedBy = "idComuna")
    private Set<Direccion> direccions = new LinkedHashSet<>();

}