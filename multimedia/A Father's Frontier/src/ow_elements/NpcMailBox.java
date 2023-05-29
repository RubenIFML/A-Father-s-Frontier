package ow_elements;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import game.Parametros;
import managers.AudioManager;
import managers.ResourceManager;
import screens.OverWorldScreen;

/**
 * Establece el NPC del buzón de correo para pagar deudas e impuestos.
 * @author Rubén Moya
 */
public class NpcMailBox extends Element {
	private OverWorldScreen nivel;
	private Texto interaccion;
	private int siguienteInteraccion = 0;
	private Image bocadillo;
	private float elapsedTime = 0;
	private Element dialogBox;
	private String dialogo1;
	private String dialogo2;

	public NpcMailBox(float x, float y, Stage s, OverWorldScreen nivel, String tile, String dialogo1, String dialogo2) {
		super(x, y, s);
		this.nivel = nivel;
		this.dialogo1 = dialogo1;
		this.dialogo2 = dialogo2;
		
		loadFullAnimation(tile, 1, 1, 0.1f,false);
		this.setRectangle(31, 31, 0, 0);
		
		dialogBox=new Element(0,0,s,this.getWidth(),this.getHeight());
		dialogBox.setPosition(this.getX(),this.getY());
		dialogBox.setRectangle();
	}

	/**
	 * Controla las interacciones, las colisiones, la distancia y mueve el bocadillo.
	 */
	public void act(float delta) {
	    super.act(delta);
	    float distanciaX = Math.abs(nivel.prota.getX() - getX());
	    float distanciaY = Math.abs(nivel.prota.getY() - getY());

	    comprobarColisiones();
	    
		bocadillo(distanciaX, distanciaY);
	    
	    if(bocadillo!=null) {
		    if (elapsedTime < 1) {
		        bocadillo.setY(bocadillo.getY() + 3 * delta);
		    } else if (elapsedTime < 3) {
		    	bocadillo.setY(bocadillo.getY() - 3 * delta);
		    }

		    if (elapsedTime > 2) {
		        elapsedTime = 0;
		    } else {
		        elapsedTime += delta;
		    }
	    }
	    
	    if(siguienteInteraccion==0) {
		    if (Gdx.input.justTouched()) {
		        Vector2 clickCoords = nivel.mainStage.screenToStageCoordinates(new Vector2(Gdx.input.getX(), Gdx.input.getY()));
		        if (distanciaX < 60 && distanciaY < 60 && dialogBox.getBoundaryPolygon().contains(clickCoords.x, clickCoords.y) && !Parametros.interactuandoNpc) {
		            interactuar();
		        }
		    }
	    }
	    else {
	    	if (Gdx.input.justTouched()) {
		    		if(interaccion.completo==true) {
			    		interactuar();
		    		}
		    		else {
		    			interaccion.completo=true;
	    	            AudioManager.playSound("01-FS/Audio/sounds/menuBoton.wav");
		    		}
	    		}
	    }
	}

	/**
	 * Comprueba las colisiones del NpcMailBox con el protagonista.
	 */
	private void comprobarColisiones() {
		if (this.nivel.prota.overlaps(this)) {
			this.nivel.prota.preventOverlap(this);
		}
	}

	/**
	 * Crea el actor bocadillo del NpcMailBox, el cual se oculta si el
	 * protagonista está lejos y aparece si está cerca. Si el protagonista
	 * todavía no ha pagado las deudas hoy, el bocadillo mostrará una carta,
	 * y si ya ha pagado hoy, el bocadillo mostrará puntos suspensivos.
	 * @param distanciaX Distancia en "X" entre el npc y el protagonista.
	 * @param distanciaY Distancia en "Y" entre el npc y el protagonista.
	 */
	private void bocadillo(float distanciaX, float distanciaY) {
		if(!Parametros.haPagadoDeuda)
			if (distanciaX < 60 && distanciaY < 60 &&
			        ((nivel.prota.getX() < getX() && nivel.prota.getY() < getY()) ||
			         (nivel.prota.getX() >= getX() && nivel.prota.getY() < getY()) ||
			         (nivel.prota.getX() < getX() && nivel.prota.getY() >= getY()) ||
			         (nivel.prota.getX() >= getX() && nivel.prota.getY() >= getY()))) {
			    // el personaje está cerca y en la dirección correcta, creamos y agregamos el actor bocadillo
			    if (bocadillo == null) {
			        bocadillo = new Image(ResourceManager.getTexture("02-OW/Personajes/b_mail.png"));
			        bocadillo.setBounds(getX()+10, getY()-34 + getHeight() + 10, 15,15); // ajustar la posición del bocadillo
			        bocadillo.setName("bocadillo");
			        nivel.mainStage.addActor(bocadillo);
			    }
			} else {
			    // el personaje se alejó o no está en la dirección correcta, eliminamos el actor bocadillo
			    if (bocadillo != null) {
			        bocadillo.remove();
			        bocadillo = null;
			    }
			}
		else {
			if(bocadillo!=null) {
				bocadillo.remove();
			}
		}
	}
	
