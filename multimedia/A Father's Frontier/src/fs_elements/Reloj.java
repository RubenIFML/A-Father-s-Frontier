package fs_elements;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;

import game.Parametros;
import managers.ResourceManager;

/**
 * Crea el reloj de la Frontera, el cual va reduci�ndose
 * poco a poco hasta que llega a cero.
 * @author Rub�n Moya
 */
public class Reloj extends Actor {

    private BitmapFont font;
    public float tiempoRestante;
    public String tiempoTexto;
    private Texture reloj;
    private float textX;
    private float textY;
    private boolean empezar = false;

    public Reloj() {
        this.font = new BitmapFont();
        this.tiempoRestante = Parametros.segundosFS;
        this.tiempoTexto = "" + (int)tiempoRestante;
        
        setBounds(178, 158, 62, 23);
        
        this.reloj = ResourceManager.getTexture("Menu/menuBoton.png");
    }

	/**
	 * El tiempo se va restando milisegundo a milisegundo hasta que llega a cero.
	 * Dependiendo de la longitud del n�mero, la posici�n del texto cambiar�.
	 */
    public void act(float delta) {
        super.act(delta);
        
        if(tiempoRestante>100) {
            textX = 182;
            textY = 175;
        }
        else {
            textX = 187;
            textY = 175;
        }
        
        if(empezar == true) {
	        tiempoRestante -= delta;
	        
	        if (tiempoRestante <= 0) {
	            tiempoRestante = 0;
	        }
	        
	        int segundos = (int) tiempoRestante;
	        int milisegundos = (int) ((tiempoRestante - segundos) * 1000);
	        String tiempo = String.format("%02d:%03d", segundos, milisegundos);
	        tiempoTexto = "" + tiempo;
        }
        else {
        	if(Parametros.segundosFS>=100) {
        		tiempoTexto = Parametros.segundosFS + ":00";	
        	}
        	else if(Parametros.segundosFS<100) {
        		tiempoTexto = Parametros.segundosFS + ":000";	
        	}
        }
    }

    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.draw(reloj, getX(), getY(), getWidth(), getHeight());
        font.draw(batch, tiempoTexto, textX, textY);
     }

	/**
	 * Comienza el reloj.
	 */
	public void start() {
		empezar = true;
	}

	/**
	 * Detiene el reloj.
	 */
	public void stop() {
		empezar = false;
	}

	/**
	 * Modifica el tiempo del reloj.
	 */
	public void modTiempo(float tiempo) {
		tiempoRestante+=tiempo;
	}
}