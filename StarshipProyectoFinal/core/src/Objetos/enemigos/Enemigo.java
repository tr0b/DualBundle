/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos.enemigos;

import Objetos.ObjetoEspacial;

/**
 *
 * @author Yopuesquienmás
 */
public abstract class Enemigo extends ObjetoEspacial{
    
    public Enemigo(boolean muerto, String nombre) {
        super(muerto, nombre);
    }
    
}
