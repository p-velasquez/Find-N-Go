package com.findngo.findngo.models;

import javax.persistence.*;
/**
 * Esta clase es un modelo representativo de las columnas de la base de datos en este caso
 * de la tabla Ciudad, toma propiedades y genera los set y get para obtener datos.
 */
@Entity
@Table(name = "ciudad")
public class Ciudad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CIUDAD", nullable = false)
    private Integer id;


    @Column(name = "NOMBRE", nullable = false)
    private String nombre;

    /**
     * Este metodo es de tipo Get y trae el ID de la ciudad.
     * @return retorna el id de la Ciudad.
     */

    public Integer getId() {
        return id;
    }


    /**
     * Este metodo es de tipo Set y permite modificar el id de la Ciudad.
     * @param id : corresponde al id de la ciudad.
     */

    public void setId(Integer id) {
        this.id = id;
    }


    /**
     * Este metodo es de tipo Get y trae el nombre de la Ciudad.
     * @return retorna el nombre de la Ciudad en un Sirng.
     */
    public String getNombre() {
        return nombre;
    }


    /**
     * Este metodo es de tipo Set y modifica el nombre de la Ciudad.
     * @param nombre Corresponde al nombre de la ciudad de tipo String.
     */

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}