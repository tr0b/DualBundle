/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.starship.Starship;
import Enums.Direccion;
import com.badlogic.gdx.math.Rectangle;

/**
 *
 * @author Yopuesquienmás
 */
public class Proyectil extends ObjetoEspacial {

    public static final int VEL_PROYECTIL = 800;
    public static final int WIDTH = 6;
    public static final int HEIGHT = 12;
    private Texture proyectiltextura;
    private Rectangle fronterasproyectil;
    
    float dx, dy;
    Colision rect;
    public Proyectil(float x, float y, boolean muerto, String nombre, int hp) {
        super(muerto, nombre);
        
        fronterasproyectil = new Rectangle(x, y, WIDTH, HEIGHT);
        this.x = x;
        this.y = y;
        proyectiltextura = new Texture(Starship.DIR_TEXTURA_PROYECTIL);
    }
    
    @Override
    public void mover(Direccion dir) {
        y += Direccion.norte.getVelY();
        fronterasproyectil.set(x, y, WIDTH, HEIGHT);
        if (y > Gdx.graphics.getHeight()) {
            super.muerte(true);
        }
    }
    public void render(SpriteBatch batch){
        batch.draw(proyectiltextura, x, y);
    }
    public boolean colisiona(Rectangle r){
        return r.overlaps(this.fronterasproyectil);
    }
    
    
    
}
