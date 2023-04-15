package elements;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

import game.Parametros;
import managers.AudioManager;

public class BotonVerde extends Actor {
    private Texture botonVerde;
    
    public BotonVerde() {
        setBounds(200, 10, 32, 35); // Tama�o inicial del actor
        botonVerde = new Texture("elements/botonVerde.png");
    }

    @Override
    public void act(float delta) {
        if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER) && Parametros.controlesActivos==true) {
            botonVerde = new Texture("elements/botonVerde_Pressed.png");
            AudioManager.playSound("audio/sounds/boton.wav");
        }
        
        else {
        	botonVerde = new Texture("elements/botonVerde.png");
        }
        
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(botonVerde, getX(), getY(), getWidth(), getHeight());
    }
    
    public Rectangle getBoundingRectangle() {
        return new Rectangle(getX()*4, getY()*4, getWidth()*4, getHeight()*4);
    }
}

