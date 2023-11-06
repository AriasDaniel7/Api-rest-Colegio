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
import rest.apiRest.entities.Curso;
import rest.apiRest.interfaces.OperacionesInterface;
import rest.apiRest.repositories.CursoRepository;

/**
 *
 * @author Daniel Arias
 */
@Service
public class CursoService implements OperacionesInterface<Curso, Integer> {

    @Autowired
    private CursoRepository repositoryCurso;

    @Override
    public List<Curso> obtenerTodos() {
        return repositoryCurso.findAll();
    }

    @Override
    public Boolean agregar(Curso miObjeto) {
        Curso curso = repositoryCurso.save(miObjeto);
        return curso != null;
    }

    @Override
    public Long cantidadRegistros() {
        return repositoryCurso.count();
    }

    @Override
    public Boolean eliminar(Integer llavePrimaria) {
        repositoryCurso.deleteById(llavePrimaria);
        return !repositoryCurso.existsById(llavePrimaria);
    }

    @Override
    public Boolean actualizar(Curso miObjeto) {
        Optional<Curso> productoTemporal = repositoryCurso.findById(miObjeto.getId());
        if (productoTemporal.isPresent()) {
            repositoryCurso.save(miObjeto);
            return true;
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Te quedo algo mal en el JSON");
        }
    }

    @Override
    public Optional<Curso> buscarPorId(Integer llavePrimaria) {
        return repositoryCurso.findById(llavePrimaria);
    }

}
