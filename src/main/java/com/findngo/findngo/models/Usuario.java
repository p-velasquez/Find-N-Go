package com.findngo.findngo.models;
import javax.persistence.*;

/**
 * Esta clase es un modelo representativo de las columnas de la base de datos en este caso
 * de la tabla Usuario, la cual posee atributos y relaciones foraneas
 */

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USUARIO", nullable = false)
    private Integer id;

    @Column(name = "TIPO", nullable = false)
    private Integer tipo;

    @Column(name = "CORREO", nullable = false)
    private String correo;

    @Column(name = "CONTRASENA", nullable = false)
    private String contrasena;

    /**
     * Este metodo se encarga de traer el ID del usuario.
     * @return retorna el ID del usuario.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Este metodo se encarga de modificar o establecer el id del usuario.
     * @param id : corresponde al id del usuario.
     */

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Este metodo se encarga de traer el tipo de usuario, esto tiene relacion con el tipo de interfaz que vera.
     * @return retorna el tipo de usuario con un integer, puede ser 1 o 2.
     */

    public Integer getTipo() {
        return tipo;
    }

    /**
     * Este metodo se encarga de modificar o establecer el tipo de usuario.
     * @param tipo : corresponde al tipo de usuario mediante un integer que puede ser modificado.
     */


    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }
    /**
     * Este metodo se encarga de traer el correo del usuario.
     * @return retorna el correo del usuario.
     */

    public String getCorreo() {
        return correo;
    }

    /**
     * Este metodo se encarga de modificar o establecer el correo del usuario.
     * @param correo : corresponde al correo del usuario mediante una variable String.
     */

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    /**
     * Este metodo se encarga de traer la password del usuario.
     * @return retorna la password del usuario.
     */
    public String getContrasena() {
        return contrasena;
    }
    /**
     * Este metodo se encarga de modificar la password del usuario.
     * @param contrasena : variable de tipo string correspondiente a la password del usuario.
     */

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

}