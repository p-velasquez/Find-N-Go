package com.findngo.findngo.models;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "horario", indexes = {
        @Index(name = "ID_ED", columnList = "ID_ED")
})
public class Horario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_HORARIO", nullable = false)
    private Integer id;

    @Column(name = "APERTURA", nullable = false)
    private LocalTime apertura;

    @Column(name = "CIERRE", nullable = false)
    private LocalTime cierre;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_ED", nullable = false)
    private Espaciodeportivo idEd;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalTime getApertura() {
        return apertura;
    }

    public void setApertura(LocalTime apertura) {
        this.apertura = apertura;
    }

    public LocalTime getCierre() {
        return cierre;
    }

    public void setCierre(LocalTime cierre) {
        this.cierre = cierre;
    }

    public Espaciodeportivo getIdEd() {
        return idEd;
    }

    public void setIdEd(Espaciodeportivo idEd) {
        this.idEd = idEd;
    }

}