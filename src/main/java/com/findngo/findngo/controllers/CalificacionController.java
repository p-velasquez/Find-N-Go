package com.findngo.findngo.controllers;

import com.findngo.findngo.dao.CalificacionDao;
import com.findngo.findngo.models.Calificacion;
import com.findngo.findngo.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Esta clase se encarga de crear un controlador el cual tendra incidencia en la comunicion del front con el back,
 * crea apis, las cuales seran validadas para luego traer informacion segun se requiera.
 */

@RestController
public class CalificacionController {

    @Autowired
    private CalificacionDao calificacionDao;

    @Autowired
    private JWTUtil jwtUtil;

    /**
     * Este metodo crea una api de tipo calificaciones, la entregara como resultado toda las calificaciones.
     * @param token : trae el token para validar la sesion de usuario.
     * @return retorna una lista de calificaciones.
     */

    @RequestMapping(value = "api/calificaciones", method = RequestMethod.GET)
    public List<Calificacion> getCalificaciones(@RequestHeader(value="Authorization") String token) {
        if (!validarToken(token)) { return null; }
        return calificacionDao.getCalificaciones();
    }

    /**
     * Este metodo se encarga de validar el token de sesion..
     * @param token : trae el token para validar la sesion de usuario.
     * @return un usuario si este es distinto de null.
     */
    private boolean validarToken(String token) {
        String usuarioId = jwtUtil.getKey(token);
        return usuarioId != null;
    }
}
