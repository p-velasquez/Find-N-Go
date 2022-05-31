package com.findngo.findngo.controllers;

import com.findngo.findngo.dao.UsuarioDao;
import com.findngo.findngo.models.Usuario;
import com.findngo.findngo.utils.JWTUtil;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Esta clase se encarga de crear un controlador el cual tendra incidencia en la comunicion del front con el back,
 * crea apis, en este caso en particular una api del tipo Usuario la cual sera consultada,.
 */

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private JWTUtil jwtUtil;

    /**
     * Esta metodo crea una api del tipo usuarios, la cual trae todos los usaurios disponibles desde la base de datos.
     * @return retorna todos los usuarios en una lista.
     */
    @RequestMapping(value = "api/usuarios", method = RequestMethod.GET)
    public List<Usuario> getUsuarios() {

        return usuarioDao.getUsuarios();
    }

    /**
     * Este metodo valida el token de sesion del usuario mediante la variable token, metodo el cual
     * devuelve un booleano en donde si el usuario es distinto de null sera true, de lo contrario sera false.
     * @param token : token que trae consigo la sesion del usuario.
     */
    private boolean validarToken(String token) {
        String usuarioId = jwtUtil.getKey(token);
        return usuarioId != null;
    }

    /**
     * Este metodo crea una api de tipo usuarios, el cual mediante un metodo post, permite registrar usuarios
     * encriptando su password con un hash y creando el tipo de usuario por default que es 1, finalmente
     * permite el registro de usuario
     * @param usuario : objeto de tipo usuario.
     */
    @RequestMapping(value = "api/usuarios", method = RequestMethod.POST)
    public void registrarUsuario(@RequestBody Usuario usuario) {

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1, 1024, 1, usuario.getContrasena());
        usuario.setContrasena(hash);
        usuario.setTipo(1);

        usuarioDao.registrar(usuario);
    }

    /**
     * Metodo de tipo DELETE, que permite borrar un usuario mediante la api y su ID,
     * antes de eso se debe validar el token para proceder a la evaluacion
     * @param token : token de sesion del usuario.
     * @param id : id del usuario a eliminar.
     */
    @RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.DELETE)
    public void eliminar(@RequestHeader(value="Authorization") String token,
                         @PathVariable int id) {
        if (!validarToken(token)) { return; }
        usuarioDao.eliminar(id);
    }

}
