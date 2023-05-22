package fs_elements;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

import game.Parametros;
import managers.AudioManager;

public class FS3_2 extends Actor {
    private Texture persona6;
    private float elapsedTime = 0;
	public static Texto texto;
    private Stage mainStage;
    private boolean fadingOut = false;
    private float opacity = 1f;

    public FS3_2(Stage mainStage) {
    	this.mainStage=mainStage;
    	setBounds(74, 57, 90, 113);
        persona6 = new Texture("01-FS/Personajes/FS.3_2.png");
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        
        if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER) && Parametros.controlesActivos==true && Parametros.analizar==true) {
        	
        	//Texto
        	texto = new Texto("Razvan: Parecer que yo\n"
        					+ "ser bienvenido aquí...", 7, 154, "talk1");
        	mainStage.addActor(texto);
        	
        	//Sonido
            AudioManager.playSound("01-FS/Audio/sounds/incorrecto.wav");
        	
        	//Estadísticas
        	Parametros.dinero-=4;
        	
        	//Variables
        	Parametros.analizar=false;
        	Parametros.analizado2=true;
        }
        
        else if (Gdx.input.isKeyJustPressed(Input.Keys.DEL) && Parametros.controlesActivos==true && Parametros.analizar==true) {
        	
        	//Texto
        	texto = new Texto("Razvan: Una nación tan\n"
        					+ "racista no merecerme...", 7, 154, "talk1");
        	mainStage.addActor(texto);
        	
        	//Sonido
            AudioManager.playSound("01-FS/Audio/sounds/correcto.wav");
            
            //Estadísticas
        	Parametros.dinero+=3;
            
            //Variables
        	Parametros.analizado2=true;
        	Parametros.analizar=false;
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
        batch.draw(persona6, getX(), getY(), getWidth(), getHeight());
        batch.setColor(1, 1, 1, 1);
    }

    public void hide() {
    	this.persona6 = new Texture("01-FS/Personajes/transparente.png");
    }
    
    public void show() {
        persona6 = new Texture("01-FS/Personajes/FS.3_2.png");
    }
}