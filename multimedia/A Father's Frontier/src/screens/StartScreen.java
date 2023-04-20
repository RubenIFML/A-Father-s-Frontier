package screens;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Align;

import game.Demo;
import game.Parametros;
import managers.ResourceManager;

public class StartScreen extends BScreen {
private OrthographicCamera camera;
private Batch batch;
private Texture periodico;
private Actor periodicoActor;
private Texture blackBackground;
private Actor blackBackgroundActor;
private boolean desactivable = false;
private float fadeTimer = 0f;

    public StartScreen(Demo game) {
        super(game);

        camera = new OrthographicCamera();
        camera.setToOrtho(false, Parametros.getAltoPantalla(), Parametros.getAltoPantalla());

        batch = new SpriteBatch();
	    
        if (Parametros.frontera==false) {
        	ResourceManager.musicaTitulo.play();
	        switch (Parametros.dia) {
            case 1:
                periodico = new Texture("Menu/periodico.0_0.png");
                break;
            case 2:
                periodico = new Texture("Menu/periodico.0_0.png");
                break;
            case 3:
                periodico = new Texture("Menu/periodico.0_0.png");
                break;
            default:
                periodico = new Texture("Menu/periodico.0_0.png");
                ResourceManager.musicaTitulo.stop();
                game.setScreen(new OverWorldScreen(game));
		    }
        }
        
        else if (Parametros.frontera==true) {
	        switch (Parametros.dia) {
            case 1:
                periodico = new Texture("Menu/periodico.1_0.png");
                break;
            case 2:
                periodico = new Texture("Menu/periodico.2_0.png");
                break;
            case 3:
                periodico = new Texture("Menu/periodico.3_0.png");
                break;
            default:
                periodico = new Texture("Menu/periodico.3_0.png");
                ResourceManager.musicaTitulo.stop();
                game.setScreen(new FrontierScreen(game));
		    }
        }
        
        blackBackground = new Texture("Menu/blackBackground.png");
        blackBackgroundActor = new Image(blackBackground);
        this.uiStage.addActor(blackBackgroundActor);
        
        periodicoActor = new Image(periodico);
        this.uiStage.addActor(periodicoActor);
        periodicoActor.getColor().a = 0f; // set initial opacity to 0
        periodicoActor.setPosition(Parametros.getAnchoPantalla() / 2f, Parametros.getAltoPantalla() / 2f, Align.center);
    }

    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if (button == Input.Buttons.LEFT && desactivable == true && Parametros.frontera==false) {
            periodicoActor.remove();
            ResourceManager.musicaTitulo.stop();
            Parametros.zoom=0.65f;
            game.setScreen(new OverWorldScreen(game));
        }
        else if (button == Input.Buttons.LEFT && desactivable == true && Parametros.frontera==true) {
            periodicoActor.remove();
            ResourceManager.musicaTitulo.stop();
            Parametros.zoom=0.30f;
            game.setScreen(new FrontierScreen(game));
        }

        return false;
    }

    @Override
    public void render(float delta) {

        super.render(delta);
        uiStage.act();
        
        fadeTimer += delta;
        if (fadeTimer < 1f) {
            periodicoActor.getColor().a = fadeTimer;
            desactivable = true;
        }

        batch.begin();
        batch.draw(blackBackground, 0, 0, Parametros.getAnchoPantalla(), Parametros.getAltoPantalla());
        batch.end();

        uiStage.draw();
    }
}
