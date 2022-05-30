package com.findngo.findngo.models;

import javax.persistence.*;

@Entity
@Table(name = "espaciodeportivo", indexes = {
        @Index(name = "ID_RECINTO", columnList = "ID_RECINTO"),
        @Index(name = "ID_USUARIO", columnList = "ID_USUARIO"),
        @Index(name = "ID_DEPORTE", columnList = "ID_DEPORTE")
})
public class Espaciodeportivo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ED", nullable = false)
    private Integer id;

    @Column(name = "VALOR", nullable = false)
    private Integer valor;

    @Column(name = "CANTIDAD", nullable = false)
    private Integer cantidad;

    @Column(name = "FOTO")
    private byte[] foto;

    @Column(name = "DESCRIPCION", nullable = false, length = 250)
    private String descripcion;

    @Column(name = "TIEMPO_BLOQUE", nullable = false)
    private Integer tiempoBloque;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_USUARIO", nullable = false)
    private Usuario idUsuario;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_RECINTO", nullable = false)
    private Recinto idRecinto;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_DEPORTE", nullable = false)
    private Deporte idDeporte;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getTiempoBloque() {
        return tiempoBloque;
    }

    public void setTiempoBloque(Integer tiempoBloque) {
        this.tiempoBloque = tiempoBloque;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Recinto getIdRecinto() {
        return idRecinto;
    }

    public void setIdRecinto(Recinto idRecinto) {
        this.idRecinto = idRecinto;
    }

    public Deporte getIdDeporte() {
        return idDeporte;
    }

    public void setIdDeporte(Deporte idDeporte) {
        this.idDeporte = idDeporte;
    }

}