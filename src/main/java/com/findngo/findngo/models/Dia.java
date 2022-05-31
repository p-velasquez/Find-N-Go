package com.findngo.findngo.models;

import javax.persistence.*;
/**
 * Esta clase es un modelo representativo de las columnas de la base de datos en este caso
 * de la tabla Dia, toma propiedades y genera los set y get para obtener datos.
 */
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

    /**
     * Este metodo se encarga de traer el ID del Dia.
     * @return retorna el id del dia en un integer.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Este metodo se encarga de poder modificar el ID del dDia.
     * @param id : Esta variable es de tipo integer y es el ID del Dia.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Este metodo se encarga de traer el Nombre del Dia.
     * @return retorna el nombre del dia en un integer.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Este metodo se encarga de poder modificar el nombre del dDia.
     * @param nombre : Esta variable es de tipo string y es el nombre del Dia.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Este metodo se encarga de traer el id del Horario, es una clave foranea.
     * @return retorna el id de Horario.
     */
    public Horario getIdHorario() {
        return idHorario;
    }

    /**
     * Este metodo se encarga de poder modificar el id de horario.
     * @param idHorario : Esta variable es de tipo objeto y permite ser editada.
     */
    public void setIdHorario(Horario idHorario) {
        this.idHorario = idHorario;
    }

}