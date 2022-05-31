package com.findngo.findngo.models;

import javax.persistence.*;

/**
 * Esta clase es un modelo representativo de las columnas de la base de datos en este caso
 * de la tabla Espacio Deportivo, toma propiedades y genera los set y get para obtener datos.
 */

@Entity
@Table(name = "espaciodeportivo", indexes = {
        @Index(name = "ID_RECINTO", columnList = "ID_RECINTO"),
        @Index(name = "ID_USUARIO", columnList = "ID_USUARIO"),
        @Index(name = "ID_DEPORTE", columnList = "ID_DEPORTE")
})
public class Espaciodeportivo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ED", nullable = false)
    private Integer id;

    @Column(name = "VALOR", nullable = false)
    private Integer valor;

    @Column(name = "CANTIDAD", nullable = false)
    private Integer cantidad;

    @Column(name = "FOTO")
    private byte[] foto;

    @Column(name = "DESCRIPCION", nullable = false, length = 250)
    private String descripcion;

    @Column(name = "TIEMPO_BLOQUE", nullable = false)
    private Integer tiempoBloque;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_USUARIO", nullable = false)
    private Usuario idUsuario;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_RECINTO", nullable = false)
    private Recinto idRecinto;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_DEPORTE", nullable = false)
    private Deporte idDeporte;

    /**
     * Este metodo se encarga de traer el ID del espacio deportivo..
     * @return retorna el id de del espacio deportivo en un integer.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Este metodo se encarga de poder modificar el ID del espacio deportivo.
     * @param id: Esta variable es de tipo integer y es el ID del espacio deportio.
     */

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Este metodo se encarga de traer el Valor del espacio Deportivo.
     * @return retorna el Valor del espacio deportivo.
     */

    public Integer getValor() {
        return valor;
    }

    /**
     * Este metodo se encarga de poder modificar el Precio del espacio deportivo.
     * @param valor: Esta variable es de tipo integer y es el Valor del espacio deportivo.
     */

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    /**
     * Este metodo se encarga de traer la cantidad de espacios deportivos existentes.
     * @return retorna el valor de la cantidad de espacios deportivos en un integer.
     */

    public Integer getCantidad() {
        return cantidad;
    }

    /**
     * Este metodo se encarga de poder modificar la cantidad de los espacios deportivos.
     * @param cantidad: Esta variable es de tipo integer y es la cantidad de canchas existentes.
     */

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Este metodo se encarga de traer la foto que posee el espacio deportivo.
     * @return retorna el valor de un byte relacionado a la foto del espacio deportivo.
     */


    public byte[] getFoto() {
        return foto;
    }

    /**
     * Este metodo se encarga de poder modificar la foto del espacio deportivo.
     * @param foto: Esta variable es de tipo byte y se relaciona a la foto del espacio deportivo.
     */

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    /**
     * Este metodo se encarga de traer la descripcion que tiene el espacio deportivo.
     * @return retorna la descripcion del espacio deportivo.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Este metodo se encarga de poder modificar la descripcion del espacio deportivo, en donde colocan sus caracteristicas.
     * @param descripcion: Esta variable es de tipo String y es la descripcion del espacio deportivo.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Este metodo se encarga de traer los bloques de tiempo del espacio deportivos, es decir
     * los minutos que utilizaran los usuarios en el espacio deportivo (cancha)
     * @return retorna el tiempo en un integer ya que son minutos.
     */
    public Integer getTiempoBloque() {
        return tiempoBloque;
    }
    /**
     * Este metodo se encarga de poder modificar elt iempo del bloque del espacio deportivo.
     * @param tiempoBloque: Esta variable es de tipo Integer y corresponde a los minutos.
     */
    public void setTiempoBloque(Integer tiempoBloque) {
        this.tiempoBloque = tiempoBloque;
    }

    /**
     * Este metodo se encarga de traer el id de usuario que utiliza el espacio deportivo, relacionado con otra tabla,
     * con este id podemos traer toda la informacion necesaria dl usuario.
     * @return retorna el id del usuario que esta utilizando el espacio deportivo.
     */

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    /**
     * Este metodo se encarga de poder modificar el id del usuario.
     * @param idUsuario: Esta variable es de tipo Integer y corresponde al id del usuario.
     */

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * Este metodo se encarga de traer el id del recinto en que esta el espacio deportivo.
     * con este id podemos traer toda la informacion y atributos de la tabla Recinto.
     * @return retorna el id del Recinto de este espacio deportivo.
     */

    public Recinto getIdRecinto() {
        return idRecinto;
    }
    /**
     * Este metodo se encarga de poder modificar el id del recinto del espacio deportivo.
     * @param idRecinto: Esta variable es de integer y corresponde al recinto.
     */
    public void setIdRecinto(Recinto idRecinto) {
        this.idRecinto = idRecinto;
    }

    /**
     * Este metodo se encarga de traer el id del deporte en que esta el espacio deportivo.
     * Con este atributo podemos conocer el nombre del deporte que se practica en este espacio deportivo.
     * @return retorna el id del deporte que se practica en este espacio deportivo.
     */
    public Deporte getIdDeporte() {
        return idDeporte;
    }
    /**
     * Este metodo se encarga de poder modificar el id del Deporte del espacio deportivo.
     * Esto nos sirve para modificar el deporte del espacio deportivo.
     * @param idDeporte: Esta variable es de integer y corresponde al id del deporte.
     */

    public void setIdDeporte(Deporte idDeporte) {
        this.idDeporte = idDeporte;
    }

}