/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

/**
 *
 * @author kenda
 */
public class Colision {
    float x, y;
    int width, height;
    
    public Colision(float x, float y, int width, int height){
        this.x= x;
        this.y=y;
        this.width= width;
        this.height = height;
    }
    public void mover (float x, float y){
        this.x= x;
        this.y=y;
    }
    public boolean colisionaCon (Colision rect){
        return x < rect.x + rect.width && y < rect.y + rect.height && x + width > rect.x && y + height >rect.y;
    }
}
