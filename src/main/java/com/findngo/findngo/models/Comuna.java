package com.findngo.findngo.models;

import javax.persistence.*;
/**
 * Esta clase es un modelo representativo de las columnas de la base de datos en este caso
 * de la tabla Comuna, toma propiedades y genera los set y get para obtener datos.
 */
@Entity
@Table(name = "comuna", indexes = {
        @Index(name = "ID_CIUDAD", columnList = "ID_CIUDAD")
})
public class Comuna {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_COMUNA", nullable = false)
    private Integer id;

    @Column(name = "NOMBRE", nullable = false)
    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_CIUDAD", nullable = false)
    private Ciudad idCiudad;

    /**
     * Este metodo es de tipo Get y trae el ID de la Comuna.
     * @return retorna el id de la Comuna.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Este metodo es de tipo Set y permite modificar el ID de la Comuna.
     * @param id : corresponde al id de la Comuna.
     */

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Este metodo es de tipo Get y trae el nombre de la Comuna.
     * @return retorna un string con el nombre de la Comuna.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Este metodo es de tipo Get y trae el ID de la ciudad.
     * @param nombre : trae el nombre de la Comuna en valor de String.
     */

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Este metodo es de tipo Get y trae el ID de la ciudad.
     * @return retorna el id de la Ciudad.
     */
    public Ciudad getIdCiudad() {
        return idCiudad;
    }

    /**
     * Este metodo es de tipo SET y permite modificar el id de la Ciudad.
     * @param idCiudad : trae el id de la ciudad.
     */
    public void setIdCiudad(Ciudad idCiudad) {
        this.idCiudad = idCiudad;
    }

}