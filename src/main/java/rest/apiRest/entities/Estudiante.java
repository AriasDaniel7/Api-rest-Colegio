/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rest.apiRest.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.UniqueConstraint;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Daniel Arias
 */
@Entity
public class Estudiante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "edad", nullable = false)
    private Integer edad;

    @Column(name = "genero", nullable = false)
    private String genero;

    @Column(name = "correo", nullable = false, unique = true)
    private String correo;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "estudiante_curso",
            joinColumns = @JoinColumn(name = "estudiante_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "curso_id", referencedColumnName = "id"),
            uniqueConstraints = @UniqueConstraint(name = "key_compuesta", columnNames = {"estudiante_id", "curso_id"})
    )
    @JsonIgnore
    private List<Curso> cursos;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "estudiante_facultad",
            joinColumns = @JoinColumn(name = "estudiante_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "facultad_id", referencedColumnName = "id"),
            uniqueConstraints = @UniqueConstraint(name = "key_compuesta_facultad_estudiante", columnNames = {"estudiante_id", "facultad_id"})
    )
    @JsonIgnore
    private List<Facultad> facultades;

    public Estudiante() {
    }

    public Estudiante(Integer id, String nombre, Integer edad, String genero, String correo, List<Curso> cursos, List<Facultad> facultades) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;
        this.correo = correo;
        this.cursos = cursos;
        this.facultades = facultades;
    }

    public List<Facultad> getFacultades() {
        return facultades;
    }

    public void setFacultades(List<Facultad> facultades) {
        this.facultades = facultades;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Estudiante{" + "id=" + id + ", nombre=" + nombre + ", edad=" + edad + ", genero=" + genero + ", correo=" + correo + '}';
    }

}
