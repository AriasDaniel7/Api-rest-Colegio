/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rest.apiRest.models;

/**
 *
 * @author Daniel Arias
 */
public class EndPoint {

    public String metodo;
    public String url;

    public EndPoint(String metodo, String url) {
        this.metodo = metodo;
        this.url = url;
    }

}
