package com.findngo.findngo.models;

import javax.persistence.*;

@Entity
@Table(name = "calificacion", indexes = {
        @Index(name = "ID_USUARIO", columnList = "ID_USUARIO"),
        @Index(name = "ID_ED", columnList = "ID_ED")
})
public class Calificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CALIFICACION", nullable = false)
    private Integer id;

    @Column(name = "NOTA", nullable = false)
    private Integer nota;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_USUARIO", nullable = false)
    private Usuario idUsuario;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_ED", nullable = false)
    private Espaciodeportivo idEd;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Espaciodeportivo getIdEd() {
        return idEd;
    }

    public void setIdEd(Espaciodeportivo idEd) {
        this.idEd = idEd;
    }

}