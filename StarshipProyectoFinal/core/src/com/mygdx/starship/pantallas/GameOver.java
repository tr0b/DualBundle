/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.starship.pantallas;


import Objetos.Client;
import Objetos.Puntuacion;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.utils.Align;
import com.mygdx.starship.Starship;
import static com.mygdx.starship.pantallas.MenuPrincipal.HEIGHT;
import static com.mygdx.starship.pantallas.PantallaJuego.DIR_FONT_BLANCO;
import static com.mygdx.starship.pantallas.PantallaJuego.jugador;
import static com.mygdx.starship.pantallas.PantallaJuego.spacetexture;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ulacit
 */
public class GameOver implements Screen {
    /*Clase que contendrá la pantalla de GameOver*/
    BitmapFont  TituloPuntajeFont, PuntuacionFont, PuntuacionMayorFont;
    private Button botonRegresar;
    private Starship starship;
    private int puntuacion, puntuacionmayor;
    Texture botonsalirA, botonsalirI, GameOverBanner;
    private static final int BANNER_WIDTH = 500;
    private static final int BANNER_HEIGHT = 400;
    public final static int WIDTH = 720;
    public final static int HEIGHT = 900;
    private static final int BUTTON_WIDTH = 320;
    private static final int BUTTON_HEIGHT = 110;
    private static final int LOGO_WIDTH = 300;
    private static final int LOGO_HEIGHT = 300;
    private static final int SALIR_BUTTON_Y = 75;
    private static final int JUGAR_BUTTON_Y = 275;
    private static final int LOGO_Y = 300;
    private static final int BUTTON_X = (WIDTH - BUTTON_WIDTH) / 2;
    private static final int LOGO_X = (WIDTH - LOGO_WIDTH) / 2;
    private static final String GAME_OVER_DIR = "assets/gameover.png";
    
    Preferences pref;
    
    

    public GameOver(int puntuacion, Starship starship) {
        
        pref = Gdx.app.getPreferences("starship");
        this.botonRegresar = botonRegresar;
        this.puntuacion = puntuacion;
        this.puntuacionmayor = pref.getInteger("puntuacionmayor", 0);
        this.starship = starship;
        //Cargar texturas
        botonsalirA = new Texture("assets/button/saliractivo.png");
        botonsalirI = new Texture("assets/button/salirinactivo.png");
        PuntuacionFont = new BitmapFont(Gdx.files.internal("assets/font/white.fnt"));
        PuntuacionMayorFont = new BitmapFont(Gdx.files.internal("assets/font/white.fnt"));
        GameOverBanner = new Texture(GAME_OVER_DIR);
        if(puntuacion > puntuacionmayor){
            pref.putInteger("puntuacionmayor", puntuacion);
            pref.flush();
            this.puntuacionmayor = puntuacion;
        }
        
    }

    @Override
    public void show() {
        
    }

    @Override
    public void render(float f) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        
        
        starship.batch.begin();
        
        starship.batch.draw(spacetexture, f, f);
        GlyphLayout puntuacionjug = new GlyphLayout(PuntuacionFont, "Puntuacion: " + puntuacion, Color.YELLOW, 0, Align.left, false);
        GlyphLayout puntuacionmayor = new GlyphLayout(PuntuacionFont, "Puntuacion Mayor: " + this.puntuacionmayor, Color.YELLOW, 0, Align.left, false);
        PuntuacionFont.draw(starship.batch, puntuacionjug, (Gdx.graphics.getWidth()-puntuacionjug.width)/2, (Gdx.graphics.getHeight()-puntuacionjug.height)/2);
        PuntuacionMayorFont.draw(starship.batch, puntuacionmayor, (Gdx.graphics.getWidth()-puntuacionmayor.width)/2, (Gdx.graphics.getHeight()-puntuacionmayor.height)/2-50);
        starship.batch.draw(GameOverBanner, (Gdx.graphics.getWidth() - BANNER_WIDTH)/2, Gdx.graphics.getHeight()-BANNER_HEIGHT-15, BANNER_WIDTH, BANNER_HEIGHT);
        if(!mouseHoveringExit()){
            starship.batch.draw(botonsalirI, BUTTON_X, SALIR_BUTTON_Y, BUTTON_WIDTH, BUTTON_HEIGHT);
        }else{
            starship.batch.draw(botonsalirA, BUTTON_X, SALIR_BUTTON_Y, BUTTON_WIDTH, BUTTON_HEIGHT);
            if(Gdx.input.isTouched()){
                String tempnombre = jugador.getNombre();
                Client cliente = new Client(new Puntuacion(tempnombre, puntuacion));
                cliente.start();
                starship.setScreen(new MenuPrincipal(starship));
            }
        }
        
        starship.batch.end();
    }

    @Override
    public void resize(int i, int i1) {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void dispose() {
        
    }
    public boolean mouseHoveringExit() {//Metodo para saber si el mouse está sobre el boton SALIR
        return (Gdx.input.getX() < BUTTON_X + BUTTON_WIDTH && Gdx.input.getX() > BUTTON_X && HEIGHT - Gdx.input.getY() < SALIR_BUTTON_Y + BUTTON_HEIGHT && HEIGHT - Gdx.input.getY() > SALIR_BUTTON_Y);
    }
    
}
