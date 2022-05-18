package com.findngo.findngo.controllers;

import com.findngo.findngo.dao.RecintoDao;
import com.findngo.findngo.models.Recinto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RecintoController {
    @Autowired
    private RecintoDao recintoDao;

    @RequestMapping(value = "api/recintos", method = RequestMethod.GET)
    public List<Recinto> getRecintos(@RequestHeader(value="Authorization")) {
        return recintoDao.getRecintos();
    }

    @RequestMapping(value = "RECINTO")
    public Recinto buscar(@PathVariable String nombre){

        Recinto recinto = new Recinto();
        return recinto;
    }
}
