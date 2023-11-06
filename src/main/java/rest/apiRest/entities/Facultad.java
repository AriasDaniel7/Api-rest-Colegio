/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rest.apiRest.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.UniqueConstraint;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Daniel Arias
 */
@Entity
public class Facultad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "descripcion", nullable = false, length = 1000)
    private String descripcion;

    @Column(name = "mision_vision", nullable = false, length = 1000)
    private String misionYvision;

    @Column(name = "objetivo", nullable = false, length = 1000)
    private String objetivo;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "estudiante_facultad",
            joinColumns = @JoinColumn(name = "facultad_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "estudiante_id", referencedColumnName = "id"),
            uniqueConstraints = @UniqueConstraint(name = "key_compuesta_facultad_estudiante", columnNames = {"facultad_id", "estudiante_id"})
    )
    private List<Estudiante> estudiantes;

    @OneToMany(mappedBy = "facultad")
    @JsonBackReference
    private List<Curso> cursos;

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMisionYvision() {
        return misionYvision;
    }

    public void setMisionYvision(String misionYvision) {
        this.misionYvision = misionYvision;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

}
