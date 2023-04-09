package screens;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputEvent.Type;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import game.Demo;
import game.Parametros;
import managers.AudioManager;
import managers.ResourceManager;

public class OptionsScreen extends BScreen{
private Table tabla;
private Table tabla2;
private OrthographicCamera camera;
private Batch batch;
private Texture background;
private int estadoActual = 0;


	public OptionsScreen(Demo game) {
	    super(game);
		
	    camera = new OrthographicCamera();
	    camera.setToOrtho(false, Parametros.getAltoPantalla(), Parametros.getAltoPantalla());
	    
	    batch = new SpriteBatch();
	    background = new Texture("Menu/PapersBackgraundTsx.png");

		tabla = new Table();
		tabla.setFillParent(true);
		tabla2 = new Table();
		tabla2.setFillParent(true);

		tabla.setPosition(0,70);
		tabla.pad(60);

		tabla2.setPosition(0,-90);
		
		TextButton dificultad = new TextButton("Normal", ResourceManager.textButtonStyle);
		String[] estados = {"Normal", "Difícil", "Fácil"};
		
			estadoActual = 0;
		
		dificultad.addListener(new ClickListener() {
		    @Override
		    public void clicked(InputEvent event, float x, float y) {
		        AudioManager.playSound("01-FS/Audio/sounds/menuBoton.mp3");
		        
		        estadoActual = (estadoActual + 1) % estados.length;
		        
		        dificultad.setText(estados[estadoActual]);
		        
		        if (estadoActual == 0) {
		            Parametros.segundos = 100;
		        } else if (estadoActual == 1) {
		            Parametros.segundos = 40;
		        } else if (estadoActual == 2) {
		            Parametros.segundos = 130;
		        }
		    }
		});
		
		TextButton volver=new TextButton("Volver al título",ResourceManager.textButtonStyle);
		
		volver.addListener(
				(Event e)->{if(!(e instanceof InputEvent)|| !((InputEvent)e).getType().equals(Type.touchDown))
					return false;
				AudioManager.playSound("01-FS/Audio/sounds/menuBoton.mp3");
				this.dispose();

				game.setScreen(new TitleScreen(game));
				
				return false;
				});
		
		tabla.add(dificultad).width(300).height(130);
		tabla2.add(volver).space(10).width(700).height(120);
		
		this.uiStage.addActor(tabla);
		this.uiStage.addActor(tabla2);
	}

	@Override
	public void render(float delta) {
		
		super.render(delta);
	    uiStage.act();
	    batch.begin();
	    batch.draw(background, 0, 0, Parametros.getAnchoPantalla(), Parametros.getAltoPantalla());
	    batch.end();
	    uiStage.draw();
	}
}
