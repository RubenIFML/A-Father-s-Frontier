package ow_elements;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Niebla extends Actor {

  private Texture texture;
  private float x;
  private float y;
  private float elapsedTime; // variable para almacenar el tiempo transcurrido

  public Niebla(float width, float height) {
    texture = new Texture("Menu/niebla.png"); // Asegúrate de tener una textura con el efecto de niebla
    setWidth(width);
    setHeight(height);
  }

  @Override
  public void act(float delta) {
    elapsedTime += delta; // aumenta el tiempo transcurrido
    if (elapsedTime < 2f) { // durante los primeros 2 segundos
      x += delta * 10f; // mueve hacia arriba a la derecha
      y += delta * 5f;
    } else { // después de 2 segundos
      x -= delta * 10f; // mueve en dirección contraria
      y -= delta * 5f;
      if(elapsedTime > 4f) {
    	  elapsedTime=0;
      }
    }
  }

  @Override
  public void draw(Batch batch, float parentAlpha) {
    batch.setColor(1, 1, 1, 0.3f); // Ajusta la opacidad según tu preferencia
    batch.draw(texture, getX()-16 + x, getY()-16 + y, getWidth()+50, getHeight()+50);
    batch.setColor(1, 1, 1, 1);
  }

  public void dispose() {
    texture.dispose();
  }

}