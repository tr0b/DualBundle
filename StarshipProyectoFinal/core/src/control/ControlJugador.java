/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import Enums.Direccion;
import Objetos.ObjetoEspacial;
import Objetos.Proyectil;
import Objetos.jugable.Jugador;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;
import static com.mygdx.starship.pantallas.MenuPrincipal.jugador;
import java.util.ArrayList;

/**
 *
 * @author Yopuesquienmás
 */
public class ControlJugador extends InputAdapter {

    private ObjetoEspacial oe;
    private int vel = 15;
    private boolean arriba, abajo, izq, der;

    public ControlJugador(ObjetoEspacial oe) {
        this.oe = oe;
    }

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode) {
            case Keys.W:
                arriba = true;
                break;
            case Keys.S:
                abajo = true;
                break;
            case Keys.A:
                izq = true;
                break;
            case Keys.D:
                der = true;
                break;
                
        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        /*Cuando la tecla indicada se suelta, se indicara que esa posicion
        no está activa*/
        switch (keycode) {
            case Keys.W:
                arriba = false;
                break;
            case Keys.S:
                abajo = false;
                break;
            case Keys.A:
                izq = false;
                break;
            case Keys.D:
                der = false;
                break;
        }
        return false;
    }

    public void update(float f) {
        /*IMPLEMENTACIÓN TOTAL DEL MOVIMIENTO EN LAS 8 DIRECCIONES CARDINALES*/
        if (arriba) {
            if (arriba && izq) {
                oe.mover(Direccion.noroeste);
                return;
            }
            if (arriba && der) {
                oe.mover(Direccion.noreste);
                return;
            }
            oe.mover(Direccion.norte);
            return;

        }

        if (abajo) {
            if (abajo && izq) {
                oe.mover(Direccion.suroeste);
                return;
            }
            if (abajo && der) {
                oe.mover(Direccion.sureste);
                return;
            }
            oe.mover(Direccion.sur);
            return;
        }

        if (izq) {
            oe.mover(Direccion.oeste);
            return;
        }
        if (der) {
            oe.mover(Direccion.este);
            return;
        }
    }

}
