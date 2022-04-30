package com.findngo.findngo.models;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "espaciodeportivo")
public class Espaciodeportivo {
    @Id
    @Column(name = "ID_ED", nullable = false)
    private Integer id;

    @Column(name = "APERTURA", nullable = false)
    private LocalTime apertura;

    @Column(name = "CIERRE", nullable = false)
    private LocalTime cierre;

    @Column(name = "VALOR", nullable = false)
    private Integer valor;

    @Column(name = "FOTO")
    private byte[] foto;

    @Column(name = "DESCRIPCION", nullable = false, length = 250)
    private String descripcion;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_USUARIO", nullable = false)
    private Usuario idUsuario;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_RECINTO", nullable = false)
    private Recinto idRecinto;

    @OneToMany(mappedBy = "idEd")
    private Set<Reserva> reservas = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idEd")
    private Set<Espaciodeporte> espaciodeportes = new LinkedHashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_USUARIO")
    private Usuario idUsuario;

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Set<Espaciodeporte> getEspaciodeportes() {
        return espaciodeportes;
    }

    public void setEspaciodeportes(Set<Espaciodeporte> espaciodeportes) {
        this.espaciodeportes = espaciodeportes;
    }

    public Set<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(Set<Reserva> reservas) {
        this.reservas = reservas;
    }

    public Recinto getIdRecinto() {
        return idRecinto;
    }

    public void setIdRecinto(Recinto idRecinto) {
        this.idRecinto = idRecinto;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public LocalTime getCierre() {
        return cierre;
    }

    public void setCierre(LocalTime cierre) {
        this.cierre = cierre;
    }

    public LocalTime getApertura() {
        return apertura;
    }

    public void setApertura(LocalTime apertura) {
        this.apertura = apertura;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}