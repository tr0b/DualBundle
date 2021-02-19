/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import Enums.Direccion;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 *
 * @author Yopuesquienmás
 */
public class Explosion{

    public static final float LONGITUD_FRAME_EXPLOSION = 0.1f;
    public static final int OFFSET = 8;
    public static final int SIZE_EXPLOSION = 32;
    public static final int EXPLOSION_WIDTH = SIZE_EXPLOSION*2;
    public static final int EXPLOSION_HEIGHT = SIZE_EXPLOSION*2;
    public static Animation<TextureRegion> explosion_anim;
    public static final String direxplosion = "assets/explosion2.png";
    float x, y;
    float estadotiempoanim;
    public boolean eliminar = false;

    public Explosion(float posx, float posy) {
        this.x = posx - OFFSET;
        this.y = posy - OFFSET;
        estadotiempoanim = 0;
        if (explosion_anim == null) {
            explosion_anim = new Animation(LONGITUD_FRAME_EXPLOSION, (Object[]) TextureRegion.split(new Texture(direxplosion), SIZE_EXPLOSION, SIZE_EXPLOSION)[0]);
        }

    }

    public void actualizar(float delta) {
        estadotiempoanim += delta;
        if (explosion_anim.isAnimationFinished(estadotiempoanim)) {
            eliminar = true;
        }
    }

    public void render(SpriteBatch batch) {
        batch.draw(explosion_anim.getKeyFrame(estadotiempoanim), x, y, EXPLOSION_WIDTH, EXPLOSION_HEIGHT);
    }

    public boolean isEliminado() {
        return eliminar;
    }

    

}
