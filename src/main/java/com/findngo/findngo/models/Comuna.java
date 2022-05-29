package com.findngo.findngo.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "comuna", indexes = {
        @Index(name = "ID_CIUDAD", columnList = "ID_CIUDAD")
})
public class Comuna {
    @Id
    @Getter @Setter @Column(name = "ID_COMUNA", nullable = false)
    private Integer id;

    @Getter @Setter @Column(name = "NOMBRE", nullable = false)
    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @Getter @Setter @JoinColumn(name = "ID_CIUDAD", nullable = false)
    private Ciudad idCiudad;

}