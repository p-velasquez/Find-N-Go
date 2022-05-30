package com.findngo.findngo.models;

import javax.persistence.*;

@Entity
@Table(name = "dia", indexes = {
        @Index(name = "ID_HORARIO", columnList = "ID_HORARIO")
})
public class Dia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DIA", nullable = false)
    private Integer id;

    @Column(name = "NOMBRE", nullable = false, length = 250)
    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_HORARIO", nullable = false)
    private Horario idHorario;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Horario getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(Horario idHorario) {
        this.idHorario = idHorario;
    }

}