package ow_elements;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Carga el nombre de la zona en la que se encuentra el protagonista, para después
 * desvanecerse pasados unos segundos.
 * @author Rubén Moya
 */
public class TarjetaDeZona extends Actor {

    private BitmapFont font;
    private String titulo;
    private int textX=20;
    private int textY=54;
    private int color;
    private float elapsed = 0f;
    
    public TarjetaDeZona(String titulo, int color) {
    	
    	this.titulo=titulo;
    	this.color=color;
    	
        // Cargar la fuente desde el archivo Peepo.ttf
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("Peepo.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 35; // Tamaño de la fuente
		parameter.borderWidth=2;
        
		switch(this.color) {
			case 0:
				parameter.color = Color.WHITE;
				break;
			case 1:
				parameter.color = Color.GRAY;
				break;
		}
		
		this.font = generator.generateFont(parameter);
        generator.dispose();
        
    }

    public void act(float delta) {
        super.act(delta);
        elapsed += delta;
    }

    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        
        // Calcular la opacidad actual de la tarjeta
        float opacity = 1f;
        if (elapsed < 1f) {  // Fade in
            opacity = elapsed;
        } else if (elapsed > 2f) {  // Fade out
            opacity = 3f - elapsed;
        }
        
        // Dibujar la fuente con la opacidad actual
        font.setColor(font.getColor().r, font.getColor().g, font.getColor().b, opacity * parentAlpha);
        font.draw(batch, titulo, textX, textY);
        
        // Si ya ha terminado el efecto de fade out, eliminar la tarjeta
        if (elapsed > 3f) {
            remove();
        }
    }
}