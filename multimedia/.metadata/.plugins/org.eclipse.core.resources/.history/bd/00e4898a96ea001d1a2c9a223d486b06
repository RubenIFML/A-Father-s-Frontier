package ow_elements;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Actor;

import game.Parametros;

public class Dinero extends Actor {

    private BitmapFont font;
    public static float tiempoRestante = 300;
    private String dineroActual;
    private Texture dinero;
    private int textX;
    private int textY;

    public Dinero() {
        // Cargar la fuente desde el archivo Peepo.ttf
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("Peepo.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 35; // Tamaño de la fuente
        this.font = generator.generateFont(parameter);
        generator.dispose();

        
        this.dinero = new Texture("Menu/menuBoton.png");
        setBounds(688, 10, 100, 60);
        comparacion();
        this.dineroActual = "£" + Parametros.dinero;
        
    }

    public void act(float delta) {
        super.act(delta);
        comparacion();
        this.dineroActual = "£" + Parametros.dinero;
    }

    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.draw(dinero, getX(), getY(), getWidth(), getHeight());
        font.draw(batch, dineroActual, textX, textY);
    }
    
    private void comparacion() {
        if(Parametros.dinero <10) {
            textX=713;
            textY=54;
        }
        else {
            textX=706;
            textY=54;
        }
    }
}