package elements;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

import game.Parametros;
import managers.AudioManager;

public class BotonRojo extends Actor {
    private Texture botonRojo;
    
    public BotonRojo() {
        setBounds(165, 10, 32, 35); // Tama�o inicial del actor
        botonRojo = new Texture("elements/botonRojo.png");
    }

    @Override
    public void act(float delta) {
        if (Gdx.input.isKeyJustPressed(Input.Keys.DEL) && Parametros.controlesActivos==true) {
            botonRojo = new Texture("elements/botonRojo_Pressed.png");
            AudioManager.playSound("audio/sounds/boton.mp3");
        }
        else {
        	botonRojo = new Texture("elements/botonRojo.png");
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(botonRojo, getX(), getY(), getWidth(), getHeight());
    }
    
    public Rectangle getBoundingRectangle() {
        return new Rectangle(getX(), getY(), getWidth(), getHeight());
    }
}

