package com.findngo.findngo.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "region")
public class Region {
    @Id
    @Getter @Setter @Column(name = "ID_REGION", nullable = false)
    private Integer id;

    @Getter @Setter @Column(name = "NOMBRE", nullable = false)
    private String nombre;

    @Getter @Setter @OneToMany(mappedBy = "idRegion")
    private Set<Ciudad> ciudads = new LinkedHashSet<>();

}