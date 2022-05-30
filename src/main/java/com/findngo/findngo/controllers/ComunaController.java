package com.findngo.findngo.controllers;

import com.findngo.findngo.dao.ComunaDao;
import com.findngo.findngo.models.Comuna;
import com.findngo.findngo.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ComunaController {

    @Autowired
    private ComunaDao comunaDao;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/comunas", method = RequestMethod.GET)
    public List<Comuna> getComunas() {
        return comunaDao.getComunas();
    }

}
