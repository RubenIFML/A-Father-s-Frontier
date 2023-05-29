package game;

import com.badlogic.gdx.Files.FileType;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

/**
 * La clase que crea la ventana del juego.
 */
public class Launcher {
    public static void main(String[] args) {
        Game myGame = new Demo();
        
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = "A Father's Frontier";
        config.width = Parametros.getAnchoPantalla();
        config.height = Parametros.getAltoPantalla();
        config.resizable = false;
        config.addIcon("icon.png", FileType.Internal);
        
        @SuppressWarnings("unused")
        LwjglApplication launcher = new LwjglApplication(myGame, config);
    }
}
