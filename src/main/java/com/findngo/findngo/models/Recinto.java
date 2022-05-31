package com.findngo.findngo.models;

import javax.persistence.*;

/**
 * Esta clase es un modelo representativo de las columnas de la base de datos en este caso
 * de la tabla Recinto, toma propiedades y genera los set y get para obtener datos.
 */

@Entity
@Table(name = "recinto", indexes = {
        @Index(name = "ID_DIRECCION", columnList = "ID_DIRECCION", unique = true)
})
public class Recinto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_RECINTO", nullable = false)
    private Integer id;

    @Column(name = "NOMBRE", nullable = false)
    private String nombre;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_DIRECCION", nullable = false)
    private Direccion idDireccion;

    /**
     * Este metodo se encarga de traer el ID del recinto.
     * @return retorna el ID del recinto deportivo en una variable integer.
     */

    public Integer getId() {
        return id;
    }

    /**
     * Este metodo se encarga de la modificacion del ID del Recinto.
     * @param id : es el id del recinto, variable de tipo Integer.
     */

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Este metodo se encarga de traer el nombre del recinto deportivo.
     * @return retorna el nombre en una variable de tipo String.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Este metodo se encarga de la modificacion del nombre del recinto.
     * @param nombre : una variable de tipo string que trae el nombre del recinto.
     */

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Este metodo se encarga de traer el id de la direccion, para poder acceder
     * a toda la informacion de su direccion relacionada con otras clases como direccion y comuna.
     * @return retorna el id de la direccion.
     */
    public Direccion getIdDireccion() {
        return idDireccion;
    }

    /**
     * Este metodo se encarga de la modificacion del id de la direccion del recinto.
     * @param idDireccion : es el id de la direccion a modificar.
     */

    public void setIdDireccion(Direccion idDireccion) {
        this.idDireccion = idDireccion;
    }

}