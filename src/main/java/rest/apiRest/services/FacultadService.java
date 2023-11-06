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
import rest.apiRest.entities.Facultad;
import rest.apiRest.interfaces.OperacionesInterface;
import rest.apiRest.repositories.FacultadRepository;

/**
 *
 * @author Daniel Arias
 */
@Service
public class FacultadService implements OperacionesInterface<Facultad, Integer> {

    @Autowired
    private FacultadRepository repositoryFacultad;

    @Override
    public List<Facultad> obtenerTodos() {
        return repositoryFacultad.findAll();
    }

    @Override
    public Boolean agregar(Facultad miObjeto) {
        Facultad curso = repositoryFacultad.save(miObjeto);
        return curso != null;
    }

    @Override
    public Long cantidadRegistros() {
        return repositoryFacultad.count();
    }

    @Override
    public Boolean eliminar(Integer llavePrimaria) {
        repositoryFacultad.deleteById(llavePrimaria);
        return !repositoryFacultad.existsById(llavePrimaria);
    }

    @Override
    public Boolean actualizar(Facultad miObjeto) {
        Optional<Facultad> productoTemporal = repositoryFacultad.findById(miObjeto.getId());
        if (productoTemporal.isPresent()) {
            repositoryFacultad.save(miObjeto);
            return true;
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Te quedo algo mal en el JSON");
        }
    }

    @Override
    public Optional<Facultad> buscarPorId(Integer llavePrimaria) {
        return repositoryFacultad.findById(llavePrimaria);
    }

}
