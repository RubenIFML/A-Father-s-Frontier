package screens;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import fs_elements.Boton;
import fs_elements.FS1_1;
import fs_elements.FS1_2;
import fs_elements.FS1_3;
import fs_elements.Lluvia;
import fs_elements.Maletin;
import fs_elements.Mesa;
import fs_elements.Objeto;
import fs_elements.Pasaporte;
import fs_elements.Reglas;
import fs_elements.Reloj;
import fs_elements.Texto;
import game.Demo;
import game.Parametros;
import managers.AudioManager;
import managers.ResourceManager;

public class FrontierScreen extends BScreen implements InputProcessor{

Stage mainStage;
OrthographicCamera camara;
private TiledMap map;
private OrthogonalTiledMapRenderer renderer;
public float mouseX;
public float mouseY;
float tiempo = 0f;
private Texture backgroundTexture;
private Actor backgroundActor;
private Music musica;
private Music musica2;
private Texto texto;
private Lluvia lluvia;
private FS1_1 fs1_1;
private FS1_2 fs1_2;
private FS1_3 fs1_3;
private Mesa mesa;
private Boton botonRojo;
private Boton botonVerde;
private Maletin maletin;
private Reglas reglas1_0;
public static Reloj reloj;
private Pasaporte pasaporte1;
private Pasaporte pasaporte2;
private Pasaporte pasaporte3;
private Objeto botella;
private Objeto pistola;

public boolean apareceP1 = false;
public boolean equipajeP1 = false;
public boolean startP1 = false;

public boolean pasaP2 = false;
private boolean apareceP2 = false;
public boolean equipajeP2 = false;
public boolean startP2 = false;

public boolean pasaP3 = false;
private boolean apareceP3 = false;
public boolean equipajeP3 = false;
public boolean startP3 = false;

public boolean terminado = false;

