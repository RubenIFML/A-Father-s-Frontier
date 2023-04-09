package elements;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Maletin extends Actor {
    private Texture maletin;
    
    public Maletin() {
        setBounds(75, 10, 85, 89);
        maletin = new Texture("elements/maletin.png");
    }

    @Override
    public void act(float delta) {
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(maletin, getX(), getY(), getWidth(), getHeight());
    }
    
    public void hide() {
    	this.maletin = new Texture("enemies/transparente.png");
    }
    
    public void show() {
    	this.maletin = new Texture("elements/maletin.png");
    }
}