/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.starship.pantallas;

import Objetos.ObjetoEspacial;
import Objetos.jugable.Jugador;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import static com.mygdx.starship.pantallas.MenuPrincipal.jugador;

/**
 *
 * @author Yopuesquienmás
 */
public class TextoInp implements Input.TextInputListener {
    String nombre;

    @Override
    public void input(String nombre) {
        try{
            jugador.setNombre(nombre);
            
        }catch(Exception e){
            
        }
    }

    @Override
    public void canceled() {
        this.nombre = "Jugador";
    }
    
}
