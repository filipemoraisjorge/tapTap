package org.academiadecodigo.bootcamp.filipejorge.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import org.academiadecodigo.bootcamp.filipejorge.TapTap;

public class DesktopLauncher {
    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = "TapTap";
        config.width = 800;
        config.height = 480;
        new LwjglApplication(new TapTap(), config);
    }
}
