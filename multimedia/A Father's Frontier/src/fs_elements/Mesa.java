package fs_elements;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

import managers.ResourceManager;

/**
 * Crea la mesa de la Frontera.
 * @author Rubén Moya
 */
public class Mesa extends Actor {
    private Texture mesa;
    
    public Mesa() {
        setBounds(0, 0, 240, 75);
        mesa = ResourceManager.getTexture("01-FS/Objetos/mesa.png");
    }

    @Override
    public void act(float delta) {
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(mesa, getX(), getY(), getWidth(), getHeight());
    }
    
}