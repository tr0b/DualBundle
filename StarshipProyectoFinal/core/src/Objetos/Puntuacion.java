/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Yopuesquienmás
 */
public class Puntuacion implements Serializable{
    private String nombre;
    private int puntaje;

    public Puntuacion(String nombre, int puntaje)
    {
        this.nombre = nombre;
        this.puntaje = puntaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntuacion() {
        return puntaje;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntaje = puntuacion;
    }
    public String printPuntuacion() {
        return "Puntuacion: \n" + "nombre: \n" + nombre + ", puntaje: \n" + puntaje;
    }

}


