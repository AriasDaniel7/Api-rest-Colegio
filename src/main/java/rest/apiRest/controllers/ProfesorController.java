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
import rest.apiRest.entities.Profesor;
import rest.apiRest.models.Mensaje;
import rest.apiRest.services.ProfesorService;

/**
 *
 * @author Daniel Arias
 */
@RestController
@RequestMapping("/api/colegio")
@CrossOrigin(origins = "*")
public class ProfesorController {

    @Autowired
    private ProfesorService serviceProfesor;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/profesores")
    public List<Profesor> obtenerProfesors() {
        return serviceProfesor.obtenerTodos();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/profesor/crear", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Profesor> guardar(@Validated @RequestBody Profesor profesor) {
        if (serviceProfesor.agregar(profesor)) {
            return ResponseEntity.ok(profesor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @ResponseStatus(code = HttpStatus.OK, reason = "Profesor eliminado correctamente")
    @DeleteMapping("/profesor/eliminar/{id}")
    public void eliminar(@PathVariable Integer id) {
        serviceProfesor.eliminar(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/profesor/buscar/{id}")
    public ResponseEntity<?> obtenerProfesor(@PathVariable Integer id) {
        Optional<Profesor> profesorOptional = serviceProfesor.buscarPorId(id);
        if (profesorOptional.isPresent()) {
            return ResponseEntity.ok(profesorOptional.get());
        } else {
            Mensaje mensaje = new Mensaje(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensaje);
        }
    }

    @ResponseStatus(code = HttpStatus.ACCEPTED, reason = "Profesor actualizado correctamente")
    @PutMapping("/profesor/actualizar")
    public Boolean actualizar(@Validated @RequestBody Profesor profesor) {
        return serviceProfesor.actualizar(profesor);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/profesores/cantidad")
    public Long cantidadRegistros() {
        return serviceProfesor.cantidadRegistros();
    }
}
