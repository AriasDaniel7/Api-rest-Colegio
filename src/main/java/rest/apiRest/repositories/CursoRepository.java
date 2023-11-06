/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package rest.apiRest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rest.apiRest.entities.Curso;

/**
 *
 * @author Daniel Arias
 */
@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {

}
