/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package rest.apiRest.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import rest.apiRest.models.EndPoint;
import rest.apiRest.models.Enlace;
import rest.apiRest.models.Proyecto;

/**
 *
 * @author Daniel Arias
 */
@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class HomeController {

    @GetMapping
    public Proyecto bienvenida() {
        Proyecto p = new Proyecto("Api Rest Colegio", "Creacion de Api RESTfull usando Spring MVC y Spring Data JPA con MySQL");
        Enlace enlace = new Enlace("Curso");
        enlace.agregarEndPoint(new EndPoint("GET", "http://localhost:8080/api/colegio/cursos"));
        enlace.agregarEndPoint(new EndPoint("GET", "http://localhost:8080/api/colegio/curso/buscar/{id}"));
        enlace.agregarEndPoint(new EndPoint("GET", "http://localhost:8080/api/colegio/cursos/cantidad"));
        enlace.agregarEndPoint(new EndPoint("POST", "http://localhost:8080/api/colegio/curso/crear"));
        enlace.agregarEndPoint(new EndPoint("PUT", "http://localhost:8080/api/colegio/curso/actualizar"));
        enlace.agregarEndPoint(new EndPoint("DELETE", "http://localhost:8080/api/colegio/curso/eliminar/{id}"));
        p.crearEnlaces(enlace);
        enlace = new Enlace("Estudiante");
        enlace.agregarEndPoint(new EndPoint("GET", "http://localhost:8080/api/colegio/estudiantes"));
        enlace.agregarEndPoint(new EndPoint("GET", "http://localhost:8080/api/colegio/estudiante/buscar/{id}"));
        enlace.agregarEndPoint(new EndPoint("GET", "http://localhost:8080/api/colegio/estudiantes/cantidad"));
        enlace.agregarEndPoint(new EndPoint("POST", "http://localhost:8080/api/colegio/estudiante/crear"));
        enlace.agregarEndPoint(new EndPoint("PUT", "http://localhost:8080/api/colegio/estudiante/actualizar"));
        enlace.agregarEndPoint(new EndPoint("DELETE", "http://localhost:8080/api/colegio/estudiante/eliminar/{id}"));
        p.crearEnlaces(enlace);
        enlace = new Enlace("Profesor");
        enlace.agregarEndPoint(new EndPoint("GET", "http://localhost:8080/api/colegio/profesores"));
        enlace.agregarEndPoint(new EndPoint("GET", "http://localhost:8080/api/colegio/profesor/buscar/{id}"));
        enlace.agregarEndPoint(new EndPoint("GET", "http://localhost:8080/api/colegio/profesores/cantidad"));
        enlace.agregarEndPoint(new EndPoint("POST", "http://localhost:8080/api/colegio/profesor/crear"));
        enlace.agregarEndPoint(new EndPoint("PUT", "http://localhost:8080/api/colegio/profesor/actualizar"));
        enlace.agregarEndPoint(new EndPoint("DELETE", "http://localhost:8080/api/colegio/profesor/eliminar/{id}"));
        p.crearEnlaces(enlace);
        enlace = new Enlace("Facultad");
        enlace.agregarEndPoint(new EndPoint("GET", "http://localhost:8080/api/colegio/facultades"));
        enlace.agregarEndPoint(new EndPoint("GET", "http://localhost:8080/api/colegio/facultad/buscar/{id}"));
        enlace.agregarEndPoint(new EndPoint("GET", "http://localhost:8080/api/colegio/facultades/cantidad"));
        enlace.agregarEndPoint(new EndPoint("POST", "http://localhost:8080/api/colegio/facultad/crear"));
        enlace.agregarEndPoint(new EndPoint("PUT", "http://localhost:8080/api/colegio/facultad/actualizar"));
        enlace.agregarEndPoint(new EndPoint("DELETE", "http://localhost:8080/api/colegio/facultad/eliminar/{id}"));
        p.crearEnlaces(enlace);
        return p;
    }
}
