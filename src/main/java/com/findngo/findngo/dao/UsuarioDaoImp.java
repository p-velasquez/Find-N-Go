package com.findngo.findngo.dao;

import com.findngo.findngo.models.Usuario;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Esta clase es una implementacion que se encarga de hacer las consultas a la BD mediante objetos.
 * Trayendo los resultados en este caso de los usuarios.
 */

@Repository
@Transactional
public class UsuarioDaoImp implements UsuarioDao {

    @PersistenceContext
    EntityManager entityManager;

    /**
     * Obtiene todos los Usuarios mediante una consulta SQL a la base de datos.
     * @return retorna finalmente este result list llamado Usuario.
     */

    @Override
    @Transactional
    public List<Usuario> getUsuarios() {
        String query = "FROM Usuario";
        return entityManager.createQuery(query).getResultList();
    }


    /**
     * Permite eliminar al usuario eliminando su objeto.
     * @param id : Es el id del usuario..
     */
    @Override
    public void eliminar(int id) {
        Usuario usuario = entityManager.find(Usuario.class, id);
        entityManager.remove(usuario);
    }

    /**
     * Permite registrar un usuario utilizando su objeto.
     * @param usuario: Es el objeto de tipo usuario.
     */
    @Override
    public void registrar(Usuario usuario) {
        entityManager.merge(usuario);
    }

    /**
     * Obtiene todos los usuarios segun segun su correo.
     * @param usuario : Corresponde al objeto usuario.
     */
    @Override
    public Usuario obtenerUsuarioPorCredenciales(Usuario usuario) {
        String query = "FROM Usuario WHERE correo = :correo";
        List<Usuario> lista = entityManager.createQuery(query)
                .setParameter("correo", usuario.getCorreo())
                .getResultList();

        if (lista.isEmpty()) {
            return null;
        }

        String passwordHashed = lista.get(0).getContrasena();

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        if (argon2.verify(passwordHashed, usuario.getContrasena())) {
            return lista.get(0);
        }
        return null;
    }

}