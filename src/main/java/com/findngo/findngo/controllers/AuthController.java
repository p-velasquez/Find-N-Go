package com.findngo.findngo.controllers;

import com.findngo.findngo.dao.UsuarioDao;
import com.findngo.findngo.models.Usuario;
import com.findngo.findngo.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Esta clase es un controlador de tipo Auth.
 * Que se encarga de autentificar la sesion del usuario.
 */
@RestController
public class AuthController {

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private JWTUtil jwtUtil;


    /**
     * Obtiene todos el usuario logueado,
     * @return ResultList transformado a Lista de tipo EspacioDeportivo
     * @param usuario : objeto de tipo usuario.
     */

    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public String login(@RequestBody Usuario usuario) {

        Usuario usuarioLogueado = usuarioDao.obtenerUsuarioPorCredenciales(usuario);
        if (usuarioLogueado != null) {
            return jwtUtil.create(String.valueOf(usuarioLogueado.getId()), usuarioLogueado.getCorreo());
        }
        return "FAIL";
    }

}