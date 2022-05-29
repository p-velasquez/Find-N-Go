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

@RestController
public class CalificacionController {

    @Autowired
    private CalificacionDao calificacionDao;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/calificaciones", method = RequestMethod.GET)
    public List<Calificacion> getCalificaciones(@RequestHeader(value="Authorization") String token) {
        if (!validarToken(token)) { return null; }
        return calificacionDao.getCalificaciones();
    }

    private boolean validarToken(String token) {
        String usuarioId = jwtUtil.getKey(token);
        return usuarioId != null;
    }
}
