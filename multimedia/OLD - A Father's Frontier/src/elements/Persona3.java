package elements;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

import game.Parametros;
import managers.AudioManager;
import screens.GameScreen;

public class Persona3 extends Actor {
    private Texture persona3;
    private float elapsedTime = 0;
	public static Texto texto;
    private Stage mainStage;
	private boolean fadingOut = false;
	private float opacity = 1f;
	
    public Persona3(Stage mainStage) {
    	this.mainStage=mainStage;
    	setBounds(79, 73, 80, 100);
        persona3 = new Texture("enemies/persona3.png");
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        
        if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER) && Parametros.controlesActivos==true && Parametros.analizar==true) {
        	texto = new Texto("(A pesar de las pintas\n"
        					+ "resultó ser legal)", 7, 154);
        	mainStage.addActor(texto);
        	Parametros.analizar=false;
        	Parametros.analizadoP3=true;
            AudioManager.playSound("audio/sounds/correcto.wav");
            GameScreen.reloj.modTiempo(20);

        }
        else if (Gdx.input.isKeyJustPressed(Input.Keys.DEL) && Parametros.controlesActivos==true && Parametros.analizar==true) {
        	texto = new Texto("(No debí juzgarlo\n"
							+ "por su apariencia...)", 7, 154);
        	mainStage.addActor(texto);
        	Parametros.analizar=false;
        	Parametros.analizadoP3=true;
            AudioManager.playSound("audio/sounds/incorrecto.wav");
            GameScreen.reloj.modTiempo(-80);
        }
        
        if (elapsedTime < 1) {
            setY(getY() + 1 * delta);
        }
        else if (elapsedTime < 2) {
            setY(getY() - 1 * delta);
        }

        if (elapsedTime > 3) {
            elapsedTime = 0;
        } else {
            elapsedTime += delta;
        }
        if (fadingOut) {
            opacity -= delta * 5;
            if (opacity < 0) {
                opacity = 0;
                fadingOut = false;
                remove();
            }
        }
    }

    public void fadeOut() {
        fadingOut = true;
    }
    
    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.setColor(1, 1, 1, opacity);
        batch.draw(persona3, getX(), getY(), getWidth(), getHeight());
        batch.setColor(1, 1, 1, 1);
    }

    public void hide() {
    	this.persona3 = new Texture("enemies/transparente.png");
    }
    
    public void show() {
        persona3 = new Texture("enemies/persona3.png");
    }
}