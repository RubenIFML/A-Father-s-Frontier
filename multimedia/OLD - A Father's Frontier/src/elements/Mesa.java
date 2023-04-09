package elements;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Mesa extends Actor {
    private Texture mesa;
    
    public Mesa() {
        setBounds(0, 0, 240, 75);
        mesa = new Texture("elements/mesa.png");
    }

    @Override
    public void act(float delta) {
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(mesa, getX(), getY(), getWidth(), getHeight());
    }
    
}