package com.findngo.findngo.controllers;

import com.findngo.findngo.dao.EDDao;
import com.findngo.findngo.models.Espaciodeportivo;
import com.findngo.findngo.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public List<Espaciodeportivo> getCoincidence(@RequestHeader(value="Authorization") String token, @PathVariable String busqueda) {
        if (!validarToken(token)) { return null; }
        return edDao.getCoincidence(busqueda);
    }

    @RequestMapping(value = "api/eds/{id}", method = RequestMethod.DELETE)
    public void delete(@RequestHeader(value="Authorization") String token,
                         @PathVariable int id) {
        if (!validarToken(token)) { return; }
        edDao.delete(id);
    }

    @RequestMapping(value = "api/eds", method = RequestMethod.POST)
    public void insert(@RequestBody Espaciodeportivo espaciodeportivo) {

        edDao.insert(espaciodeportivo);
    }

    @RequestMapping(value = "api/eds/{id}", method = RequestMethod.GET)
    public Espaciodeportivo getEdById(@RequestHeader(value="Authorization") String token, @PathVariable int id) {
        if (!validarToken(token)) { return null; }

        return edDao.getEdById(id);
    }

    private boolean validarToken(String token) {
        String usuarioId = jwtUtil.getKey(token);
        return usuarioId != null;
    }
}
