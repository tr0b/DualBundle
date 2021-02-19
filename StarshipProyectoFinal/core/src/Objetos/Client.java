/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Yopuesquienmás
 */
public class Client extends Thread{//Cliente del programa. Se va a encargar de enviar a servidor las puntuaciones
    private Socket socket;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;
    private Puntuacion puntuacion;
    public Client(Puntuacion puntuacion){
        try {
            this.puntuacion = puntuacion;
            socket = new Socket(InetAddress.getLocalHost(), 4444);
            startStream();
        } catch (UnknownHostException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void startStream()
    {
        try {
            oos = new ObjectOutputStream(socket.getOutputStream());
            ois = new ObjectInputStream(socket.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void sendData()
    {
        try {
            oos.writeInt(puntuacion.getPuntuacion());
            oos.flush();
            oos.writeUTF(puntuacion.getNombre());
            oos.flush();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void readData()
    {
        try {
            String info = ois.readUTF();
            System.out.println(info);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void run()
    {
        while(true)
        {
            sendData();
        }
    }
}
