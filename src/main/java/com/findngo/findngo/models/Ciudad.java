package com.findngo.findngo.models;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "ciudad")
public class Ciudad {
    @Id
    @Column(name = "ID_CIUDAD", nullable = false)
    private Integer id;

    @Column(name = "NOMBRE", nullable = false)
    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_REGION", nullable = false)
    private Region idRegion;

    @OneToMany(mappedBy = "idCiudad")
    private Set<Comuna> comunas = new LinkedHashSet<>();

    public Set<Comuna> getComunas() {
        return comunas;
    }

    public void setComunas(Set<Comuna> comunas) {
        this.comunas = comunas;
    }

    public Region getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(Region idRegion) {
        this.idRegion = idRegion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}