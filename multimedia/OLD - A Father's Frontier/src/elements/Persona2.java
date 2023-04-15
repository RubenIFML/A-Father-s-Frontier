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

public class Persona2 extends Actor {
    private Texture persona2;
    private float elapsedTime = 0;
	public static Texto texto;
    private Stage mainStage;
	private boolean fadingOut = false;
	private float opacity = 1f;
	
    public Persona2(Stage mainStage) {
    	this.mainStage=mainStage;
    	setBounds(57, 73, 120, 100); // Tama�o inicial del actor
        persona2 = new Texture("enemies/persona2.png");
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        
        if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER) && Parametros.controlesActivos==true && Parametros.analizar==true) {
        	texto = new Texto("(Mierda, pensé que lo\n"
        					+ "tenía controlado)", 7, 154);
        	mainStage.addActor(texto);
        	Parametros.analizar=false;
        	Parametros.analizadoP2=true;
            AudioManager.playSound("audio/sounds/incorrecto.wav");
            GameScreen.reloj.modTiempo(-80);

        }
        else if (Gdx.input.isKeyJustPressed(Input.Keys.DEL) && Parametros.controlesActivos==true && Parametros.analizar==true) {
        	texto = new Texto("(Sus sucios trucos no\n"
        					+ "son efectivos)", 7, 154);
        	mainStage.addActor(texto);
        	Parametros.analizar=false;
        	Parametros.analizadoP2=true;
            AudioManager.playSound("audio/sounds/correcto.wav");
            GameScreen.reloj.modTiempo(20);
        }
        
        if (elapsedTime < 1) {
            setX(getX() + 1 * delta);
        }
        else if (elapsedTime < 2) {
            setX(getX() - 1 * delta);
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
        batch.draw(persona2, getX(), getY(), getWidth(), getHeight());
        batch.setColor(1, 1, 1, 1);
    }

    public void hide() {
    	this.persona2 = new Texture("enemies/transparente.png");
    }
    
    public void show() {
        persona2 = new Texture("enemies/persona2.png");
    }
}