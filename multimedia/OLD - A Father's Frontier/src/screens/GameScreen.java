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
import elements.Botella;
import elements.BotonRojo;
import elements.BotonVerde;
import elements.Lluvia;
import elements.Maletin;
import elements.Mesa;
import elements.Pasaporte1;
import elements.Pasaporte2;
import elements.Pasaporte3;
import elements.Persona1;
import elements.Persona2;
import elements.Persona3;
import elements.Pistola;
import elements.Reglas;
import elements.Reloj;
import elements.Texto;
import game.Demo;
import game.Parametros;
import managers.AudioManager;
import managers.ResourceManager;

public class GameScreen extends BScreen implements InputProcessor{

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
private Persona1 persona1;
private Persona2 persona2;
private Persona3 persona3;
private Mesa mesa;
private BotonRojo botonRojo;
private BotonVerde botonVerde;
private Maletin maletin;
private Reglas reglas;
public static Reloj reloj;
private Pasaporte1 pasaporte1;
private Pasaporte2 pasaporte2;
private Pasaporte3 pasaporte3;
private Botella botella;
private Pistola pistola;

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

	public GameScreen(Demo game) {
		
		//Básicos
		
		super(game);
		
    	Parametros.ganas=false;
		
		mainStage=new Stage();
		
		backgroundTexture = new Texture(Gdx.files.internal("maps/images/PapersBackgraundTsx.png"));
		backgroundActor = new Image(backgroundTexture);
		
		musica = Gdx.audio.newMusic(Gdx.files.internal("audio/music/maletin_por_favor.mp3"));
		musica.play();
        musica.setVolume(0.3f);
		musica.setLooping(true);

		musica2 = Gdx.audio.newMusic(Gdx.files.internal("audio/music/lluvia.mp3"));
		musica2.play();
        musica2.setVolume(0.4f);
		musica2.setLooping(true);
		
	    
		map=ResourceManager.getMap("maps/PapersBackground.tmx");
		
		renderer=new OrthogonalTiledMapRenderer(map,mainStage.getBatch());
		
		camara=(OrthographicCamera) mainStage.getCamera();
		camara.setToOrtho(false, Parametros.getAnchoPantalla()*Parametros.zoom, Parametros.getAltoPantalla()*Parametros.zoom);
		renderer.setView(camara);

		mainStage.addActor(backgroundActor);
		backgroundActor.setSize(240,180);

		lluvia = new Lluvia();
		mainStage.addActor(lluvia);
		
		//Elementos imprescindibles
		
		persona1 = new Persona1(mainStage);
		mainStage.addActor(persona1);
		persona1.hide();
		
		persona2 = new Persona2(mainStage);
		mainStage.addActor(persona2);
		persona2.hide();
		
		persona3 = new Persona3(mainStage);
		mainStage.addActor(persona3);
		persona3.hide();
		
		mesa = new Mesa();
		mainStage.addActor(mesa);
		botonRojo = new BotonRojo();
		mainStage.addActor(botonRojo);
		botonVerde = new BotonVerde();
		mainStage.addActor(botonVerde);
		
		maletin = new Maletin();
		mainStage.addActor(maletin);
		maletin.hide();
		
		reglas = new Reglas();
		mainStage.addActor(reglas);
		
		//Reloj
		
		reloj = new Reloj();
		mainStage.addActor(reloj);

		texto = new Texto("Que pase el siguiente.\n"
							+ "(Pulsa CLICK)", 10, 154);
		mainStage.addActor(texto);
	       
		Parametros.quitarTexto=true;
		apareceP1=true;
		Parametros.controlesActivos=false;
		
		}
	
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if (button == Input.Buttons.LEFT && Parametros.quitarTexto==true) {

        	if(apareceP1==true) {
            	
        		AudioManager.playSound("audio/sounds/menuBoton.mp3");
    			texto.remove();
    			persona1.show();
    			texto = new Texto("Pasaporte y equipaje,\n"
    							+ "por favor.", 10, 154);
    			mainStage.addActor(texto);
    			
    			apareceP1=false;
    			equipajeP1=true;
    			
            } else if (equipajeP1==true) {
            	
            	AudioManager.playSound("audio/sounds/menuBoton.mp3");
    			texto.remove();
    			texto = new Texto("(Comprobaré las reglas\n"
    							+ "y decidiré qué hacer)", 7, 154);
    			mainStage.addActor(texto);
        		AudioManager.playSound("audio/sounds/maletin.mp3");
    			maletin.show();
    			pasaporte1 = new Pasaporte1();
    			mainStage.addActor(pasaporte1);
    			
    			equipajeP1=false;
    			startP1=true;
    			
    			pistola = new Pistola();
    			mainStage.addActor(pistola);

    			
            } else if (startP1==true) {
            	
            	AudioManager.playSound("audio/sounds/menuBoton.mp3");
    			texto.remove();
    			Parametros.controlesActivos=true;
    			reloj.start();
    			startP1=false;
    			Parametros.analizar=true;
    			
            } else if (Parametros.analizadoP1==true) {

            	Parametros.controlesActivos=false;
            	AudioManager.playSound("audio/sounds/menuBoton.mp3");
    			texto = new Texto("LLAMAR AL SIGUIENTE\n"
        						+ "(Pulsa CLICK)", 10, 154);
        		mainStage.addActor(texto);
            	persona1.fadeOut();
            	pasaporte1.remove();
            	maletin.hide();
            	pistola.remove();
            	Persona1.texto.remove();
    			Parametros.analizar=false;
    			Parametros.analizadoP1=false;
    			pasaP2=true;
    			
            } else if (pasaP2==true) {
            	
            	AudioManager.playSound("audio/sounds/menuBoton.mp3");
    			texto.remove();
        		texto = new Texto("Que pase el siguiente,\n"
								+ "más rápido, por favor.", 10, 154);
        		mainStage.addActor(texto);
        		pasaP2=false;
    			apareceP2 = true;
    			
	        } else if (apareceP2==true) {
            	
	        	AudioManager.playSound("audio/sounds/menuBoton.mp3");
				texto.remove();
    			persona2.show();
    			texto = new Texto("Pasaporte y equipaje,\n"
    							+ "cuanto antes, mejor.", 10, 154);
    			mainStage.addActor(texto);
    			
    			apareceP2=false;
    			equipajeP2=true;
    			
            } else if (equipajeP2==true) {
            	
            	AudioManager.playSound("audio/sounds/menuBoton.mp3");
    			texto.remove();
    			texto = new Texto("(Veamos qué tenemos\n"
    							+ "por aquí)", 7, 154);
    			mainStage.addActor(texto);
        		AudioManager.playSound("audio/sounds/maletin.mp3");
    			maletin.show();

    			pasaporte2 = new Pasaporte2();
    			mainStage.addActor(pasaporte2);
    			
    			botella = new Botella();
    			mainStage.addActor(botella);
    			
    			equipajeP2=false;
    			startP2=true;
    			
	        } else if (startP2==true) {
	        	
	        	AudioManager.playSound("audio/sounds/menuBoton.mp3");
				texto.remove();
				Parametros.controlesActivos=true;
				startP2=false;
				Parametros.analizar=true;
				
	        } else if (Parametros.analizadoP2==true) {

	        	AudioManager.playSound("audio/sounds/menuBoton.mp3");
				texto = new Texto("LLAMAR AL SIGUIENTE\n"
        						+ "(Pulsa CLICK)", 10, 154);
        		mainStage.addActor(texto);
    			Parametros.controlesActivos=false;
            	persona2.fadeOut();
	        	pasaporte2.remove();
	        	maletin.hide();
	        	botella.remove();
	        	Persona2.texto.remove();
				Parametros.analizar=false;
				Parametros.analizadoP2=false;
				pasaP3 = true;
				
            } else if (pasaP3==true) {
            	
            	AudioManager.playSound("audio/sounds/menuBoton.mp3");
    			texto.remove();
        		texto = new Texto("Siguiente, por favor,\n"
								+ "no pienso repetirlo.", 10, 154);
        		mainStage.addActor(texto);
        		pasaP3=false;
    			apareceP3 = true;
           
        	} else if (apareceP3==true) {
        	
        		AudioManager.playSound("audio/sounds/menuBoton.mp3");
    			texto.remove();
				persona3.show();
				texto = new Texto("Pasaporte y equipaje,\n"
								+ "cuanto antes, mejor.", 10, 154);
				mainStage.addActor(texto);
				
				apareceP3=false;
				equipajeP3=true;
				
            } else if (equipajeP3==true) {
            	
            	AudioManager.playSound("audio/sounds/menuBoton.mp3");
    			texto.remove();
    			texto = new Texto("(Empecemos...)\n", 7, 154);
    			mainStage.addActor(texto);
        		AudioManager.playSound("audio/sounds/maletin.mp3");
    			maletin.show();

    			pasaporte3 = new Pasaporte3();
    			mainStage.addActor(pasaporte3);

    			pistola = new Pistola();
    			mainStage.addActor(pistola);
    			botella = new Botella();
    			mainStage.addActor(botella);
    			
    			equipajeP3=false;
    			startP3=true;
	        } else if (startP3==true) {
	        	
	        	AudioManager.playSound("audio/sounds/menuBoton.mp3");
				texto.remove();
				Parametros.controlesActivos=true;
				startP3=false;
				Parametros.analizar=true;
				
	        } else if (Parametros.analizadoP3==true) {
	        	
	        	AudioManager.playSound("audio/sounds/menuBoton.mp3");
				Parametros.controlesActivos=false;
        		texto = new Texto("(Parece que ya va\n"
								+ "siendo hora de irse)", 10, 154);
        		mainStage.addActor(texto);
            	persona3.fadeOut();
	        	pasaporte3.remove();
	        	maletin.hide();
	        	botella.remove();
	        	pistola.remove();
	        	Persona3.texto.remove();
				Parametros.analizar=false;
				Parametros.analizadoP3=false;
				terminado = true;
				
	        } else if (terminado==true) {
	        	AudioManager.playSound("audio/sounds/menuBoton.mp3");
				Parametros.ganas=true;
				game.setScreen(new EndScreen(game));
			    musica.stop();
			    musica2.stop();
	        }
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
