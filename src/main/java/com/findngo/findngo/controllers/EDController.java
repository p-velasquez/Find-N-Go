package com.findngo.findngo.controllers;

import com.findngo.findngo.dao.EDDao;
import com.findngo.findngo.models.Espaciodeportivo;
import com.findngo.findngo.service.EDService;
import com.findngo.findngo.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Esta clase se encarga de crear un controlador el cual tendra incidencia en la comunicion del front con el back,
 * crea apis, en este caso en particular una api del tipo espacio deportivos la cual sera consumida por el usuario.
 */

@RestController
@RequestMapping("/api/eds")
public class EDController {

    @Autowired
    private EDDao edDao;

    private EDService edService;

    @Autowired
    private JWTUtil jwtUtil;

    /**
     * Este metodo setea el servicio entregado del espacio deportivo.
     * @param edService : Objeto de la clase EDService.
     */
    public EDController(EDService edService) {
        this.edService = edService;
    }

    /**
     * Esta metodo crea una api del tipo search, la cual se encargara mediante una consulta query
     * traer la informacion relacionada con el espacio deportivo.
     * @param query : parametro utilizado para realizar la busqueda del espacio deportivo
     * @return retorna el resultado de la busqueda.
     */
    @GetMapping("/search")
    public ResponseEntity<List<Espaciodeportivo>> buscarED(@RequestParam("query") String query){
        return ResponseEntity.ok(edService.buscarED(query));
    }

    /**
     * Esta metodo crea una api del tipo search, la cual se encargara mediante una consulta query
     * traer la informacion relacionada con el espacio deportivo.
     * @param query : parametro utilizado para realizar la busqueda del espacio deportivo
     * @return retorna el resultado de la busqueda.
     */
    @GetMapping("/id")
    public ResponseEntity<List<Espaciodeportivo>> buscarId(@RequestParam("query") String query){
        return ResponseEntity.ok(edService.buscarId(query));
    }

    /**
     * Esta metodo crea un espacio deportivo, la cual se encargara mediante un objeto espacio deportivo
     * de crear un nuevo espacio.
     * @param ed : objeto de tipo espacio deportivo.
     * @return retorna la creacion del espacio deportivo.
     */
    @PostMapping
    public Espaciodeportivo crearED(@RequestBody Espaciodeportivo ed){
        return edService.createEd(ed);
    }

    /**
     * Este metodo crea una api, la que entregara como resultado todos los espacios deportivos..
     * @return retorna una lista de los espacios deportivos que luego seran utilizados en el html.
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Espaciodeportivo> getEds() {
        return edDao.getEds();
    }

    /**
     * Este metodo crea una api de tipo espacios deportivos que se encargara de eliminarlo mediante su id,
     * @param id: trae el id del espacio deportivo
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable int id) {
        edDao.delete(id);
    }

    /**
     * Este metodo crea una api de tipo eds, la cual permitira realizar un insert con un metodo POST
     * este insert corresponde al espacio deportivo el cual sera cargado.
     * @param espaciodeportivo : objeto de tipo espacio deportivo.
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public void insert(@RequestBody Espaciodeportivo espaciodeportivo) {
        edDao.insert(espaciodeportivo);
    }

    /**
     * Este metodo permite validar el token de sesion del usuario.
     * @param token: correpsonde al token del usuario.
     * @return retorna un usuario si es distinto de null.
     */
    private boolean validarToken(String token) {
        String usuarioId = jwtUtil.getKey(token);
        return usuarioId != null;
    }
}
