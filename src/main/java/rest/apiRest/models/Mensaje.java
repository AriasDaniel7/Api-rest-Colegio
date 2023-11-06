/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rest.apiRest.models;

/**
 *
 * @author Daniel Arias
 */
public class Mensaje {

    public Integer status;
    public String message;

    public Mensaje(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

}
