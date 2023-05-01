package ow_elements;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Reloj extends Actor {

    private BitmapFont font;
    public static float tiempoRestante = 300;
    private String tiempoTexto;
    private Texture reloj;
    private float textX;
    private float textY;
    private boolean empezar = false;

    public Reloj() {
        this.font = new BitmapFont();
        this.font.getData().setScale(2);
        this.tiempoTexto = "" + convertirTiempo(tiempoRestante);
        
        textX = 661;
        textY = 577;
        setBounds(652, 540, 143, 50);
        
        this.reloj = new Texture("Menu/menuBoton.png");
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