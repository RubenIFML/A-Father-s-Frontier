package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

import game.Demo;
import game.Parametros;
import managers.AudioManager;
import managers.ResourceManager;
public class EndScreen extends BScreen{
private OrthographicCamera camera;
private Batch batch;
private Texture background;
private Label conclusion;
private Label mensajeDemo;
private boolean finalHabilitado = false;
private Music musicaFinal;

	public EndScreen(Demo game) {
	    super(game);
	    
		musicaFinal = Gdx.audio.newMusic(Gdx.files.internal("audio/music/final.mp3"));
		musicaFinal.play();
        musicaFinal.setVolume(0.3f);
		musicaFinal.setLooping(true);
	    
		camera = new OrthographicCamera();
	    camera.setToOrtho(false, Parametros.getAltoPantalla(), Parametros.getAltoPantalla());
	    
	    batch = new SpriteBatch();
	    background = new Texture("maps/images/blackBackground.png");
	    
	    if(Parametros.ganas==true) {
			conclusion=new Label("¡Ha rescatado a su hijo!\r\n"
					+ "Con el salario recibido por\r\n"
					+ "su gran trabajo y esfuerzo, ha\r\n"
					+ "conseguido recaudar todo el\r\n"
					+ "dinero necesario."
					, uiStyle);
			conclusion.setPosition(95,170);
		    conclusion.setAlignment(1, 2);
		    
			this.uiStage.addActor(conclusion);
	    	
	    }
	    else {
			conclusion=new Label("Su hijo ha sido asesinado.\r\n"
					+ "A pesar de todo, no logró\r\n"
					+ "recaudar el dinero suficiente,\r\n"
					+ "y los secuestradores se han\r\n"
					+ "deshecho de él."
					, uiStyle);
			conclusion.setPosition(120,170);
		    conclusion.setAlignment(1, 2);
		    
			this.uiStage.addActor(conclusion);
	    	
	    }
	    
		mensajeDemo=new Label("¡Gracias por jugar a la demo!\r\n"
				+ "Espero que a pesar de su\r\n"
				+ "brevedad, hayas podido\r\n"
				+ "pasar un buen rato.\r\n\n"
				+ "Rubén Moya"
				, uiStyle);
		mensajeDemo.setPosition(125,140);
	    mensajeDemo.setAlignment(1, 2);
	    
		finalHabilitado=true;
	}
	
	@Override
	public void render(float delta) {
		
        if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER) && finalHabilitado) {
        	AudioManager.playSound("audio/sounds/menuBoton.mp3");
			conclusion.remove();
    		this.uiStage.addActor(mensajeDemo);
    		finalHabilitado=false;
        }
        else if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER) && (finalHabilitado == false)) {
        	AudioManager.playSound("audio/sounds/menuBoton.mp3");
			mensajeDemo.remove();
			game.setScreen(new TitleScreen(game));
			musicaFinal.stop();
		    ResourceManager.musicaTitulo.play();
        }
		super.render(delta);
	    
	     uiStage.act();
	     batch.begin();
	     batch.draw(background, 0, 0, Parametros.getAnchoPantalla(), Parametros.getAltoPantalla());
	     batch.end();
	     uiStage.draw();

	}
	
	
	
}
