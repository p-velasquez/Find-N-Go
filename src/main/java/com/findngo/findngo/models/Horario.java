package com.findngo.findngo.models;

import javax.persistence.*;
import java.time.LocalTime;
/**
 * Esta clase es un modelo representativo de las columnas de la base de datos en este caso
 * de la tabla Horario, toma propiedades y genera los set y get para obtener datos.
 */

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

    /**
     * Este metodo se encarga de traer el ID del Horario.
     * @return retorna el id de del Horario.
     */
    public Integer getId() {
        return id;
    }
    /**
     * Este metodo se encarga de la modificacion del ID del Horario.
     * @param id : es el id de horario desde la vista.
     */

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Este metodo se encarga de traer la hora de apertura de los espacios deportivos.
     * @return retorna el horario de apertura en una variable LocalTime.
     */

    public LocalTime getApertura() {
        return apertura;
    }

    /**
     * Este metodo se encarga de modificar el horario de apertura de los espacios deportivos.
     * @param apertura corresponde a la variable apertura correspondiente al horario de apertura de tipo LocalTime.
     */

    public void setApertura(LocalTime apertura) {
        this.apertura = apertura;
    }

    /**
     * Este metodo se encarga de traer la hora de cierre de los espacios deportivos.
     * @return retorna el horario de cierre en una variable LocalTime.
     */

    public LocalTime getCierre() {
        return cierre;
    }

    /**
     * Este metodo se encarga de modificar el horario de cierre de los espacios deportivos.
     * @param cierre: corresponde a la variable cierre correspondiente al horario de apertura de tipo LocalTime.
     */

    public void setCierre(LocalTime cierre) {
        this.cierre = cierre;
    }

    /**
     * Este metodo se encarga de traer el id del espacio deportivo, con esto podemos relacionar
     * el horario de apertura y cierre al espacio deportivo respectivo.
     * @return retorna el id del espacio deportivo.
     */


    public Espaciodeportivo getIdEd() {
        return idEd;
    }

    /**
     * Este metodo se encarga de modificar el espacio deportivo asociado a este horario.
     * @param idEd: corresponde al id del espacio deportivo en una variable de tipo objeto.
     */

    public void setIdEd(Espaciodeportivo idEd) {
        this.idEd = idEd;
    }

}