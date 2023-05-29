package ow_elements;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Actor;

import managers.ResourceManager;

/**
 * Muestra el cartel de "Lista de tareas" en la parte superior izquierda de la interfaz.
 * @author Rubén Moya
 */
public class TareasSinExpandir extends Actor {

    private BitmapFont font;
    public static float tiempoRestante = 300;
    private String titulo;
    private Texture tareas;

    public TareasSinExpandir() {
        // Cargar la fuente desde el archivo Peepo.ttf
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("Peepo.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 17; // Tamaño de la fuente
        this.font = generator.generateFont(parameter);
        generator.dispose();
        
        this.titulo = "- LISTA DE TAREAS -";
        this.tareas = ResourceManager.getTexture("Menu/listaTareas1.png");
        setBounds(10, 300, 232, 290);
    }

    public void act(float delta) {
        super.act(delta);
    }

    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.draw(tareas, getX(), getY(), getWidth(), getHeight());
        font.draw(batch, titulo, 43, 569);
    }
}