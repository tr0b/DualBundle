/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.starship.pantallas;

import Objetos.Explosion;
import Objetos.Proyectil;
import Objetos.enemigos.Asteroide;
import Objetos.jugable.Jugador;
import static Objetos.jugable.Jugador.NAVE_PIX_HEIGHT;
import static Objetos.jugable.Jugador.NAVE_PIX_WIDTH;
import static Objetos.jugable.Jugador.intervalo_animacion;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.starship.Starship;
import control.ControlJugador;
import Enums.Direccion;
import Enums.Estado;
import Enums.Puntuaciones;
import Objetos.Colision;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import static java.lang.Math.random;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Yopuesquienmás
 */
public class PantallaJuego implements Screen {

    SpriteBatch batch = new SpriteBatch();
    private Starship starship;
    public static Texture spacetexture;
    public static Jugador jugador;
    private String filepathtexture1 = "assets/NAVE2ACT.png";
    private String filepathtexture2 = "assets/NAVE2Rec.png";
    private ControlJugador cju;
    ArrayList<Proyectil> proyectiles;
    ArrayList<Asteroide> asteroides;
    public static ArrayList<Explosion> explosiones;
    private Random random;
    private Colision rect;
    public static final String DIR_FONT_BLANCO = "assets/font/white.fnt";

    public static final String DIR_ESPACIO_ANIMADO = "assets/space2.png";

    public Animation<TextureRegion>[] estadosjugador; //se van a manejar las animaciones de la nave aquí
    public Animation<TextureRegion> fondoespacio;
    public TextureRegion[] framesfondoespacio;
    TextureRegion[][] tempframesespacio;
    public static final float minAsteroidSpawnTimer = 0.3f;//tiempo de espera minimo para spawnear un asteroide 
    public static final float maxAsteroidSpawnTimer = 0.6f;//tiempo de espera maximo para spawnear un asteroide 
    float[] positions;
    float x, y;
    float tiempoSpawnasteroide;
    float stateTime;
    BitmapFont fontPuntaje, fontVidas;
    int puntuacion, vidas;

    @Override
    public void show() {
        spacetexture = new Texture(MenuPrincipal.dirspace);
        Gdx.input.setInputProcessor(cju);
    }

    public PantallaJuego(Starship starship, Jugador jugador, Random random) {
        this.starship = starship;
        this.jugador = jugador;

        fontPuntaje = new BitmapFont(Gdx.files.internal(DIR_FONT_BLANCO));
        fontPuntaje.setColor(1f, 1f, 0f, 1f);
        fontVidas = new BitmapFont(Gdx.files.internal(DIR_FONT_BLANCO));
        fontVidas.setColor(1f, 1f, 0f, 1f);
        this.puntuacion = 0;
        this.vidas = 2;
        int stateA = 2;//Estado de la animacion actual
        this.cju = new ControlJugador(jugador);
        proyectiles = new ArrayList<>();
        asteroides = new ArrayList<>();
        explosiones = new ArrayList<>();
        this.random = new Random();
        estadosjugador = new Animation[3];
        TextureRegion[][] hojatexturasactive = TextureRegion.split(new Texture(filepathtexture1), NAVE_PIX_WIDTH, NAVE_PIX_HEIGHT);
        tempframesespacio = TextureRegion.split(new Texture(DIR_ESPACIO_ANIMADO), 768, 920);
        framesfondoespacio = new TextureRegion[15];
        estadosjugador[stateA] = new Animation(intervalo_animacion, (Object[]) hojatexturasactive[0]);
    }

