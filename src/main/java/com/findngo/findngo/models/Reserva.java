package com.findngo.findngo.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Esta clase es un modelo representativo de las columnas de la base de datos en este caso
 * de la tabla Reserva, toma propiedades y genera los set y get para obtener datos.
 */

@Entity
@Table(name = "reserva", indexes = {
        @Index(name = "ID_USUARIO", columnList = "ID_USUARIO"),
        @Index(name = "ID_ED", columnList = "ID_ED")
})
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_RESERVA", nullable = false)
    private Integer id;

    @Column(name = "FECHA", nullable = false)
    private LocalDate fecha;

    @Column(name = "HORA_INICIO", nullable = false)
    private LocalTime horaInicio;

    @Column(name = "HORA_TERMINO", nullable = false)
    private LocalTime horaTermino;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_ED", nullable = false)
    private Espaciodeportivo idEd;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_USUARIO", nullable = false)
    private Usuario idUsuario;

    /**
     * Este metodo se encarga de traer el ID de la reserva.
     * @return retorna el ID de la reserva que realizo un usuario.
     */

    public Integer getId() {
        return id;
    }

    /**
     * Este metodo se encarga de modificar o establecer el id de la reserva.
     * @param id : trae el id de la reserva realizada.
     */

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Este metodo se encarga de traer la fecha en que se realizo la reserva.
     * @return retorna la fecha en un formato de LocalDate.
     */

    public LocalDate getFecha() {
        return fecha;
    }

    /**
     * Este metodo se encarga de modificar o establecer la fecha de reserva realizada.
     * @param fecha : es la fecha de la reserva.
     */

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    /**
     * Este metodo se encarga de traer la hora de inicio de la reserva.
     * @return retorna hora de inicio de la reserva en un LocalTime.
     */
    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    /**
     * Este metodo se encarga de modificar o establecer la hora de inicio de reserva.
     * @param horaInicio : hora de inicio de la reserva.
     */

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    /**
     * Este metodo se encarga de traer la hora de termino de la reserva.
     * @return retorna hora de termino de la reserva en un LocalTime.
     */

    public LocalTime getHoraTermino() {
        return horaTermino;
    }

    /**
     * Este metodo se encarga de modificar o establecer la hora de termino de reserva.
     * @param horaTermino : hora de termino de la reserva.
     */

    public void setHoraTermino(LocalTime horaTermino) {
        this.horaTermino = horaTermino;
    }

    /**
     * Este metodo se encarga de traer todos los datos y atributos que se relacionan
     * con la reserva y el espacio deportivo.
     * @return retorna el id del espacio deportivo..
     */

    public Espaciodeportivo getIdEd() {
        return idEd;
    }

    /**
     * Este metodo se encarga de modificar o establecer el espacio deportivo relacionado a esta reserva.
     * @param idEd : es el id del espacio deportivo a establecer.
     */
    public void setIdEd(Espaciodeportivo idEd) {
        this.idEd = idEd;
    }

    /**
     * Este metodo se encarga de traer todos los datos y atributos que se relacionan
     * con la reserva y el usuario, de manera de conocer el usuario y su reserva.
     * @return retorna el id del usuario.
     */
    public Usuario getIdUsuario() {
        return idUsuario;
    }

    /**
     * Este metodo se encarga de modificar o establecer el usuario relacionado a esta reserva.
     * @param idUsuario : es el id del usuario a establecer.
     */
    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

}