	/**
	 * Crea los diálogos, cambia variables y muestra al jugador las interacciones
	 * del NPC una tras otra si se pulsa clic izquierdo.
	 */
	private void interactuar() {
	    nivel.prota.pasos.stop();
		switch(Parametros.dia) {
		case 4:
		    switch (siguienteInteraccion) {
	        case 0:
	        	Parametros.interactuandoNpc = true;
	            AudioManager.playSound("01-FS/Audio/sounds/menuBoton.wav");
	            interaccion = new Texto("(Ya he pagado mi deuda de hoy,\ndebo recordar volver mañana.)", "talk2");
	            this.nivel.uiStage.addActor(interaccion);
	            siguienteInteraccion++;
	            break;
	        case 1:
	            AudioManager.playSound("01-FS/Audio/sounds/menuBoton.wav");
	            interaccion.hide();
	            Parametros.controlesActivos = true; // se activan los controles del personaje
	            Parametros.interactuandoNpc = false;
	            siguienteInteraccion = 0; // se reinicia el contador después de la última interacción
	            break;
		    }
			break;
			
		default:
		    Parametros.controlesActivos = false; // se desactivan los controles del personaje
		    if(Parametros.dinero >= Parametros.precioImpuestos) {
		    	if(Parametros.haPagadoDeuda == false) {
				    switch (siguienteInteraccion) {
			        case 0:
			        	Parametros.interactuandoNpc = true;
			            AudioManager.playSound("01-FS/Audio/sounds/menuBoton.wav");
			            interaccion = new Texto(this.dialogo1, "talk2");
			            this.nivel.uiStage.addActor(interaccion);
			            siguienteInteraccion++;
			            break;
			        case 1:
			            AudioManager.playSound("01-FS/Audio/sounds/menuBoton.wav");
			            interaccion.hide();
			            interaccion = new Texto(this.dialogo2, "talk2");
			            this.nivel.uiStage.addActor(interaccion);
			            AudioManager.playSound("02-OW/Audio/sounds/comprar.wav");
			            siguienteInteraccion++;
			            break;
			        case 2:
			            AudioManager.playSound("01-FS/Audio/sounds/menuBoton.wav");
			            interaccion.hide();
			            Parametros.haPagadoDeuda = true;
			            Parametros.controlesActivos = true; // se activan los controles del personaje
			            Parametros.interactuandoNpc = false;
			            siguienteInteraccion = 0; // se reinicia el contador después de la última interacción
			            Parametros.dinero-=Parametros.precioImpuestos;
			            break;
				    }
		    	}
		    	else {
				    switch (siguienteInteraccion) {
			        case 0:
			        	Parametros.interactuandoNpc = true;
			            AudioManager.playSound("01-FS/Audio/sounds/menuBoton.wav");
			            interaccion = new Texto("(Ya he pagado mi deuda de hoy,\ndebo recordar volver mañana.)", "talk2");
			            this.nivel.uiStage.addActor(interaccion);
			            siguienteInteraccion++;
			            break;
			        case 1:
			            AudioManager.playSound("01-FS/Audio/sounds/menuBoton.wav");
			            interaccion.hide();
			            Parametros.controlesActivos = true; // se activan los controles del personaje
			            Parametros.interactuandoNpc = false;
			            siguienteInteraccion = 0; // se reinicia el contador después de la última interacción
			            break;
				    }
		    	}
		    }
		    
		    else {
			    switch (siguienteInteraccion) {
		        case 0:
		        	Parametros.interactuandoNpc = true;
		            AudioManager.playSound("01-FS/Audio/sounds/menuBoton.wav");
		            interaccion = new Texto("(Necesito al menos £" + Parametros.precioImpuestos + " para pagar mis deudas\ne impuestos... Llevo meses de retraso)", "talk2");
		            this.nivel.uiStage.addActor(interaccion);
		            siguienteInteraccion++;
		            break;
		        case 1:
		            AudioManager.playSound("01-FS/Audio/sounds/menuBoton.wav");
		            interaccion.hide();
		            Parametros.controlesActivos = true; // se activan los controles del personaje
		            Parametros.interactuandoNpc = false;
		            siguienteInteraccion = 0; // se reinicia el contador después de la última interacción
		            break;
			    }
		    }
			
			break;
		
		}

	}
}