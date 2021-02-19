/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoconcuflappy;

//import sounds.Sonido;
/**
 *
 * @author Josue Hernandez
 */
public class Tubos extends Thread {

    static int vel;
    private static int puntos;

    public Tubos() {
        vel = 7;
        puntos = 0;
        ocultarTubos();
    }

    private static synchronized void sumarPuntos() {
        int tubo1 = Jugar.jTubo_arriba1.getLocation().x;
        int tubo2 = Jugar.jTubo_arriba2.getLocation().x;
        if (tubo1 == 90) {
            puntos = puntos + 1;
            Jugar.Puntuacion.setText(puntos + "");
            if (puntos == 30 || puntos == 50 || puntos == 130 || puntos == 160 || puntos == 200 || puntos == 300) {
                vel = vel - 1;
            }
        } else if (tubo2 == 90) {
            puntos = puntos + 1;
            Jugar.Puntuacion.setText(puntos + "");
            if (puntos == 30 || puntos == 50 || puntos == 130 || puntos == 160 || puntos == 200 || puntos == 300) {
                vel = vel - 1;
            }
        }
    }

    @Override
    public void run() {
        int posicion1 = generarPosicionAleatoria();
        int posicion2 = generarPosicionAleatoria();
        int x1 = Jugar.jTubo_arriba1.getLocation().x;
        int x2 = Jugar.jTubo_arriba2.getLocation().x;
        while (true) {
            try {
                Thread.sleep(getVelocidad());
                x1--;
                x2--;
                Jugar.jTubo_arriba1.setLocation(x1, posicion1);
                Jugar.jTubo_abajo1.setLocation(x1, (posicion1 + 425));
                Jugar.jTubo_arriba2.setLocation(x2, posicion2);
                Jugar.jTubo_abajo2.setLocation(x2, (posicion2 + 425));
                if (x1 <= -51) {
                    posicion1 = generarPosicionAleatoria();
                    x1 = 425;
                }
                if (x2 <= -51) {
                    posicion2 = generarPosicionAleatoria();
                    x2 = 425;
                }
                sumarPuntos();
            } catch (InterruptedException ex) {
                System.out.println("error #3" + ex);//los tubos
            }
        }
    }

    private void ocultarTubos() {
        Jugar.jTubo_arriba1.setLocation(460, 500);
        Jugar.jTubo_abajo1.setLocation(460, 1000);
        Jugar.jTubo_arriba2.setLocation(700, 500);
        Jugar.jTubo_abajo2.setLocation(700, 1000);
    }

    public int getVelocidad() {
        return vel;
    }

    private int generarPosicionAleatoria() {
        int numero = (int) (Math.random() * (0 - (-200)) + (-200));
        return numero;
    }

}