    @Override
    public void render(float delta) {
        //RENDER ESPACIO ANIMADO (PRUEBA)
        int indexespacioanim = 0;
        try {
            for (int i = 0; i < 15; i++) {
                framesfondoespacio[indexespacioanim++] = tempframesespacio[0][i];
            }
        }catch(Exception e){
            System.out.println("Ocurrio un error, regresando al menu principal");
            starship.setScreen(new MenuPrincipal(starship));
        }

        fondoespacio = new Animation(0.04f, (Object[]) framesfondoespacio);
        //FIN RENDER ESPACIO ANIMADO

        //Asteroid Spawn
        tiempoSpawnasteroide -= delta;
        if (tiempoSpawnasteroide <= 0) {
            float temp = random.nextFloat();
            tiempoSpawnasteroide = random.nextFloat() * (maxAsteroidSpawnTimer - minAsteroidSpawnTimer) + minAsteroidSpawnTimer;
            asteroides.add(new Asteroide((temp * (Gdx.graphics.getWidth() - Asteroide.WIDTH_ASTEROIDE)), false, "asteroide"));
        }
        ArrayList<Asteroide> asteroidesremove = new ArrayList<>();
        for (Asteroide asteroide : asteroides) {
            asteroide.update(delta);
            if (asteroide.isMuerto()) {
                asteroidesremove.add(asteroide);
            }
        }
        asteroides.removeAll(asteroidesremove);

        //Disparo Spawn
        if (Gdx.input.isKeyJustPressed(Keys.SPACE)) {
            proyectiles.add(new Proyectil(jugador.getX() + Jugador.NAVE_WIDTH / 2, jugador.getY() + 10, false, "proyectil", 1));
            proyectiles.add(new Proyectil(jugador.getX(), jugador.getY() + 10, false, "proyectil", 1));
        }
        //Fin Disparo Spawn

        //UPDATE DISPARO
        ArrayList<Proyectil> proyectilesremover = new ArrayList<>();
        for (Proyectil proyectil : proyectiles) {
            proyectil.mover(Direccion.norte);
            if (proyectil.isMuerto()) {
                proyectil = null;

            }

        }
        //FIN UPDATE DISPARO

        //COLISION ASTEROIDE - PROYECTIL
        proyectiles.forEach((proyectil) -> {
            asteroides.forEach((asteroide) -> {
                if (proyectil.colisiona(asteroide.getFronteras())) {
                    explosiones.add(new Explosion(asteroide.getX(), asteroide.getY()));
                    proyectil.muerte(true);
                    asteroide.muerte(true);
                    puntuacion += Puntuaciones.Asteroide.getPuntaje();
                }
            });
        });
        //EXPLOSIONES SPAWN
        ArrayList<Explosion> explosionesremover = new ArrayList<>();
        for (Explosion explosion : explosiones) {
            explosion.actualizar(delta);
            if (explosion.isEliminado()) {
                explosionesremover.add(explosion);
            }
        }
        for (Explosion explosion : explosiones) {
            explosion.actualizar(delta);
            if (explosion.isEliminado()) {
                explosionesremover.add(explosion);
            }
        }

        explosiones.removeAll(explosionesremover);

        asteroides.removeAll(asteroidesremove);
        proyectiles.removeAll(proyectilesremover);
        //FIN COLISION ASTEROIDE - PROYECTIL

        //COLISION JUGADOR-ASTEROIDE
        asteroides.forEach((asteroide) -> {
            if (this.jugador.colisiona(asteroide.getFronteras())) {
                if (vidas == 0) {
                    starship.setScreen(new GameOver(puntuacion, starship));
                }
                this.jugador.setEstado(Estado.Golpeado);
                asteroide.muerte(true);
                vidas -= 1;
            }
        });
        cju.update(delta);//Refrezca control del jugador
        jugador.update(delta);
        stateTime += delta;
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        starship.batch.begin();
        starship.batch.draw(fondoespacio.getKeyFrame(stateTime, true), 0, 0);

        GlyphLayout puntajeLayout = new GlyphLayout(fontPuntaje, "PUNTAJE: " + puntuacion);
        fontPuntaje.draw(starship.batch, puntajeLayout, Gdx.graphics.getWidth() - 700, Gdx.graphics.getHeight() - puntajeLayout.height);
        GlyphLayout vidasLayout = new GlyphLayout(fontPuntaje, "VIDAS: " + vidas);
        fontVidas.draw(starship.batch, vidasLayout, Gdx.graphics.getWidth() - 150, Gdx.graphics.getHeight() - vidasLayout.height);

        for (Proyectil proyectil : proyectiles) {
            proyectil.render(starship.batch);
        }
        for (Asteroide asteroide : asteroides) {
            asteroide.render(starship.batch);
        }
        for (Explosion explosion : explosiones) {
            explosion.render(starship.batch);
        }
        starship.batch.draw(estadosjugador[2].getKeyFrame(stateTime, true), jugador.getX(), jugador.getY(), Jugador.NAVE_WIDTH, Jugador.NAVE_HEIGHT);
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
    

}
