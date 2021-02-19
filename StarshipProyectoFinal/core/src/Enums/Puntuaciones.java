/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enums;

/**
 *
 * @author Yopuesquienmás
 */
public enum Puntuaciones {
    Asteroide(5);
    public int puntaje;

    private Puntuaciones(int puntaje) {
        this.puntaje = puntaje;
    }

    public int getPuntaje() {
        return puntaje;
    }
    
}
