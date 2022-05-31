package com.findngo.findngo.controllers;

import com.findngo.findngo.dao.ComunaDao;
import com.findngo.findngo.models.Comuna;
import com.findngo.findngo.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 *
 * Esta clase se encarga de crear un controlador el cual tendra incidencia en la comunicion del front con el back,
 * crea apis, las cuales seran validadas para luego traer informacion segun se requiera, en este caso
 * tiene directa relacion con las comunas y la forma en que se mostraran.
 */
@RestController
public class ComunaController {

    @Autowired
    private ComunaDao comunaDao;

    @Autowired
    private JWTUtil jwtUtil;

    /**
     * Este metodo crea una api de tipo comunas, la entregara como resultado toda las comunas.
     * @return retorna una lista de comunas que luego seran utilizadas en los selects.
     */
    @RequestMapping(value = "api/comunas", method = RequestMethod.GET)
    public List<Comuna> getComunas() {
        return comunaDao.getComunas();
    }

}
