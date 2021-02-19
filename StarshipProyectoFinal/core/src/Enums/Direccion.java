/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enums;

import com.badlogic.gdx.Gdx;
import com.mygdx.starship.Starship;

/**
 *
 * @author Yopuesquienmás
 */

public enum Direccion {
    
    
    norte(0, Starship.vel*Gdx.graphics.getDeltaTime()),
    noroeste(-Starship.vel*Gdx.graphics.getDeltaTime(), Starship.vel*Gdx.graphics.getDeltaTime()),
    noreste(Starship.vel*Gdx.graphics.getDeltaTime(), Starship.vel*Gdx.graphics.getDeltaTime()),
    este(Starship.vel*Gdx.graphics.getDeltaTime(),0),
    sureste(Starship.vel*Gdx.graphics.getDeltaTime(), -Starship.vel*Gdx.graphics.getDeltaTime()),
    suroeste(-Starship.vel*Gdx.graphics.getDeltaTime(), -Starship.vel*Gdx.graphics.getDeltaTime()),
    sur(0,-Starship.vel*Gdx.graphics.getDeltaTime()),
    oeste(-Starship.vel*Gdx.graphics.getDeltaTime(),0);
    private float velX,velY;
    

    private Direccion(float velX, float velY) {
        this.velX = velX;
        this.velY = velY;
    }

    public float getVelX() {
        return velX;
    }

    public float getVelY() {
        return velY;
    }
    


}
