package com.findngo.findngo.controllers;

import com.findngo.findngo.dao.EDDao;
import com.findngo.findngo.models.Espaciodeportivo;
import com.findngo.findngo.models.Usuario;
import com.findngo.findngo.service.EDService;
import com.findngo.findngo.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/eds")
public class EDController {

    @Autowired
    private EDDao edDao;

    private EDService edService;

    @Autowired
    private JWTUtil jwtUtil;

    public EDController(EDService edService) {
        this.edService = edService;
    }

    @GetMapping("/search")
    public ResponseEntity<List<Espaciodeportivo>> buscarED(@RequestParam("query") String query){
        return ResponseEntity.ok(edService.buscarED(query));
    }

    @PostMapping
    public Espaciodeportivo crearED(@RequestBody Espaciodeportivo ed){
        return edService.createEd(ed);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Espaciodeportivo> getEds() {
        return edDao.getEds();
    }

/*    @RequestMapping(value = "api/eds/nombre", method = RequestMethod.GET)
    public List<Espaciodeportivo> getCoincidence(@PathVariable String busqueda) {
        return edDao.getCoincidence(busqueda);
    }*/

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public List<Espaciodeportivo> getEdById(@PathVariable int id) {
        return edDao.getEdById(id);
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

    private boolean validarToken(String token) {
        String usuarioId = jwtUtil.getKey(token);
        return usuarioId != null;
    }
}
