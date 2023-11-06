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
import rest.apiRest.entities.Curso;
import rest.apiRest.models.Mensaje;
import rest.apiRest.services.CursoService;

/**
 *
 * @author Daniel Arias
 */
@RestController
@RequestMapping("/api/colegio")
@CrossOrigin(origins = "*")
public class CursoController {

    @Autowired
    private CursoService serviceCurso;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/cursos")
    public List<Curso> obtenerCursos() {
        return serviceCurso.obtenerTodos();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/curso/crear", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Curso> guardar(@Validated @RequestBody Curso curso) {
        if (serviceCurso.agregar(curso)) {
            return ResponseEntity.ok(curso);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @ResponseStatus(code = HttpStatus.OK, reason = "Curso eliminado correctamente")
    @DeleteMapping("/curso/eliminar/{id}")
    public void eliminar(@PathVariable Integer id) {
        serviceCurso.eliminar(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/curso/buscar/{id}")
    public ResponseEntity<?> obtenerCurso(@PathVariable Integer id) {
        Optional<Curso> cursoOptional = serviceCurso.buscarPorId(id);
        if (cursoOptional.isPresent()) {
            return ResponseEntity.ok(cursoOptional.get());
        } else {
            Mensaje mensaje = new Mensaje(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensaje);
        }
    }

    @ResponseStatus(code = HttpStatus.ACCEPTED, reason = "Curso actualizado correctamente")
    @PutMapping("/curso/actualizar")
    public Boolean actualizar(@Validated @RequestBody Curso curso) {
        return serviceCurso.actualizar(curso);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/cursos/cantidad")
    public Long cantidadRegistros() {
        return serviceCurso.cantidadRegistros();
    }
}
