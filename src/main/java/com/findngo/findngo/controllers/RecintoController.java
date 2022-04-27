package com.findngo.findngo.controllers;

import com.findngo.findngo.dao.RecintoDao;
import com.findngo.findngo.models.Recinto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RecintoController {
    @Autowired
    private RecintoDao recintoDao;

    public List<Recinto> getRecintos() {
        return null;
    }

    @RequestMapping(value = "RECINTO")
    public Recinto buscar(@PathVariable String nombre){

        Recinto recinto = new Recinto();
        return recinto;
    }
}
