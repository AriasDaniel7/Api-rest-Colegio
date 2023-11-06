/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rest.apiRest.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import rest.apiRest.entities.Profesor;
import rest.apiRest.interfaces.OperacionesInterface;
import rest.apiRest.repositories.ProfesorRepository;

/**
 *
 * @author Daniel Arias
 */
@Service
public class ProfesorService implements OperacionesInterface<Profesor, Integer> {

    @Autowired
    private ProfesorRepository repositoryProfesor;

    @Override
    public List<Profesor> obtenerTodos() {
        return repositoryProfesor.findAll();
    }

    @Override
    public Boolean agregar(Profesor miObjeto) {
        Profesor curso = repositoryProfesor.save(miObjeto);
        return curso != null;
    }

    @Override
    public Long cantidadRegistros() {
        return repositoryProfesor.count();
    }

    @Override
    public Boolean eliminar(Integer llavePrimaria) {
        repositoryProfesor.deleteById(llavePrimaria);
        return !repositoryProfesor.existsById(llavePrimaria);
    }

    @Override
    public Boolean actualizar(Profesor miObjeto) {
        Optional<Profesor> productoTemporal = repositoryProfesor.findById(miObjeto.getId());
        if (productoTemporal.isPresent()) {
            repositoryProfesor.save(miObjeto);
            return true;
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Te quedo algo mal en el JSON");
        }
    }

    @Override
    public Optional<Profesor> buscarPorId(Integer llavePrimaria) {
        return repositoryProfesor.findById(llavePrimaria);
    }

}
