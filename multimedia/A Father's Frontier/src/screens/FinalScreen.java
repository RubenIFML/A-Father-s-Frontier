package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import game.Demo;
import game.Parametros;
import managers.AudioManager;
import managers.ResourceManager;
import ow_elements.Texto;

public class FinalScreen extends BScreen {
private OrthographicCamera camera;
private Batch batch;
private Texture blackBackground;
private Actor blackBackgroundActor;
private Music ruido;
private int contador = 0;
private Texto texto;
private Texture protagonistaMT;
private Actor protagonistaM;

    public FinalScreen(Demo game) {
        super(game);
        
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Parametros.getAltoPantalla(), Parametros.getAltoPantalla());
        
        ResourceManager.musicaTitulo.stop();
        
		ruido = Gdx.audio.newMusic(Gdx.files.internal("01-FS/Audio/music/final.wav"));
	    ruido.setLooping(true);
	    ruido.setVolume(0.2f);

        blackBackground = new Texture("Menu/blackBackground.png");
        blackBackgroundActor = new Image(blackBackground);
        this.uiStage.addActor(blackBackgroundActor);
        
        texto = new Texto("Volker: Se acab�.\n", "talk1");
        texto.completo=true;
        this.uiStage.addActor(texto);
        
	    protagonistaMT = new Texture("02-OW/personajes/personaje.ahorcado.png");
	    protagonistaM = new Image(protagonistaMT);
	    protagonistaM.setBounds(342, 220, 80, 500);
	    
	    ruido.play();
    }

    public boolean touchDown(int screenX, int screenY, int pointer, int button) {

		if(texto.completo==true) {
	    			if (button == Input.Buttons.LEFT && contador==0 && texto.completo==true) {
			        	AudioManager.playSound("01-FS/Audio/sounds/menuBoton.wav");
	     	        	texto.remove();
	     	            texto = new Texto("Mi hijo va a morir, y yo solo puedo quedarme\ncon los brazos cruzados...", "talk1");
	     	            this.uiStage.addActor(texto);
	     	            contador ++;
	     	        }
	    			else if (button == Input.Buttons.LEFT && contador==1 && texto.completo==true) {
			        	AudioManager.playSound("01-FS/Audio/sounds/menuBoton.wav");
	     	        	texto.remove();
	     	            texto = new Texto("No he conseguido el dinero...\nLo he perdido todo.", "talk1");
	     	            this.uiStage.addActor(texto);
	     	            contador ++;
	     	        }
	    			else if (button == Input.Buttons.LEFT && contador==2 && texto.completo==true) {
			        	AudioManager.playSound("01-FS/Audio/sounds/menuBoton.wav");
	     	        	texto.remove();
	     	            texto = new Texto("El dolor se ha hecho tan insoportable que\nno merece la pena seguir luchando...", "talk1");
	     	            this.uiStage.addActor(texto);
	     	            contador ++;
	     	        }
	    			else if (button == Input.Buttons.LEFT && contador==3 && texto.completo==true) {
			        	AudioManager.playSound("01-FS/Audio/sounds/menuBoton.wav");
	     	        	texto.remove();
	     	            texto = new Texto("Evans...\nNos vemos al otro lado...", "talk1");
	     	            this.uiStage.addActor(texto);
	     	            contador ++;
	     	        }
	    			else if (button == Input.Buttons.LEFT && contador==4 && texto.completo==true) {
			        	AudioManager.playSound("02-OW/Audio/sounds/muerte.wav");
	    	        	texto.remove();
	    	        	uiStage.addActor(protagonistaM);
	    	        	ruido.stop();
	    	            contador ++;
	     	        }
	    	        else if (button == Input.Buttons.LEFT && contador==5 && texto.completo==true) {
	    	            Parametros.pierdes=false;
	    	            game.setScreen(new TitleScreen(game));
	    	        }
		} else {
    		texto.completo=true;
            AudioManager.playSound("01-FS/Audio/sounds/menuBoton.wav");
    	}
    	
        return false;
    }

    @Override
    public void render(float delta) {

        super.render(delta);
        uiStage.act();

        batch.begin();
        batch.draw(blackBackground, 0, 0, Parametros.getAnchoPantalla(), Parametros.getAltoPantalla());
        batch.end();

        uiStage.draw();
    }
}
