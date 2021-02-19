package com.mygdx.starship;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.starship.pantallas.MenuPrincipal;
;

public class Starship extends Game {
    
    public SpriteBatch batch;
    Texture img;
    public static final String nombrejuego = "Starship";
    public static final String version = "0.1a";
    public static final int vidas = 2;
    public final static int vel = 400;
    public static final String DIR_TEXTURA_PROYECTIL = "assets/disparo.png";

    @Override
    public void create() {
        batch = new SpriteBatch();
        this.setScreen(new MenuPrincipal(this));
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    public void pause() {
        super.pause();
    }

    @Override
    public void resume() {
        super.resume();
    }

}
