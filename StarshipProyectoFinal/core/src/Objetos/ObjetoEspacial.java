/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import Enums.Direccion;

/**
 *
 * @author Yopuesquienmás
 */
public abstract class ObjetoEspacial {
    protected boolean muerto;
    protected String nombre;
    protected float x,y;
    public void muerte(boolean muerte){
        this.muerto = muerte;
    }

    public ObjetoEspacial(boolean muerto, String nombre) {
        this.muerto = muerto;
        this.nombre = nombre;
    }
    public abstract void mover(Direccion dir);

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public boolean isMuerto() {
        return muerto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
