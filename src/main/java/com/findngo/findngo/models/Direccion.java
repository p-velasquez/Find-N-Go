package com.findngo.findngo.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "direccion", indexes = {
        @Index(name = "ID_COMUNA", columnList = "ID_COMUNA")
})
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

}