	public FrontierScreen(Demo game) {
		
		//Básicos
		
		super(game);
		
    	Parametros.ganas=false;
		
		mainStage=new Stage();
		
		backgroundTexture = new Texture(Gdx.files.internal("Menu/PapersBackgraundTsx.png"));
		backgroundActor = new Image(backgroundTexture);
		
		musica = Gdx.audio.newMusic(Gdx.files.internal("01-FS/Audio/music/maletin_por_favor.mp3"));
		musica.play();
        musica.setVolume(0.3f);
		musica.setLooping(true);

		musica2 = Gdx.audio.newMusic(Gdx.files.internal("01-FS/Audio/music/lluvia.mp3"));
		musica2.play();
        musica2.setVolume(0.4f);
		musica2.setLooping(true);
		
	    
		map=ResourceManager.getMap("Mapas/PapersBackground.tmx");
		
		renderer=new OrthogonalTiledMapRenderer(map,mainStage.getBatch());
		
		camara=(OrthographicCamera) mainStage.getCamera();
		camara.setToOrtho(false, Parametros.getAnchoPantalla()*Parametros.zoom, Parametros.getAltoPantalla()*Parametros.zoom);
		renderer.setView(camara);

		mainStage.addActor(backgroundActor);
		backgroundActor.setSize(240,180);

		lluvia = new Lluvia();
		mainStage.addActor(lluvia);
		
		//Elementos imprescindibles
		
		switch (Parametros.dia) {
			case 1:
				fs1_1 = new FS1_1(mainStage);
				mainStage.addActor(fs1_1);
				fs1_1.hide();
				
				fs1_2 = new FS1_2(mainStage);
				mainStage.addActor(fs1_2);
				fs1_2.hide();
				
				fs1_3 = new FS1_3(mainStage);
				mainStage.addActor(fs1_3);
				fs1_3.hide();
				
				mesa = new Mesa();
				mainStage.addActor(mesa);
				botonRojo = new Boton(165, "botonRojo.png", "botonRojo_pressed.png");
				mainStage.addActor(botonRojo);
				botonVerde = new Boton(200, "botonVerde.png", "botonVerde_pressed.png");
				mainStage.addActor(botonVerde);
				
				maletin = new Maletin();
				mainStage.addActor(maletin);
				maletin.hide();
				
				reglas1_0 = new Reglas(170, 50, 50, 63, "reglas.1_0.png");
				mainStage.addActor(reglas1_0);
				
				reloj = new Reloj();
				mainStage.addActor(reloj);
	
				texto = new Texto("Que pase el siguiente.\n"
									+ "(Pulsa CLICK)", 10, 154);
				mainStage.addActor(texto);
			       
				Parametros.quitarTexto=true;
				apareceP1=true;
				Parametros.controlesActivos=false;
				break;
				
			case 2:
				
				break;
				
			case 3:
				
				break;
				
		default:
			break;
			
		}
		
	}
	
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		
		switch (Parametros.dia) {
		
			case 1:
				
		        if (button == Input.Buttons.LEFT && Parametros.quitarTexto==true) {
		        	
		        	if(apareceP1==true) {
		            	
		        		AudioManager.playSound("01-FS/Audio/sounds/menuBoton.mp3");
		    			texto.remove();
		    			fs1_1.show();
		    			texto = new Texto("Pasaporte y equipaje,\n"
		    							+ "por favor.", 10, 154);
		    			mainStage.addActor(texto);
		    			
		    			apareceP1=false;
		    			equipajeP1=true;
		    			
		            } else if (equipajeP1==true) {
		            	
		            	AudioManager.playSound("01-FS/Audio/sounds/menuBoton.mp3");
		    			texto.remove();
		    			texto = new Texto("(Comprobar� las reglas\n"
		    							+ "y decidir� qu� hacer)", 7, 154);
		    			mainStage.addActor(texto);
		        		AudioManager.playSound("01-FS/Audio/sounds/maletin.mp3");
		    			maletin.show();
		    			pasaporte1 = new Pasaporte(17, 20, 50, 73, "pasaporte.1_1.png");
		    			mainStage.addActor(pasaporte1);
		    			
		    			equipajeP1=false;
		    			startP1=true;
		    			
		    			pistola = new Objeto(108, 26, 48, 28, "objeto.pistola.png", "pistola.mp3");
		    			mainStage.addActor(pistola);
		
		    			
		            } else if (startP1==true) {
		            	
		            	AudioManager.playSound("01-FS/Audio/sounds/menuBoton.mp3");
		    			texto.remove();
		    			Parametros.controlesActivos=true;
		    			reloj.start();
		    			startP1=false;
		    			Parametros.analizar=true;
		    			
		            } else if (Parametros.analizadoP1==true) {
		
		            	Parametros.controlesActivos=false;
		            	AudioManager.playSound("01-FS/Audio/sounds/menuBoton.mp3");
		    			texto = new Texto("LLAMAR AL SIGUIENTE\n"
		        						+ "(Pulsa CLICK)", 10, 154);
		        		mainStage.addActor(texto);
		            	fs1_1.fadeOut();
		            	pasaporte1.remove();
		            	maletin.hide();
		            	pistola.remove();
		            	FS1_1.texto.remove();
		    			Parametros.analizar=false;
		    			Parametros.analizadoP1=false;
		    			pasaP2=true;
		    			
		            } else if (pasaP2==true) {
		            	
		            	AudioManager.playSound("01-FS/Audio/sounds/menuBoton.mp3");
		    			texto.remove();
		        		texto = new Texto("Que pase el siguiente,\n"
										+ "m�s r�pido, por favor.", 10, 154);
		        		mainStage.addActor(texto);
		        		pasaP2=false;
		    			apareceP2 = true;
		    			
			        } else if (apareceP2==true) {
		            	
			        	AudioManager.playSound("01-FS/Audio/sounds/menuBoton.mp3");
						texto.remove();
		    			fs1_2.show();
		    			texto = new Texto("Pasaporte y equipaje,\n"
		    							+ "cuanto antes, mejor.", 10, 154);
		    			mainStage.addActor(texto);
		    			
		    			apareceP2=false;
		    			equipajeP2=true;
		    			
		            } else if (equipajeP2==true) {
		            	
		            	AudioManager.playSound("01-FS/Audio/sounds/menuBoton.mp3");
		    			texto.remove();
		    			texto = new Texto("(Veamos qu� tenemos\n"
		    							+ "por aqu�)", 7, 154);
		    			mainStage.addActor(texto);
		        		AudioManager.playSound("01-FS/Audio/sounds/maletin.mp3");
		    			maletin.show();
		
		    			pasaporte2 = new Pasaporte(17, 20, 50, 73, "pasaporte.1_2.png");
		    			mainStage.addActor(pasaporte2);
		    			
		    			botella = new Objeto(76, 26, 36, 43, "objeto.botella.png", "botella.mp3");
		    			mainStage.addActor(botella);
		    			
		    			equipajeP2=false;
		    			startP2=true;
		    			
			        } else if (startP2==true) {
			        	
			        	AudioManager.playSound("01-FS/Audio/sounds/menuBoton.mp3");
						texto.remove();
						Parametros.controlesActivos=true;
						startP2=false;
						Parametros.analizar=true;
						
			        } else if (Parametros.analizadoP2==true) {
		
			        	AudioManager.playSound("01-FS/Audio/sounds/menuBoton.mp3");
						texto = new Texto("LLAMAR AL SIGUIENTE\n"
		        						+ "(Pulsa CLICK)", 10, 154);
		        		mainStage.addActor(texto);
		    			Parametros.controlesActivos=false;
		            	fs1_2.fadeOut();
			        	pasaporte2.remove();
			        	maletin.hide();
			        	botella.remove();
			        	FS1_2.texto.remove();
						Parametros.analizar=false;
						Parametros.analizadoP2=false;
						pasaP3 = true;
						
		            } else if (pasaP3==true) {
		            	
		            	AudioManager.playSound("01-FS/Audio/sounds/menuBoton.mp3");
		    			texto.remove();
		        		texto = new Texto("Siguiente, por favor,\n"
										+ "no pienso repetirlo.", 10, 154);
		        		mainStage.addActor(texto);
		        		pasaP3=false;
		    			apareceP3 = true;
		           
		        	} else if (apareceP3==true) {
		        	
		        		AudioManager.playSound("01-FS/Audio/sounds/menuBoton.mp3");
		    			texto.remove();
						fs1_3.show();
						texto = new Texto("Pasaporte y equipaje,\n"
										+ "cuanto antes, mejor.", 10, 154);
						mainStage.addActor(texto);
						
						apareceP3=false;
						equipajeP3=true;
						
		            } else if (equipajeP3==true) {
		            	
		            	AudioManager.playSound("01-FS/Audio/sounds/menuBoton.mp3");
		    			texto.remove();
		    			texto = new Texto("(Empecemos...)\n", 7, 154);
		    			mainStage.addActor(texto);
		        		AudioManager.playSound("01-FS/Audio/sounds/maletin.mp3");
		    			maletin.show();
		
		    			pasaporte3 = new Pasaporte(17, 20, 50, 73, "pasaporte.1_3.png");
		    			mainStage.addActor(pasaporte3);
		
		    			pistola = new Objeto(108, 26, 48, 28, "objeto.pistola.png", "pistola.mp3");
		    			mainStage.addActor(pistola);
		    			botella = new Objeto(76, 26, 36, 43, "objeto.botella.png", "botella.mp3");
		    			mainStage.addActor(botella);
		    			
		    			equipajeP3=false;
		    			startP3=true;
			        } else if (startP3==true) {
			        	
			        	AudioManager.playSound("01-FS/Audio/sounds/menuBoton.mp3");
						texto.remove();
						Parametros.controlesActivos=true;
						startP3=false;
						Parametros.analizar=true;
						
			        } else if (Parametros.analizadoP3==true) {
			        	
			        	AudioManager.playSound("01-FS/Audio/sounds/menuBoton.mp3");
						Parametros.controlesActivos=false;
		        		texto = new Texto("(Parece que ya va\n"
										+ "siendo hora de irse)", 10, 154);
		        		mainStage.addActor(texto);
		            	fs1_3.fadeOut();
			        	pasaporte3.remove();
			        	maletin.hide();
			        	botella.remove();
			        	pistola.remove();
			        	FS1_3.texto.remove();
						Parametros.analizar=false;
						Parametros.analizadoP3=false;
						terminado = true;
						
			        } else if (terminado==true) {
			        	AudioManager.playSound("01-FS/Audio/sounds/menuBoton.mp3");
						Parametros.ganas=true;
						Parametros.dia++;
					    musica.stop();
					    musica2.stop();
			        }
		        }
		        	break;
        	
	        case 2:
	        
	        	break;
	        
	        case 3:
	        	
	        	break;
	        	
	        default:
	        	break;
	        
        }
        return false;
    }
	
	@Override
	public void render(float delta) {
		super.render(delta);
	    mainStage.act();
	    mainStage.draw();
	    
	    mouseX = Gdx.input.getX();
	    mouseY = Gdx.input.getX();
	    
	    renderer.setView(camara);
	    renderer.render();
	    mainStage.draw();
	    
	    if(reloj.tiempoRestante==0) {
			game.setScreen(new EndScreen(game));
		    musica.stop();
		    musica2.stop();
	    }
	    
	}
}
