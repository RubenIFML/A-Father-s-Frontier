package ow_elements;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Actor;

import managers.ResourceManager;

public class Reloj extends Actor {

    private BitmapFont font;
    public static float tiempoRestante = 300;
    public static String tiempoTexto;
    private Texture reloj;
    public Sound tiktak;
    private float textX;
    private float textY;
    private boolean empezar = false;

    public Reloj() {
    	
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("Peepo.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 29; // Tamaño de la fuente
        this.font = generator.generateFont(parameter);
        generator.dispose();
        Reloj.tiempoTexto = "" + convertirTiempo(tiempoRestante);
        
        textX = 656;
        textY = 577;
        setBounds(647, 540, 143, 50);
        
        this.reloj = ResourceManager.getTexture("Menu/menuBoton.png");
    }

    public void act(float delta) {
        super.act(delta);
        
        if(empezar == true) {
            tiempoRestante -= delta;
	        
	        if (tiempoRestante <= 0) {
	            tiempoRestante = 0;
	            empezar = false;
	        }
	        
	        tiempoTexto = convertirTiempo(tiempoRestante);
        }
    }

    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.draw(reloj, getX(), getY(), getWidth(), getHeight());
        font.draw(batch, tiempoTexto, textX, textY);
    }

    public void start() {
        empezar = true;
    }
	
    public void stop() {
        empezar = false;
    }
	
    public void modTiempo(float tiempo) {
        tiempoRestante += tiempo;
        tiempoTexto = convertirTiempo(tiempoRestante);
    }
    
    private String convertirTiempo(float tiempo) {
        int minutos = (int) tiempo / 60;
        int segundos = (int) tiempo % 60;
        int milisegundos = (int) ((tiempo - (minutos * 60 + segundos)) * 1000);
        return String.format("%02d:%02d:%03d", minutos, segundos, milisegundos);
    }
}