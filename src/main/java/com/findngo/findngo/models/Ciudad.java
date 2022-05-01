package com.findngo.findngo.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "ciudad")
public class Ciudad {
    @Id
    @Getter @Setter @Column(name = "ID_CIUDAD", nullable = false)
    private Integer id;

    @Getter @Setter @Column(name = "NOMBRE", nullable = false)
    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @Getter @Setter @JoinColumn(name = "ID_REGION", nullable = false)
    private Region idRegion;

    @Getter @Setter @OneToMany(mappedBy = "idCiudad")
    private Set<Comuna> comunas = new LinkedHashSet<>();
}