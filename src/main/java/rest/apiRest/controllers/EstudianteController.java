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
import rest.apiRest.entities.Estudiante;
import rest.apiRest.models.Mensaje;
import rest.apiRest.services.EstudianteService;

/**
 *
 * @author Daniel Arias
 */
@RestController
@RequestMapping("/api/colegio")
@CrossOrigin(origins = "*")
public class EstudianteController {

    @Autowired
    private EstudianteService serviceEstudiante;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/estudiantes")
    public List<Estudiante> obtenerEstudiantes() {
        return serviceEstudiante.obtenerTodos();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/estudiante/crear", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Estudiante> guardar(@Validated @RequestBody Estudiante estudiante) {
        if (serviceEstudiante.agregar(estudiante)) {
            return ResponseEntity.ok(estudiante);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @ResponseStatus(code = HttpStatus.OK, reason = "Estudiante eliminado correctamente")
    @DeleteMapping("/estudiante/eliminar/{id}")
    public void eliminar(@PathVariable Integer id) {
        serviceEstudiante.eliminar(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/estudiante/buscar/{id}")
    public ResponseEntity<?> obtenerEstudiante(@PathVariable Integer id) {
        Optional<Estudiante> estudianteOptional = serviceEstudiante.buscarPorId(id);
        if (estudianteOptional.isPresent()) {
            return ResponseEntity.ok(estudianteOptional.get());
        } else {
            Mensaje mensaje = new Mensaje(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensaje);
        }
    }

    @ResponseStatus(code = HttpStatus.ACCEPTED, reason = "Estudiante actualizado correctamente")
    @PutMapping("/estudiante/actualizar")
    public Boolean actualizar(@Validated @RequestBody Estudiante estudiante) {
        return serviceEstudiante.actualizar(estudiante);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/estudiantes/cantidad")
    public Long cantidadRegistros() {
        return serviceEstudiante.cantidadRegistros();
    }
}
