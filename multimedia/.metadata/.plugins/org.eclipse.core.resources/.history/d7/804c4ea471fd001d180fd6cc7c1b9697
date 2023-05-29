package fs_elements;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

import game.Parametros;
import managers.AudioManager;
import managers.ResourceManager;

public class FS1_4 extends Actor {
    private Texture persona4;
    private float elapsedTime = 0;
	public static Texto texto;
    private Stage mainStage;
	private boolean fadingOut = false;
	private float opacity = 1f;
	
    public FS1_4(Stage mainStage) {
    	this.mainStage=mainStage;
    	setBounds(88, 73, 60, 100);
        persona4 = ResourceManager.getTexture("01-FS/Personajes/FS.1_4.png");
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        
        if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER) && Parametros.controlesActivos==true && Parametros.analizar==true) {
        	
        	//Texto
        	texto = new Texto("Desiree: Un servicio\n"
        					+ "excepcional, gracias...", 7, 154, "talk2");
        	mainStage.addActor(texto);
        	
        	//Sonido
            AudioManager.playSound("01-FS/Audio/sounds/incorrecto.wav");
            
            //Estadísticas
            Parametros.dinero-=Parametros.gananciasFS;
            
            //Variables
        	Parametros.analizar=false;
        	Parametros.analizado4=true;
        }
        
        else if (Gdx.input.isKeyJustPressed(Input.Keys.DEL) && Parametros.controlesActivos==true && Parametros.analizar==true) {
        	
        	//Texto
        	texto = new Texto("Desiree: Está bien...\n"
        					+ "acepto mi destino, mas", 7, 154, "talk2");
        	mainStage.addActor(texto);
    	
        	//Sonido
            AudioManager.playSound("01-FS/Audio/sounds/correcto.wav");
            
            //Estadísticas
            Parametros.dinero+=Parametros.gananciasFS;
            //Variables
        	Parametros.analizar=false;
        	Parametros.analizado4=true;
        	Parametros.correcto=true;
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
        batch.draw(persona4, getX(), getY(), getWidth(), getHeight());
        batch.setColor(1, 1, 1, 1);
    }

    public void hide() {
    	this.persona4 = ResourceManager.getTexture("01-FS/Personajes/transparente.png");
    }
    
    public void show() {
        persona4 = ResourceManager.getTexture("01-FS/Personajes/FS.1_4.png");
    }
}