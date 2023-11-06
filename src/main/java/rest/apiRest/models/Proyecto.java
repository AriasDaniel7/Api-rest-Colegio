/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rest.apiRest.models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Daniel Arias
 */
public class Proyecto {

    public String proyecto;
    public String descripcion;
    public List<Enlace> enlaces;

    public Proyecto(String proyecto, String descripcion) {
        this.proyecto = proyecto;
        this.descripcion = descripcion;
        this.enlaces = new ArrayList<>();
    }

    public void crearEnlaces(Enlace enlace) {
        enlaces.add(enlace);
    }

}
