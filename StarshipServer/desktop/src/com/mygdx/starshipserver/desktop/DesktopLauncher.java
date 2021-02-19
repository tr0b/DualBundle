package com.mygdx.starshipserver.desktop;

import Objetos.Server;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.starshipserver.StarshipServer;

public class DesktopLauncher {

    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        try {
            Server server = new Server();
            
        } catch (Exception e) {
            System.out.println("Ocurrio un error.");
            System.exit(1);
        }

    }
}
