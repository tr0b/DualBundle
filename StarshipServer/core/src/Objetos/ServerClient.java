/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yopuesquienmás
 */
public class ServerClient implements Runnable {

    /*Clase servidor cliente*/
    private final Socket socket;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private boolean detenido;
    public static final int puerto = 4444;
    ArrayList<Puntuacion> puntuaciones;

    public ServerClient(final Socket socket) {
        this.socket = socket;
        puntuaciones = new ArrayList<>();
        startStream();
    }

    @Override
    public void run() {
        try {
            while (!detenido) {
                readData();
                sendData();
            }
        } catch (Exception e) {
            this.detener();

        }

    }

    private void startStream() {
        try {
            ois = new ObjectInputStream(socket.getInputStream());
            oos = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void sendData() {
        try {
            oos.writeUTF("Puntuacion recibida exitosamente....");
            oos.flush();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void readData() {
        try {
            int puntaje = ois.readInt();
            String nombre = ois.readUTF().trim();
            Puntuacion puntuacion_muestra = new Puntuacion(nombre, puntaje);
            System.out.println(puntuacion_muestra.printPuntuacion());
            detener();

        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void detener() {
        this.detenido = true;
    }
}
