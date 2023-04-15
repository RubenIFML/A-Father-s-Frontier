package elements;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

import game.Parametros;
import managers.AudioManager;

public class Pasaporte3 extends Actor {
    private boolean isDragged = false;
    private float lastX, lastY;
    private Texture reglas;
    private float deltaX;
    private float deltaY;
    private boolean suena = true;

    public Pasaporte3() {
        setBounds(17, 20, 50, 73);
        reglas = new Texture("elements/pasaporte3.png");
    }

    @Override
    public void act(float delta) {
        Vector2 stageCoords = getStage().screenToStageCoordinates(new Vector2(Gdx.input.getX(), Gdx.input.getY()));

        if (Gdx.input.isButtonPressed(Input.Buttons.LEFT) && Parametros.controlesActivos==true) {
            if (getRectangle().contains(stageCoords.x, stageCoords.y)) { 
                isDragged = true;
                if (suena == true) {
                    AudioManager.playSound("audio/sounds/papeles.wav");
                    suena = false;
                }
            }
        } else {
            isDragged = false;
            suena = true;
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