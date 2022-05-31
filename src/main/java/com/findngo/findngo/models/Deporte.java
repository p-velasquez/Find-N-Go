package com.findngo.findngo.models;

import javax.persistence.*;
/**
 * Esta clase es un modelo representativo de las columnas de la base de datos en este caso
 * de la tabla Deporte, toma propiedades y genera los set y get para obtener datos.
 */
@Entity
@Table(name = "deporte")
public class Deporte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DEPORTE", nullable = false)
    private Integer id;

    @Column(name = "NOMBRE", nullable = false)
    private String nombre;

    /**
     * Este metodo se encarga de traer el ID del Deporte.
     * @return retorna el id del deporte en un integer.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Este metodo se encarga de poder modificar el ID del deporte.
     * @param id : Esta variable es de tipo integer y es el ID del Deporte.
     */
    public void setId(Integer id) {
        this.id = id;
    }


    /**
     * Este metodo se encarga de traer el Nombre del Deporte en variable String.
     * @return retorna el nombre del deporte.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Este metodo se encarga de poder modificar el Nombre del deporte.
     * @param nombre : Esta variable es de tipo String y se relaciona con el nombre del deporte.
     */

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}