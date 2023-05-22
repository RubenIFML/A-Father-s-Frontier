package fs_elements;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

import game.Parametros;
import managers.AudioManager;

public class FS2_1 extends Actor {
    private Texture persona5;
    private float elapsedTime = 0;
	public static Texto texto;
    private Stage mainStage;
    private boolean fadingOut = false;
    private float opacity = 1f;

    public FS2_1(Stage mainStage) {
    	this.mainStage=mainStage;
    	setBounds(75, 60, 95, 110);
        persona5 = new Texture("01-FS/Personajes/FS.2_1.png");
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        
        if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER) && Parametros.controlesActivos==true && Parametros.analizar==true) {
        	
        	//Texto
        	texto = new Texto("Darío: Le doy las gra-\n"
        					+ "cias en nombre de Dios.", 7, 154, "talk1");
        	mainStage.addActor(texto);
        	
        	//Sonido
            AudioManager.playSound("01-FS/Audio/sounds/incorrecto.wav");
        	
        	//Estadísticas
        	Parametros.dinero-=Parametros.gananciasFS;
        	
        	//Variables
        	Parametros.analizar=false;
        	Parametros.analizado1=true;
        }
        
        else if (Gdx.input.isKeyJustPressed(Input.Keys.DEL) && Parametros.controlesActivos==true && Parametros.analizar==true) {
        	
        	//Texto
        	texto = new Texto("Darío: ¿¡Cómo que no se\n"
        					+ "permiten pistolas!?", 7, 154, "talk1");
        	mainStage.addActor(texto);
        	
        	//Sonido
            AudioManager.playSound("01-FS/Audio/sounds/correcto.wav");
            
            //Estadísticas
        	Parametros.dinero+=Parametros.gananciasFS;
            
            //Variables
        	Parametros.analizado1=true;
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
        batch.draw(persona5, getX(), getY(), getWidth(), getHeight());
        batch.setColor(1, 1, 1, 1);
    }

    public void hide() {
    	this.persona5 = new Texture("01-FS/Personajes/transparente.png");
    }
    
    public void show() {
        persona5 = new Texture("01-FS/Personajes/FS.2_1.png");
    }
}