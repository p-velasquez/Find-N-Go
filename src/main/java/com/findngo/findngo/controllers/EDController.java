package com.findngo.findngo.controllers;

import com.findngo.findngo.dao.EDDao;
import com.findngo.findngo.models.Espaciodeportivo;
import com.findngo.findngo.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EDController {

    @Autowired
    private EDDao edDao;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/eds", method = RequestMethod.GET)
    public List<Espaciodeportivo> getEds(@RequestHeader(value="Authorization") String token) {
        if (!validarToken(token)) { return null; }
        return edDao.getEds();
    }

    @RequestMapping(value = "api/eds/{nombre}", method = RequestMethod.GET)
    public List<Espaciodeportivo> getCoincidence(@RequestHeader(value="Authorization") String token, String busqueda) {
        if (!validarToken(token)) { return null; }
        return edDao.getCoincidence(busqueda);
    }

    private boolean validarToken(String token) {
        String usuarioId = jwtUtil.getKey(token);
        return usuarioId != null;
    }
}
