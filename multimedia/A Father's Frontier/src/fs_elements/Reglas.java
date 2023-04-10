package fs_elements;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

import game.Parametros;
import managers.AudioManager;

public class Reglas extends Actor {
    private boolean isDragged = false;
    private float lastX, lastY;
    private Texture reglas;
    private float deltaX;
    private float deltaY;
    private boolean primeraVez = true;

    private float x;
    private float y;
    private float width;
    private float height;
    private String textura1;
    private String textura2;
    private String textura3;
    private int posicion=0;
    
    public Reglas(float x, float y, float width, float height, String textura1, String textura2, String textura3) {
    	this.x = x;
    	this.y = y;
    	this.width = width;
    	this.height = height;
    	this.textura1 = textura1;
    	this.textura2 = textura2;
    	this.textura3 = textura3;
    	
        setBounds(this.x, this.y, this.width, this.height);
        reglas = new Texture("01-FS/Objetos/" + this.textura1);
    }

    @Override
    public void act(float delta) {
        Vector2 stageCoords = getStage().screenToStageCoordinates(new Vector2(Gdx.input.getX(), Gdx.input.getY()));

        if (Gdx.input.isButtonPressed(Input.Buttons.LEFT) && Parametros.controlesActivos==true) {
            if (getRectangle().contains(stageCoords.x, stageCoords.y)) { // Usar las coordenadas de espacio de escena
                isDragged = true;
                if (primeraVez == true) {
                	
                	if(this.textura2 == null && this.textura3 == null) {
                	}
                	
                	else if(this.textura3 == null) {
                		if(posicion == 0) {
                			reglas = new Texture("01-FS/Objetos/" + this.textura2);
                			posicion++;
                		}
                		else if (posicion == 1){
                			reglas = new Texture("01-FS/Objetos/" + this.textura1);
                			posicion--;
                		}
                	}
                	
                	else {
                		if(posicion == 0) {
                			reglas = new Texture("01-FS/Objetos/" + this.textura2);
                			posicion++;
                		}
                		else if (posicion == 1){
                			reglas = new Texture("01-FS/Objetos/" + this.textura3);
                			posicion++;
                		}
                		else if (posicion == 2){
                			reglas = new Texture("01-FS/Objetos/" + this.textura1);
                			posicion-=2;
                		}
                	}
                	
                    AudioManager.playSound("01-FS/Audio/sounds/papeles.mp3");
                    primeraVez = false;
                }
            }
        } else {
            isDragged = false;
            primeraVez = true;
        }
        if (isDragged) {
            deltaX = stageCoords.x - lastX;
            deltaY = stageCoords.y - lastY;
            setPosition(getX() + deltaX, getY() + deltaY);
        }
        lastX = stageCoords.x;
        lastY = stageCoords.y;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(reglas, getX(), getY(), getWidth(), getHeight());
    }

    public Rectangle getRectangle() {
        return new Rectangle(getX(), getY(), getWidth(), getHeight());
    }

}
