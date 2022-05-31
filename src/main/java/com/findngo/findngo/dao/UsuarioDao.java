package com.findngo.findngo.dao;

import com.findngo.findngo.models.Usuario;

import java.util.List;

/**
 * Esta clase es
 * de traer resultados desde la base de datos, en este caso de calificaciones.
 */

public interface UsuarioDao {
    /**
     * Obtiene todos los usuarios en una Lista.
     * @return retorna una lista de usuarios.
     */
    List<Usuario> getUsuarios();

    /**
     * Permite eliminar un usuario mediante su ID.
     * @param id : Corresponde al id del usuario.
     */
    void eliminar(int id);

    /**
     * Permite registrar un usuario mediante el objeto.
     * @param usuario : Corresponde al objeto usuario con todos sus atributos.
     */
    void registrar(Usuario usuario);

    /**
     * Obtiene al usuario por sus credenciales utilizando un objeto.
     * @param usuario : Corresponde al objeto usuario..
     * @return retorna las credenciales de usuario.
     */
    Usuario obtenerUsuarioPorCredenciales(Usuario usuario);
}
