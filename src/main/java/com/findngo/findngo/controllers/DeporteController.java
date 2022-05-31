package com.findngo.findngo.controllers;

import com.findngo.findngo.dao.DeporteDao;
import com.findngo.findngo.models.Deporte;
import com.findngo.findngo.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Esta clase se encarga de crear un controlador el cual tendra incidencia en la comunicion del front con el back,
 * crea apis, en este caso en particular una api del tipo deportes la cual sera consultada por el usuario.
 */
@RestController
public class DeporteController {

    @Autowired
    private DeporteDao deporteDao;

    @Autowired
    private JWTUtil jwtUtil;

    /**
     * Este metodo crea una api de tipo deportes, la entregara como resultado toda los deportes.
     * @return retorna una lista de deportes que luego seran utilizadas en los selects.
     */
    @RequestMapping(value = "api/deportes", method = RequestMethod.GET)
    public List<Deporte> getDeportes() {
        return deporteDao.getDeportes();
    }

}
