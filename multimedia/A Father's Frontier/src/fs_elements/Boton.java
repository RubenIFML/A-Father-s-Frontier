package fs_elements;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

import game.Parametros;
import managers.AudioManager;

public class Boton extends Actor {
    private Texture boton;
    private float x;
    private String textura1;
    private String textura2;
    
    public Boton(float x, String textura1, String textura2) {
    	this.x = x;
    	this.textura1 = textura1;
    	this.textura2 = textura2;
        setBounds(this.x, 10, 32, 35);
        boton = new Texture("01-FS/Objetos/" + this.textura1);
    }

    @Override
    public void act(float delta) {
    	if(x == 165) {
	        if (Gdx.input.isKeyJustPressed(Input.Keys.DEL) && Parametros.controlesActivos==true) {
	            boton = new Texture("01-FS/Objetos/" + this.textura2);
	            AudioManager.playSound("01-FS/Audio/sounds/boton.mp3");
	        }
	        else {
	        	boton = new Texture("01-FS/Objetos/" + this.textura1);
	        }
    	}
    	else if(x == 200) {
	        if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER) && Parametros.controlesActivos==true) {
	            boton = new Texture("01-FS/Objetos/" + this.textura2);
	            AudioManager.playSound("01-FS/Audio/sounds/boton.mp3");
	        }
	        else {
	        	boton = new Texture("01-FS/Objetos/" + this.textura1);
	        }
    	}
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(boton, getX(), getY(), getWidth(), getHeight());
    }
    
    public Rectangle getBoundingRectangle() {
        return new Rectangle(getX(), getY(), getWidth(), getHeight());
    }
}
