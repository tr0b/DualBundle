/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ulacit
 */
public class Server {
    /*Clase servidor*/
    private Socket socket;
    private ServerSocket serverSocket;
    private ExecutorService service;
    public static final int puerto = 4444;

    public Server() {
        try {
            service = Executors.newCachedThreadPool();
            serverSocket = new ServerSocket(puerto);
            startConnection();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void startConnection() {
        try {
            while (true) {
                socket = serverSocket.accept();
                service.submit(new ServerClient(socket));
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
