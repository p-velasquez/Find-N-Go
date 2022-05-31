package com.findngo.findngo.controllers;

import com.findngo.findngo.dao.RecintoDao;
import com.findngo.findngo.models.Recinto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * Esta clase se encarga de crear un controlador el cual tendra incidencia en la comunicion del front con el back,
 * crea apis, en este caso en particular una api del tipo Recintos la cual sera consultada por el usuario.
 */
@RestController
public class RecintoController {
    @Autowired
    private RecintoDao recintoDao;

    /**
     * Esta metodo crea una api del tipo recintos, la cual trae todos los recintos disponibles desde la base de datos.
     * @return retorna todos los recintos en una lista.
     */
    @RequestMapping(value = "api/recintos", method = RequestMethod.GET)
    public List<Recinto> getRecintos() {
        return recintoDao.getRecintos();
    }


    /**
     * Esta metodo crea una api del tipo RECINTO, la cual se encargara mediante una consulta query
     * traer la informacion relacionada con el recinto.
     * @param nombre: parametro utilizado para realizar la busqueda del recinto mediante su nombre.
     * @return retorna el recinto.
     */
    @RequestMapping(value = "RECINTO")
    public Recinto buscar(@PathVariable String nombre){

        Recinto recinto = new Recinto();
        return recinto;
    }
}
