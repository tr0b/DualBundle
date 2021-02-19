/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Objetos.enemigos;

import Enums.Direccion;
import Objetos.Colision;
import Objetos.ObjetoEspacial;
import static Objetos.Proyectil.HEIGHT;
import static Objetos.Proyectil.WIDTH;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.starship.Starship;

/**
 *
 * @author kenda
 */
public class Asteroide extends Enemigo{
    
    public static final int velocidad_asteroide = 250;
    public static final int WIDTH_ASTEROIDE = 16;
    public static final int HEIGHT_ASTEROIDE = 16;
    private Texture asteroidtexture;
    private Rectangle fronterasasteroides;
    private final String dirtextast = "assets/Asteroid.png";
    
    float x, y;
    Colision rect;
    public boolean remove = false;
    
//    public Asteroide (float x){
//        this.x = x;
//        this.y = Gdx.graphics.getHeight();
//        
//        this.fronterasasteroides = new Rectangle(x, y, WIDTH_ASTEROIDE, HEIGHT_ASTEROIDE);
//        
//        
//    }

    public Asteroide(float x, boolean muerto, String nombre) {
        super(muerto, nombre);
        this.asteroidtexture = new Texture(dirtextast);
        this.fronterasasteroides = new Rectangle(x, y, WIDTH_ASTEROIDE, HEIGHT_ASTEROIDE);
        this.x = x;
        this.y = Gdx.graphics.getHeight();
    }
    
    
    public void update(float deltaTime){
        y-= velocidad_asteroide  * deltaTime;
        fronterasasteroides.set(x, y, WIDTH_ASTEROIDE, HEIGHT_ASTEROIDE);
        if (y < - HEIGHT_ASTEROIDE)
            super.muerte(true);
    }
    
    public void render(SpriteBatch batch){
        batch.draw(asteroidtexture, x, y);
    }
    
    public Rectangle getFronteras(){
        return fronterasasteroides;
    }

    @Override
    public void mover(Direccion dir) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

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
    
    
}
