/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos.enemigos;

import Enums.Direccion;

/**
 *
 * @author Yopuesquienmás
 */
public class Shooter extends Enemigo {

    public Shooter(boolean muerto, String nombre) {
        super(muerto, nombre);
    }

    @Override
    public void mover(Direccion dir) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
