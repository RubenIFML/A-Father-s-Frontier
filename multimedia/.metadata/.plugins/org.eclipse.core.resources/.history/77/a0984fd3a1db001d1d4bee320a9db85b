package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

import game.Demo;
import game.Parametros;
import managers.AudioManager;
import managers.ResourceManager;
public class StartScreen extends BScreen{
private OrthographicCamera camera;
private Batch batch;
private Texture background;
private Label presentacion;
private Label explicacion;
private Label controles;
private boolean presentacionHabilitada = false;
private boolean explicacionHabilitada = false;

	public StartScreen(Demo game) {
	    super(game);
		
	    camera = new OrthographicCamera();
	    camera.setToOrtho(false, Parametros.getAltoPantalla(), Parametros.getAltoPantalla());
	    
	    batch = new SpriteBatch();
	    background = new Texture("maps/images/blackBackground.png");
	    
		presentacion=new Label("Año 1940, Frontera de Reino Unido.\r\n\n"
				+ "Su hijo ha sido secuestrado.\r\n"
				+ "Es el nuevo guardia fronterizo,\r\n"
				+ "trabaje para pagar su recompensa.\r\n\n"
				+ "Pulse ENTER para continuar"
				, uiStyle);
		presentacion.setPosition(61,105);
	    presentacion.setAlignment(1, 2);
	    
		explicacion=new Label("Compruebe que los pasaportes de \r\n"
				+ "las personas no incumplan las reglas.\r\n"
				+ "Tiene 100 segundos, si deja\r\n"
				+ "pasar a quien no debe, se restarán\r\n"
				+ "80 segundos. Si cumple todas las\r\n"
				+ "normas, se sumarán 20"
				, uiStyle);
		explicacion.setPosition(53,140);
		explicacion.setAlignment(1, 2);
	    
		controles=new Label("Aceptar entrada: ENTER\r\n"
				+ "Denegar entrada: BORRAR\r\n"
				+ "Mover objetos: Click Izdo.\r\n\n"
				, uiStyle);
		controles.setPosition(160,120);
	    controles.setAlignment(1, 2);
	    
		this.uiStage.addActor(presentacion);
		presentacionHabilitada=true;
	}
	
	@Override
	public void render(float delta) {
		
        if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER) && presentacionHabilitada) {
        	AudioManager.playSound("audio/sounds/menuBoton.mp3");
			presentacion.remove();
    		this.uiStage.addActor(explicacion);
    		explicacionHabilitada=true;
    		presentacionHabilitada=false;
        }
        else if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER) && (explicacionHabilitada)) {
        	AudioManager.playSound("audio/sounds/menuBoton.mp3");
			explicacion.remove();
    		this.uiStage.addActor(controles);
    		explicacionHabilitada=false;    
        }
        else if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER) && (explicacionHabilitada == false && presentacionHabilitada == false)) {
        	AudioManager.playSound("audio/sounds/menuBoton.mp3");
			controles.remove();
			game.setScreen(new GameScreen(game));
		    ResourceManager.musicaTitulo.stop();	    
        }
		super.render(delta);
	    
	     uiStage.act();
	     batch.begin();
	     batch.draw(background, 0, 0, Parametros.getAnchoPantalla(), Parametros.getAltoPantalla());
	     batch.end();
	     uiStage.draw();

	}
	
	
	
}
