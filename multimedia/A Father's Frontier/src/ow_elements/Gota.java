package ow_elements;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import managers.ResourceManager;

/**
 * Carga y establece las gotas de agua de la lluvia de la Ciudad.
 * @author Rubén Moya
 */
public class Gota extends Actor {
    
    private float x;
    private float y;
    private float speed;
    private Protagonista prota;
    
    public Gota(float x, float y, float speed, Protagonista prota) {
    	this.x = x;
        this.y = y;
        this.speed = speed;
        this.prota=prota;
    }

    @Override
    public void act(float delta) {
        y -= speed * delta;
        x -= speed * delta;
        if (y < prota.getY()-260 || x < prota.getX()-340) {
            remove();
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(ResourceManager.getTexture("Menu/raindrop.png"), x, y);
    }
}