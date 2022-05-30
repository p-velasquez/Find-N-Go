package com.findngo.findngo.models;

import javax.persistence.*;

/**
 * Esta clase es un modelo representativo de las columnas de la base de datos en este caso
 * de la tabla Calificaicon, la cual posee atributos y relaciones foraneas
 */

@Entity
@Table(name = "calificacion", indexes = {
        @Index(name = "ID_USUARIO", columnList = "ID_USUARIO"),
        @Index(name = "ID_ED", columnList = "ID_ED")
})
public class Calificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CALIFICACION", nullable = false)
    private Integer id;

    @Column(name = "NOTA", nullable = false)
    private Integer nota;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_USUARIO", nullable = false)
    private Usuario idUsuario;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_ED", nullable = false)
    private Espaciodeportivo idEd;

    /**
     * Este metodo es de tipo Get y trae el ID de la calificacion..
     * @return retorna el id de las calificacion.
     */
    public Integer getId() {
        return id;
    }
    /**
     * Este metodo es de tipo SET y permite la modificacion del ID.
     * @param id: id de la calificacion.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Este metodo es de tipo Get y trae el atributo Nota de la tabla Calificaciones
     * en una variable de tipo Integer.
     * @return retorna la nota.
     */
    public Integer getNota() {
        return nota;
    }

    /**
     * Este metodo es de tipo SET y permite la modificacion del de la nota.
     * @param nota: trae el numero de la nota en una variable integer.
     */

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    /**
     * Este metodo es de tipo Get y trae el id de usuario.
     * @return : retorna el id de usuario.
     */
    public Usuario getIdUsuario() {
        return idUsuario;
    }

    /**
     * Este metodo es de tipo SET y permite la modificacion del id de usuario.
     * @param idUsuario : el id del usuario a modificar.
     */
    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * Este metodo es de tipo get y trae al espacio deportivo.
     * @return retorno del id del espacio deportivo.
     */

    public Espaciodeportivo getIdEd() {
        return idEd;
    }

    /**
     * Este metodo es de tipo SET y permite la modificacion del id del espacio deportivo.
     * @param idEd : es el id del espacio deportivo a setear.
     */
    public void setIdEd(Espaciodeportivo idEd) {
        this.idEd = idEd;
    }

}