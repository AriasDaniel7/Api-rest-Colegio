/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rest.apiRest.entities;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.UniqueConstraint;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Daniel Arias
 */
@Entity
public class Curso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "fecha_inicio", nullable = false)
    private Date fechaInicio;

    @Column(name = "fecha_final", nullable = true)
    private Date fechaFinal;

    @ManyToOne
    @JoinColumn(name = "profesor_id", referencedColumnName = "id", nullable = true)
    private Profesor profesor;

    @ManyToOne
    @JsonIncludeProperties(value = {"id","nombre","descripcion","misionYvision","objetivo"})
    @JoinColumn(name = "facultad_id", referencedColumnName = "id", nullable = true)
    private Facultad facultad;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "estudiante_curso",
            joinColumns = @JoinColumn(name = "curso_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "estudiante_id", referencedColumnName = "id"),
            uniqueConstraints = @UniqueConstraint(name = "key_compuesta", columnNames = {"curso_id", "estudiante_id"})
    )
    private List<Estudiante> estudiantes;

    public Facultad getFacultad() {
        return facultad;
    }

    public void setFacultad(Facultad facultad) {
        this.facultad = facultad;
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

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

}
