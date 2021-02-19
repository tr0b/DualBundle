/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.starship.tween;

import aurelienribon.tweenengine.TweenAccessor;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.starship.Starship;

/**
 *
 * @author Yopuesquienmás
 */
public class SpriteAccessor implements TweenAccessor<Sprite>{
    private Starship starship;
    public static final int Alpha = 0;

    public SpriteAccessor(Starship starship) {
        this.starship = starship;
    }
    

    @Override
    public int getValues(Sprite target, int tweenType, float[] returnValues) {
       switch(tweenType){
           case Alpha:
               returnValues[0] = target.getColor().a;
               return 1;
           default:
               assert false;
               return -1;
               
       }
    }
    /*Gracias a los Tween Engines, en este caso, el Universal Tween Engine,
    podemos crear animaciones intermediarias más fluidas y crear fade outs, y
    fade ins.*/

    @Override
    public void setValues(Sprite target, int tweenType, float[] newValues) {
         switch(tweenType){
             case Alpha:
                 target.setColor(target.getColor().r, target.getColor().g, target.getColor().b, newValues[0]);
                 break;
             default:
                 assert false;
                 
         }
    }
    
}
