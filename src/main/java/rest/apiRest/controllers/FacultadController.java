/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rest.apiRest.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import rest.apiRest.entities.Facultad;
import rest.apiRest.models.Mensaje;
import rest.apiRest.services.FacultadService;

/**
 *
 * @author Daniel Arias
 */
@RestController
@RequestMapping("/api/colegio")
@CrossOrigin(origins = "*")
public class FacultadController {

    @Autowired
    private FacultadService serviceFacultad;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/facultades")
    public List<Facultad> obtenerFacultads() {
        return serviceFacultad.obtenerTodos();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/facultad/crear", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Facultad> guardar(@Validated @RequestBody Facultad facultad) {
        if (serviceFacultad.agregar(facultad)) {
            return ResponseEntity.ok(facultad);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @ResponseStatus(code = HttpStatus.OK, reason = "Facultad eliminado correctamente")
    @DeleteMapping("/facultad/eliminar/{id}")
    public void eliminar(@PathVariable Integer id) {
        serviceFacultad.eliminar(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/facultad/buscar/{id}")
    public ResponseEntity<?> obtenerFacultad(@PathVariable Integer id) {
        Optional<Facultad> facultadOptional = serviceFacultad.buscarPorId(id);
        if (facultadOptional.isPresent()) {
            return ResponseEntity.ok(facultadOptional.get());
        } else {
            Mensaje mensaje = new Mensaje(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensaje);
        }
    }

    @ResponseStatus(code = HttpStatus.ACCEPTED, reason = "Facultad actualizado correctamente")
    @PutMapping("/facultad/actualizar")
    public Boolean actualizar(@Validated @RequestBody Facultad facultad) {
        return serviceFacultad.actualizar(facultad);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/facultades/cantidad")
    public Long cantidadRegistros() {
        return serviceFacultad.cantidadRegistros();
    }
}
