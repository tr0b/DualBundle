/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos.jugable;

import Enums.Estado;
import Objetos.ObjetoEspacial;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Interpolation;
import com.mygdx.starship.pantallas.MenuPrincipal;
import Enums.Direccion;
import Objetos.Explosion;
import static Objetos.Explosion.LONGITUD_FRAME_EXPLOSION;
import static Objetos.Explosion.SIZE_EXPLOSION;
import com.badlogic.gdx.math.Rectangle;
import static com.mygdx.starship.pantallas.PantallaJuego.explosiones;


/**
 *
 * @author Yopuesquienmás
 */
public class Jugador extends ObjetoEspacial {

    public static final int NAVE_PIX_WIDTH = 64;
    public static final int NAVE_PIX_HEIGHT = 64;
    public static final int NAVE_WIDTH = NAVE_PIX_WIDTH;
    public static final int NAVE_HEIGHT = NAVE_PIX_HEIGHT;
    public static final float intervalo_animacion = 0.4f;
    public static final float VEL = 100;
    private float iniciox, inicioy, intervalox, intervaloy;
    private float destinox, destinoy;
    private float animTimer;
    private float anim_tiempo = 0.09f;
    private Estado estado;
    private Rectangle fronterasjugador;
    public static final String direxplosion = "assets/explosion2.png";
    public static Animation<TextureRegion> explosion_anim;
    float estadotiempoanim;

    int puntuaciontotal;
    Texture texturaNave;
    private String game;
    private int vidas;

    private boolean recovering;//falso. verdadero cuando el jugador sea golpeado
    private int hp;

    public Jugador(boolean muerto, String nombre, int hp) {
        super(muerto, nombre);
        this.muerto = muerto;
        this.hp = hp;
        this.game = game;
        this.nombre = nombre;
        super.x = (MenuPrincipal.WIDTH - NAVE_HEIGHT) / 2;
        super.y = 10;
        this.estado = Estado.Neutro;
        estadotiempoanim = 0;
        this.fronterasjugador = new Rectangle(x, y, NAVE_WIDTH, NAVE_HEIGHT);

    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntuaciontotal() {
        return puntuaciontotal;
    }

    public void setPuntuaciontotal(int puntuaciontotal) {
        this.puntuaciontotal = puntuaciontotal;
    }

    public Texture getTexturaNave() {
        return texturaNave;
    }

    public void setTexturaNave(Texture texturaNave) {
        this.texturaNave = texturaNave;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
    
    @Override
    public void mover(Direccion dir) {
        
        if(estado != Estado.Neutro){
            return;
        }
        inicioMovimiento(dir);
        x += dir.getVelX();
        y += dir.getVelY();
        fronterasjugador.set(x, y, NAVE_WIDTH - 7, NAVE_HEIGHT -7);
        if (outOfBoundsXMinus(dir)) {
            x = 0;
        }
        if (outOfBoundsXPlus(dir)) {
            x = Gdx.graphics.getWidth() - NAVE_WIDTH;
        }
        if (outOfBoundsYMinus(dir)) {
            y = 0;
        }
        if (outOfBoundsYPlus(dir)) {
            y = Gdx.graphics.getHeight() - NAVE_HEIGHT;
        }
        

    }

    public boolean outOfBoundsXMinus(Direccion dir) {
        /*Comprueba de que la nave no se vaya fuera de fronteras izquierda o sur*/
        return (x + dir.getVelX()< 0);
    }

    public boolean outOfBoundsXPlus(Direccion dir) {
        /*Comprueba de que la nave no se vaya fuera de fronteras derecha o norte*/
        return (x + NAVE_WIDTH >= Gdx.graphics.getWidth());
    }

    public boolean outOfBoundsYMinus(Direccion dir) {
        /*Comprueba de que la nave no se vaya fuera de fronteras izquierda o sur*/
        return (y + dir.getVelY()< 0);
    }

    public boolean outOfBoundsYPlus(Direccion dir) {
        /*Comprueba de que la nave no se vaya fuera de fronteras derecha o norte*/
        return (y + NAVE_HEIGHT >= Gdx.graphics.getHeight());
    }

    public void update(float f) {
        if (estado == Estado.Movimiento) {
            animTimer += f;
            intervalox = Interpolation.pow2.apply(iniciox, destinox, animTimer/anim_tiempo);
            intervaloy =Interpolation.pow2.apply(inicioy, destinoy, animTimer/anim_tiempo);
            if(animTimer > anim_tiempo){
                finMovimiento();
            }
        }
        if(estado == Estado.Golpeado){
            estadotiempoanim+=f;
            
            explosion_anim = new Animation(LONGITUD_FRAME_EXPLOSION, (Object[]) TextureRegion.split(new Texture(direxplosion), SIZE_EXPLOSION, SIZE_EXPLOSION)[0]);
            explosiones.add(new Explosion(x, y));
            if(explosion_anim.isAnimationFinished(estadotiempoanim)){
                this.setX((Gdx.graphics.getWidth() - NAVE_WIDTH)/2);
                this.setY(25);
                setEstado(Estado.Neutro);
            }
            
        }
    }

    public void inicioMovimiento(Direccion dir) {
        this.iniciox = x;
        this.inicioy = y;
        this.intervalox = x;
        this.intervaloy = y;
        this.destinox = x + dir.getVelX();
        this.destinoy = y + dir.getVelY();
        animTimer = 0.15f;
        estado = Estado.Movimiento;

    }

    public void finMovimiento() {
        estado = Estado.Neutro;

    }

    public float getIntervalox() {
        return intervalox;
    }

    public float getIntervaloy() {
        return intervaloy;
    }

    public boolean colisiona(Rectangle r){
        return r.overlaps(this.fronterasjugador);
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    
    
    

}
