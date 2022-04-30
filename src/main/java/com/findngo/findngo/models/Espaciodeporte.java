package com.findngo.findngo.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "espaciodeporte")
public class Espaciodeporte {
    @Id
    @Getter @Setter @Column(name = "ID_ESPACIODEPORTE", nullable = false)
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    @Getter @Setter @JoinColumn(name = "ID_ED")
    private Espaciodeportivo idEd;

    @ManyToOne(fetch = FetchType.LAZY)
    @Getter @Setter @JoinColumn(name = "ID_DEPORTE")
    private Deporte idDeporte;

}