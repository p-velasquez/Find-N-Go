package com.findngo.findngo.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "direccion")
public class Direccion {
    @Id
    @Getter @Setter @Column(name = "ID_DIRECCION", nullable = false)
    private Integer id;

    @Getter @Setter @Column(name = "CALLE", nullable = false)
    private String calle;

    @Getter @Setter @Column(name = "NUMERO", nullable = false)
    private Integer numero;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @Getter @Setter @JoinColumn(name = "ID_COMUNA", nullable = false)
    private Comuna idComuna;

    @OneToMany(mappedBy = "idDireccion")
    @Getter @Setter
    private Set<Recinto> recintos = new LinkedHashSet<>();

}