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
public class Enlace {

    public String nombreEntidad;
    public List<EndPoint> EndPoints;

    public Enlace(String nombreEntidad) {
        this.nombreEntidad = nombreEntidad;
        EndPoints = new ArrayList<>();
    }

    public void agregarEndPoint(EndPoint endPoint) {
        EndPoints.add(endPoint);
    }

}
