package com.mygdx.game.desktop;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.starship.Starship;
import com.mygdx.starship.pantallas.MenuPrincipal;

public class DesktopLauncher {

    public final static int WIDTH = MenuPrincipal.WIDTH;
    public final static int HEIGHT = MenuPrincipal.HEIGHT;

    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.resizable = false;
        config.vSyncEnabled = true;
                config.width = WIDTH;
                config.height = HEIGHT;
        config.fullscreen = false;
        config.useGL30 = true;
        config.title = Starship.nombrejuego + "Version: " + Starship.version;
        config.addIcon("assets/nave.gif", Files.FileType.Internal);
        new LwjglApplication(new Starship(), config);

    }
}
