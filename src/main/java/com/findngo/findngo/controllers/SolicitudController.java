package com.findngo.findngo.controllers;

import com.findngo.findngo.dao.SolicitudDao;
import com.findngo.findngo.models.Solicitud;
import com.findngo.findngo.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SolicitudController {

    @Autowired
    private SolicitudDao solicitudDao;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/solicitudes", method = RequestMethod.GET)
    public List<Solicitud> getSolicitudes(@RequestHeader(value="Authorization") String token) {
        if (!validarToken(token)) { return null; }
        return solicitudDao.getSolicitudes();
    }

    private boolean validarToken(String token) {
        String usuarioId = jwtUtil.getKey(token);
        return usuarioId != null;
    }
}
