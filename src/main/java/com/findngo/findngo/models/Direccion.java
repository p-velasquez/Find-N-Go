package com.findngo.findngo.models;

import javax.persistence.*;

@Entity
@Table(name = "direccion", indexes = {
        @Index(name = "ID_COMUNA", columnList = "ID_COMUNA")
})
public class Direccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DIRECCION", nullable = false)
    private Integer id;

    @Column(name = "CALLE", nullable = false)
    private String calle;

    @Column(name = "NUMERO", nullable = false)
    private Integer numero;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_COMUNA", nullable = false)
    private Comuna idComuna;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Comuna getIdComuna() {
        return idComuna;
    }

    public void setIdComuna(Comuna idComuna) {
        this.idComuna = idComuna;
    }

}