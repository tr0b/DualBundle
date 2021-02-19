/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.starship.pantallas;

import Objetos.ObjetoEspacial;
import Objetos.jugable.Jugador;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.mygdx.starship.Starship;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Yopuesquienmás
 */
public class MenuPrincipal implements Screen {

    /*Importando librerias de libgdx podemos usar los objetos de abajo
    para crear menus*/
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
    private Texture spacetexture, botonjugarA, botonjugarI, botonsalirA, botonsalirI, logo;
    public static final String dirspace = "assets/space2.png";
    public static ObjetoEspacial jugador;
    SpriteBatch batch = new SpriteBatch();
    private final Starship starship;
    Random rand = new Random();

    public MenuPrincipal(Starship starship) {
        this.starship = starship;
        botonjugarA = new Texture("assets/button/jugaractivo.png");
        botonjugarI = new Texture("assets/button/jugarinactivo.png");
        botonsalirA = new Texture("assets/button/saliractivo.png");
        botonsalirI = new Texture("assets/button/salirinactivo.png");
        logo = new Texture("assets/logograndestarship.png");
    }

    @Override
    public void show() {
        spacetexture = new Texture(dirspace);
        

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        starship.batch.begin();
        starship.batch.draw(spacetexture, delta, delta);
        starship.batch.draw(logo, LOGO_X, LOGO_Y, LOGO_WIDTH, LOGO_HEIGHT);
        if (!mouseHoveringExit()) {//Boton SALIR LÓGICA
            starship.batch.draw(botonsalirI, BUTTON_X, SALIR_BUTTON_Y, BUTTON_WIDTH, BUTTON_HEIGHT);
        } else {
            starship.batch.draw(botonsalirA, BUTTON_X, SALIR_BUTTON_Y, BUTTON_WIDTH, BUTTON_HEIGHT);
            if (Gdx.input.isTouched()) {

                Gdx.app.exit();
            }
        }
        if (!mouseHoveringPlay()) {//BOTON JUGAR LÓGICA
            starship.batch.draw(botonjugarI, BUTTON_X, JUGAR_BUTTON_Y, BUTTON_WIDTH, BUTTON_HEIGHT);
        } else {
            starship.batch.draw(botonjugarA, BUTTON_X, JUGAR_BUTTON_Y, BUTTON_WIDTH, BUTTON_HEIGHT);
            if (Gdx.input.isTouched()) {
                ingresarNombre();
            }
        }

        starship.batch.end();
//        splash.batch.draw(botonsalirI, BUTTON_X, SALIR_BUTTON_Y, BUTTON_WIDTH, BUTTON_HEIGHT);
//        splash.batch.draw(botonjugarA, BUTTON_X, JUGAR_BUTTON_Y,BUTTON_WIDTH,BUTTON_HEIGHT);
//        splash.batch.draw(botonjugarI, BUTTON_X, JUGAR_BUTTON_Y, BUTTON_WIDTH, BUTTON_HEIGHT);        
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

    public boolean mouseHoveringExit() {
        return (Gdx.input.getX() < BUTTON_X + BUTTON_WIDTH && Gdx.input.getX() > BUTTON_X && HEIGHT - Gdx.input.getY() < SALIR_BUTTON_Y + BUTTON_HEIGHT && HEIGHT - Gdx.input.getY() > SALIR_BUTTON_Y);
    }

    public boolean mouseHoveringPlay() {
        return (Gdx.input.getX() < BUTTON_X + BUTTON_WIDTH && Gdx.input.getX() > BUTTON_X && HEIGHT - Gdx.input.getY() < JUGAR_BUTTON_Y + BUTTON_HEIGHT && HEIGHT - Gdx.input.getY() > JUGAR_BUTTON_Y);
    }

    public void ingresarNombre() {
        jugador = new Jugador(true, "Jugador", 2);
        TextoInp textoinput = new TextoInp();
        Gdx.input.getTextInput(textoinput, "Ingrese su Nombre", "", "Jugador");
        starship.setScreen(new PantallaJuego((this.starship), (Jugador) jugador, rand));
    }

    private void setupJugador(String nombre) {
        jugador.setNombre(nombre);
        
        

    }

}
