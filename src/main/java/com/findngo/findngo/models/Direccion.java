package com.findngo.findngo.models;

import javax.persistence.*;
/**
 * Esta clase es un modelo representativo de las columnas de la base de datos en este caso
 * de la tabla Direccion, toma propiedades y genera los set y get para obtener datos.
 */

@Entity
@Table(name = "direccion", indexes = {
        @Index(name = "ID_COMUNA", columnList = "ID_COMUNA")
})
public class Direccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DIRECCION", nullable = false)
    private Integer id;

    @Column(name = "CALLE", nullable = false)
    private String calle;

    @Column(name = "NUMERO", nullable = false)
    private Integer numero;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_COMUNA", nullable = false)
    private Comuna idComuna;

    /**
     * Este metodo se encarga de traer el ID de la direccion.
     * @return retorna el id de la direccion en un integer.
     */

    public Integer getId() {
        return id;
    }

    /**
     * Este metodo se encarga de poder modificar el ID de la Direccion.
     * @param id: Esta variable es de tipo integer y es el ID de la direccion.
     */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
     * Este metodo se encarga de traer el nombre de la calle de la direccion.
     * @return retorna el nombre de la direccion en un string.
     */

    public String getCalle() {
        return calle;
    }
    /**
     * Este metodo se encarga de poder modificar el nombre de la calle de la Direccion.
     * @param calle: Esta variable es de tipo String y es el Nombre de la calle.
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }

    /**
     * Este metodo se encarga de traer el Numero de la direccion en un Integer.
     * @return retorna el numero de la direccion en un Integer.
     */

    public Integer getNumero() {
        return numero;
    }

    /**
     * Este metodo se encarga de poder modificar el numero de la Direccion.
     * @param numero: Esta variable es de tipo Integer y corresponde al numero de la direccion.
     */


    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    /**
     * Este metodo se encarga de traer el id de la comuna relacionada a esta direccion.
     * @return Esta variable integer y trae el id de la comuna.
     */

    public Comuna getIdComuna() {
        return idComuna;
    }

    /**
     * Este metodo se encarga de poder modificar el id de la Comuna.
     * @param idComuna : Esta variable es de tipo Integer y corresponde al id de la comuna relacionada a esta Direccion.
     */

    public void setIdComuna(Comuna idComuna) {
        this.idComuna = idComuna;
    }

}