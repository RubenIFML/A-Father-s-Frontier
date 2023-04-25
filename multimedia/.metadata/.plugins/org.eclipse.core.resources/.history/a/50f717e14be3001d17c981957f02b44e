package ow_elements;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

import managers.ResourceManager;

public class RainDrop extends Actor {
    
    private float x;
    private float y;
    private float speed;
    
    public RainDrop(float x, float y, float speed) {
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    @Override
    public void act(float delta) {
        y -= speed * delta;
        x -= speed * delta;
        if (y < 0) {
            remove();
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(ResourceManager.getTexture("Menu/raindrop.png"), x, y);
    }
}