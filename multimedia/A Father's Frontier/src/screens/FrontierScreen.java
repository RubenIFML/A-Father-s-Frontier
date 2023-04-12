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
import fs_elements.FS1_4;
import fs_elements.FS2_1;
import fs_elements.FS2_2;
import fs_elements.FS2_3;
import fs_elements.FS2_4;
import fs_elements.Lluvia;
import fs_elements.Maletin;
import fs_elements.Mesa;
import fs_elements.Objeto;
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
private Texture blackBackground;
private Texture backgroundTexture;
private Actor backgroundActor;
private Actor blackBackgroundActor;
private Music musica;
private Music musica2;
private Texto texto;
private Lluvia lluvia;
private FS1_1 fs1_1;
private FS1_2 fs1_2;
private FS1_3 fs1_3;
private FS1_4 fs1_4;
private FS2_1 fs2_1;
private FS2_2 fs2_2;
private FS2_3 fs2_3;
private FS2_4 fs2_4;
private Mesa mesa;
private Boton botonRojo;
private Boton botonVerde;
private Maletin maletin;
private Reglas reglas;
public static Reloj reloj;

private Objeto pasaporte1;
private Objeto pasaporte2;
private Objeto pasaporte3;
private Objeto pasaporte4;
private Objeto botella;
private Objeto pistola;
private Objeto cuchillo;
private Objeto carta;
private Objeto pintalabios;
private Objeto sombrero;
private Objeto hucha;
private Objeto sopa;
private Objeto platano;

private int contador = 0;

public boolean terminado = false;

	public FrontierScreen(Demo game) {
		
		super(game);

		mainStage=new Stage();
		
		Parametros.dineroAnterior = Parametros.dinero;
		
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

		blackBackground = new Texture(Gdx.files.internal("Menu/blackBackground.png"));
		blackBackgroundActor = new Image(blackBackground);

		Parametros.controlesActivos = false;  
		Parametros.quitarTexto = false;       
		Parametros.analizar = false;          
		Parametros.analizado1 = false;        
		Parametros.analizado2 = false;        
		Parametros.analizado3 = false;        
		Parametros.analizado4 = false;        
		Parametros.correcto = false;          
		
		//Progresi�n
		
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
				
				fs1_4 = new FS1_4(mainStage);
				mainStage.addActor(fs1_4);
				fs1_4.hide();
				
				mesa = new Mesa();
				mainStage.addActor(mesa);
				botonRojo = new Boton(165, "botonRojo.png", "botonRojo_pressed.png");
				mainStage.addActor(botonRojo);
				botonVerde = new Boton(200, "botonVerde.png", "botonVerde_pressed.png");
				mainStage.addActor(botonVerde);
				
				maletin = new Maletin();
				mainStage.addActor(maletin);
				maletin.hide();
				
				reglas = new Reglas(170, 50, 60, 74, "reglas.1_0.png", null, null);
				mainStage.addActor(reglas);
				
				reloj = new Reloj();
				mainStage.addActor(reloj);
	
				texto = new Texto("�?: Que pase el primero,\n"
								+ "por favor.", 7, 154);
				mainStage.addActor(texto);
			       
				Parametros.quitarTexto=true;
				contador++;
				break;
				
			case 2:
				fs2_1 = new FS2_1(mainStage);
				mainStage.addActor(fs2_1);
				fs2_1.hide();          
				
				fs2_2 = new FS2_2(mainStage);
				mainStage.addActor(fs2_2);
				fs2_2.hide();          
				
				fs2_3 = new FS2_3(mainStage);
				mainStage.addActor(fs2_3);
				fs2_3.hide();        
				
				fs2_4 = new FS2_4(mainStage);
				mainStage.addActor(fs2_4);
				fs2_4.hide();        
				
				mesa = new Mesa();
				mainStage.addActor(mesa);
				botonRojo = new Boton(165, "botonRojo.png", "botonRojo_pressed.png");
				mainStage.addActor(botonRojo);
				botonVerde = new Boton(200, "botonVerde.png", "botonVerde_pressed.png");
				mainStage.addActor(botonVerde);
				
				maletin = new Maletin();
				mainStage.addActor(maletin);
				maletin.hide();
				
				reglas = new Reglas(161, 50, 69, 74, "reglas.2_0.png", "reglas.2_1.png", null);
				mainStage.addActor(reglas);
				
				reloj = new Reloj();
				mainStage.addActor(reloj);
	
				texto = new Texto("�?: Que pase el si-\n"
								+ "guiente, por favor.", 7, 154);
				mainStage.addActor(texto);
			       
				Parametros.quitarTexto=true;
				contador++;
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
		        	
		        	if(contador==1) {
		            	
		        		AudioManager.playSound("01-FS/Audio/sounds/menuBoton.mp3");
		    			texto.remove();
		    			fs1_1.show();
		    			texto = new Texto("�?: El pasaporte y el\n"
		    							+ "equipaje, por favor.", 7, 154);
		    			mainStage.addActor(texto);
		    			
		    			contador++;
		    			
		            } else if (contador==2) {
		            	
		            	AudioManager.playSound("01-FS/Audio/sounds/menuBoton.mp3");
		    			texto.remove();
		    			texto = new Texto("(Comprobar� las reglas\n"
		    							+ "y decidir� qu� hacer)", 7, 154);
		    			mainStage.addActor(texto);
		        		AudioManager.playSound("01-FS/Audio/sounds/maletin.mp3");
		    			maletin.show();
		    			pasaporte1 = new Objeto(10, 30, 60, 83, "pasaporte.1_1.png", "papeles.mp3");
		    			mainStage.addActor(pasaporte1);
		    			
		    			contador++;
		    			
		    			pistola = new Objeto(108, 26, 48, 28, "objeto.pistola.png", "pistola.mp3");
		    			mainStage.addActor(pistola);
		    			
		    			reloj.start();
		
		    			
		            } else if (contador==3) {
		            	
		            	AudioManager.playSound("01-FS/Audio/sounds/menuBoton.mp3");
		    			texto.remove();
		    			Parametros.controlesActivos=true;
		    			contador=0;
		    			Parametros.analizar=true;
		    			
		            } else if (Parametros.analizado1==true) {
		
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
		    			Parametros.analizado1=false;
		    			contador=4;
		    			
		            } else if (contador==4) {
		            	
		            	AudioManager.playSound("01-FS/Audio/sounds/menuBoton.mp3");
		    			texto.remove();
		        		texto = new Texto("�?: Que pase el\n"
										+ "siguiente, gracias.", 7, 154);
		        		mainStage.addActor(texto);
		        		contador++;
		    			
			        } else if (contador==5) {
		            	
			        	AudioManager.playSound("01-FS/Audio/sounds/menuBoton.mp3");
						texto.remove();
		    			fs1_2.show();
		    			texto = new Texto("�?: El pasaporte y el\n"
		    							+ "equipaje sobre la mesa.", 7, 154);
		    			mainStage.addActor(texto);
		    			
		    			contador++;
		    			
		            } else if (contador==6) {
		            	
		            	AudioManager.playSound("01-FS/Audio/sounds/menuBoton.mp3");
		    			texto.remove();
		    			texto = new Texto("(Puedo... Debo hacer\n"
		    							+ "esto bien...)", 7, 154);
		    			mainStage.addActor(texto);
		        		AudioManager.playSound("01-FS/Audio/sounds/maletin.mp3");
		    			maletin.show();
		
		    			pasaporte2 = new Objeto(10, 30, 60, 83, "pasaporte.1_2.png", "papeles.mp3");
		    			mainStage.addActor(pasaporte2);
		    			
		    			botella = new Objeto(76, 26, 36, 43, "objeto.botella.png", "botella.mp3");
		    			mainStage.addActor(botella);
		    			
		    			contador++;
		    			
			        } else if (contador==7) {
			        	
			        	AudioManager.playSound("01-FS/Audio/sounds/menuBoton.mp3");
						texto.remove();
						Parametros.controlesActivos=true;
						contador=0;
						Parametros.analizar=true;
						
			        } else if (Parametros.analizado2==true) {
		
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
						Parametros.analizado2=false;
						contador=8;
						
		            } else if (contador==8) {
		            	
		            	AudioManager.playSound("01-FS/Audio/sounds/menuBoton.mp3");
		    			texto.remove();
		        		texto = new Texto("Siguiente por aqu�,\n"
										+ "si es tan amable.", 7, 154);
		        		mainStage.addActor(texto);
		        		contador++;
		           
		        	} else if (contador==9) {
		        	
		        		AudioManager.playSound("01-FS/Audio/sounds/menuBoton.mp3");
		    			texto.remove();
						fs1_3.show();
						texto = new Texto("Pasaporte y equipaje,\n"
										+ "sobre la mesa.", 7, 154);
						mainStage.addActor(texto);
						
						contador++;
						
		            } else if (contador==10) {
		            	
		            	AudioManager.playSound("01-FS/Audio/sounds/menuBoton.mp3");
		    			texto.remove();
		    			texto = new Texto("(Recuerda por qui�n\n"
		    							+ "est�s aqu�...)", 7, 154);
		    			mainStage.addActor(texto);
		        		AudioManager.playSound("01-FS/Audio/sounds/maletin.mp3");
		    			maletin.show();
		
		    			pasaporte3 = new Objeto(10, 30, 60, 83, "pasaporte.1_3.png", "papeles.mp3");
		    			mainStage.addActor(pasaporte3);
		
		    			cuchillo = new Objeto(125, 32, 30, 38, "objeto.cuchillo.png", "pistola.mp3");
		    			mainStage.addActor(cuchillo);
		    			botella = new Objeto(76, 26, 36, 43, "objeto.botella.png", "botella.mp3");
		    			mainStage.addActor(botella);
		    			
		    			contador++;
			        } else if (contador==11) {
			        	
			        	AudioManager.playSound("01-FS/Audio/sounds/menuBoton.mp3");
						texto.remove();
						Parametros.controlesActivos=true;
						contador=0;
						Parametros.analizar=true;
						
			        } else if (Parametros.analizado3==true) {
			        	
			        	AudioManager.playSound("01-FS/Audio/sounds/menuBoton.mp3");
						Parametros.controlesActivos=false;
						texto = new Texto("LLAMAR AL SIGUIENTE\n"
										+ "(Pulsa CLICK)", 10, 154);
		        		mainStage.addActor(texto);
		            	fs1_3.fadeOut();
			        	pasaporte3.remove();
			        	maletin.hide();
			        	botella.remove();
			        	cuchillo.remove();
			        	FS1_3.texto.remove();
						Parametros.analizar=false;
						Parametros.analizado3=false;
						contador=12;
						
		            } else if (contador==12) {
		            	
		            	AudioManager.playSound("01-FS/Audio/sounds/menuBoton.mp3");
		    			texto.remove();
		        		texto = new Texto("�?: Por aqu� si es\n"
										+ "tan amable, se�orita.", 7, 154);
		        		mainStage.addActor(texto);
		        		contador++;
		           
		        	} else if (contador==13) {
		        	
		        		AudioManager.playSound("01-FS/Audio/sounds/menuBoton.mp3");
		    			texto.remove();
						fs1_4.show();
						texto = new Texto("�?: Pasaporte y objetos\n"
										+ "sobre la mesa, gracias.", 7, 154);
						mainStage.addActor(texto);
						
						contador++;
						
		            } else if (contador==14) {
		            	
		            	AudioManager.playSound("01-FS/Audio/sounds/menuBoton.mp3");
		    			texto.remove();
		    			texto = new Texto("(No puedo dejar que\n"
		    							+ "el miedo me supere...)", 7, 154);
		    			mainStage.addActor(texto);
		        		AudioManager.playSound("01-FS/Audio/sounds/maletin.mp3");
		    			maletin.show();
		
		    			pasaporte4 = new Objeto(10, 30, 60, 83, "pasaporte.1_4.png", "papeles.mp3");
		    			mainStage.addActor(pasaporte4);
		
		    			pintalabios = new Objeto(130, 30, 22, 32, "objeto.pintalabios.png", "pistola.mp3");
		    			mainStage.addActor(pintalabios);
		    			carta = new Objeto(78, 30, 50, 31, "objeto.carta.png", "papeles.mp3");
		    			mainStage.addActor(carta);
		    			
		    			contador++;
			        } else if (contador==15) {
			        	
			        	AudioManager.playSound("01-FS/Audio/sounds/menuBoton.mp3");
						texto.remove();
						Parametros.controlesActivos=true;
						contador=0;
						Parametros.analizar=true;
						
			        } else if (Parametros.analizado4==true && Parametros.correcto==true) {
			        	
			        	AudioManager.playSound("01-FS/Audio/sounds/menuBoton.mp3");
			        	FS1_4.texto.remove();
						Parametros.controlesActivos=false;
			        	
			        	texto = new Texto("por favor, lleva esta.\n"
	        							+ "carta a mi marido...", 7, 154);
			        	mainStage.addActor(texto);
			        	
			        	contador=16;
			        	
						Parametros.analizar=false;
						Parametros.analizado4=false;
						Parametros.correcto=false;
						
			        } else if (contador==16) {
			        	
			        	AudioManager.playSound("01-FS/Audio/sounds/menuBoton.mp3");
			        	
			        	texto = new Texto("Es un hombre italiano\n"
			        					+ "de buen vestir, estoy", 7, 154);
			        	mainStage.addActor(texto);
			        	
			        	contador++;
						
			        } else if (contador==17) {
			        	
			        	AudioManager.playSound("01-FS/Audio/sounds/menuBoton.mp3");
			        	
			        	texto = new Texto("segura de que podr�s\n"
			        					+ "encontrarlo...", 7, 154);
			        	mainStage.addActor(texto);
			        	
			        	contador++;
			        	
			        } else if (contador==18) {
			        	
			        	AudioManager.playSound("01-FS/Audio/sounds/menuBoton.mp3");
			        	
			        	texto = new Texto("Desiree: Much�simas\n"
			        					+ "gracias...", 7, 154);
			        	mainStage.addActor(texto);
			        	
			        	contador++;
			        	
			        	
			        } else if (Parametros.analizado4==true && Parametros.correcto==false || contador==19) {
			        	
			        	AudioManager.playSound("01-FS/Audio/sounds/menuBoton.mp3");
		        		texto = new Texto("�?: ...\n"
		        						+ "(Seguir� ma�ana...)", 7, 154);
		        		mainStage.addActor(texto);
		            	fs1_4.fadeOut();
			        	pasaporte4.remove();
			        	maletin.hide();
			        	pintalabios.remove();
			        	if(contador != 19) {carta.remove();}
						Parametros.analizar=false;
						Parametros.analizado4=false;	
						contador=0;
						
						terminado = true;
						
			        } else if (terminado==true) {
			        	AudioManager.playSound("01-FS/Audio/sounds/menuBoton.mp3");
						Parametros.dia++;
						game.setScreen(new StatsScreen(game));
					    musica.stop();
					    musica2.stop();
			        }
		        	
		        }
		        	break;
        	
	        case 2:

		        if (button == Input.Buttons.LEFT && Parametros.quitarTexto==true) {
		        	
		        	if(contador==1) {
		            	
		        		AudioManager.playSound("01-FS/Audio/sounds/menuBoton.mp3");
		    			texto.remove();
		    			fs2_1.show();
		    			texto = new Texto("�?: Su pasaporte y\n"
		    							+ "sus pertenencias.", 7, 154);
		    			mainStage.addActor(texto);
		    			
		    			contador++;
		    			
		            } else if (contador==2) {
		            	
		            	AudioManager.playSound("01-FS/Audio/sounds/menuBoton.mp3");
		    			texto.remove();
		    			texto = new Texto("(Estoy agotado... Pero\n"
		    							+ "no debo detenerme...)", 7, 154);
		    			reloj.start();
		    			mainStage.addActor(texto);
		        		AudioManager.playSound("01-FS/Audio/sounds/maletin.mp3");
		    			maletin.show();
		    			pasaporte1 = new Objeto(10, 30, 60, 83, "pasaporte.2_1.png", "papeles.mp3");
		    			mainStage.addActor(pasaporte1);
		    			
		    			contador++;
		    			
		    			pistola = new Objeto(92, 33, 37, 23, "objeto.pistola.png", "pistola.mp3");
		    			sombrero = new Objeto(85, 31, 70, 40, "objeto.sombrero.png", "pistola.mp3");
		    			
		    			mainStage.addActor(pistola);
		    			mainStage.addActor(sombrero);
		    			
		            } else if (contador==3) {
		            	
		            	AudioManager.playSound("01-FS/Audio/sounds/menuBoton.mp3");
		    			texto.remove();
		    			Parametros.controlesActivos=true;
		    			Parametros.analizar=true;
		    			contador=0;
		    			
		            } else if (Parametros.analizado1==true) {
		        		
		            	Parametros.controlesActivos=false;
		            	AudioManager.playSound("01-FS/Audio/sounds/menuBoton.mp3");
		    			texto = new Texto("LLAMAR AL SIGUIENTE\n"
		        						+ "(Pulsa CLICK)", 10, 154);
		        		mainStage.addActor(texto);
		            	fs2_1.fadeOut();
		            	pasaporte1.remove();
		            	maletin.hide();
		            	pistola.remove();
		            	sombrero.remove();
		            	FS2_1.texto.remove();
		    			Parametros.analizar=false;
		    			Parametros.analizado1=false;
		    			contador=4;
		    			
		            } else if (contador==4) {
		            	
		            	AudioManager.playSound("01-FS/Audio/sounds/menuBoton.mp3");
		    			texto.remove();
		        		texto = new Texto("�?: Siguiente, por\n"
										+ "favor....", 7, 154);
		        		mainStage.addActor(texto);
		        		contador++;
		        		
			        } else if (contador==5) {
		            	
			        	AudioManager.playSound("01-FS/Audio/sounds/menuBoton.mp3");
						texto.remove();
		    			fs2_2.show();
		    			texto = new Texto("�?: Si es tan amable, su\n"
		    							+ "pasaporte y equipaje.", 7, 154);
		    			mainStage.addActor(texto);
		    			
		    			contador++;
		    			
		            } else if (contador==6) {
		            	
		            	AudioManager.playSound("01-FS/Audio/sounds/menuBoton.mp3");
		    			texto.remove();
		    			texto = new Texto("(No puedo quit�rmelo\n"
		    							+ "de la cabeza...)", 7, 154);
		    			mainStage.addActor(texto);
		        		AudioManager.playSound("01-FS/Audio/sounds/maletin.mp3");
		    			maletin.show();
		
		    			pasaporte2 = new Objeto(10, 30, 60, 83, "pasaporte.2_2.png", "papeles.mp3");
		    			mainStage.addActor(pasaporte2);
		    			
		    			sopa = new Objeto(84, 28, 26, 30, "objeto.sopa.png", "botella.mp3");
		    			mainStage.addActor(sopa);
		    			hucha = new Objeto(111, 32, 50, 41, "objeto.hucha.png", "hucha.mp3");
		    			mainStage.addActor(hucha);
		    			
		    			contador++;
		    			
			        } else if (contador==7) {
			        	
			        	AudioManager.playSound("01-FS/Audio/sounds/menuBoton.mp3");
						texto.remove();
						Parametros.controlesActivos=true;
						contador=0;
						Parametros.analizar=true;
						
			        } else if (Parametros.analizado2==true) {
		
			        	AudioManager.playSound("01-FS/Audio/sounds/menuBoton.mp3");
						texto = new Texto("LLAMAR AL SIGUIENTE\n"
		        						+ "(Pulsa CLICK)", 10, 154);
		        		mainStage.addActor(texto);
		    			Parametros.controlesActivos=false;
		            	fs2_2.fadeOut();
			        	pasaporte2.remove();
			        	maletin.hide();
			        	hucha.remove();
			        	sopa.remove();
			        	FS2_2.texto.remove();
						Parametros.analizar=false;
						Parametros.analizado2=false;
						contador=8;
						
		            } else if (contador==8) {
		            	
		            	AudioManager.playSound("01-FS/Audio/sounds/menuBoton.mp3");
		    			texto.remove();
		        		texto = new Texto("�?: �Usted es el si-\n"
										+ "guiente? Pase por aqu�.", 7, 154);
		        		mainStage.addActor(texto);
		        		contador++;
		           
		        	} else if (contador==9) {
		        	
		        		AudioManager.playSound("01-FS/Audio/sounds/menuBoton.mp3");
		    			texto.remove();
						fs2_3.show();
						texto = new Texto("�?: Su pasaporte y sus\n"
										+ "bienes sobre la mesa.", 7, 154);
						mainStage.addActor(texto);
						
						contador++;
						
		            } else if (contador==10) {
		            	
		            	AudioManager.playSound("01-FS/Audio/sounds/menuBoton.mp3");
		    			texto.remove();
		    			texto = new Texto("(Cada segundo, esto\n"
		    							+ "solo empeora...)", 7, 154);
		    			mainStage.addActor(texto);
		        		AudioManager.playSound("01-FS/Audio/sounds/maletin.mp3");
		    			maletin.show();
		
		    			pasaporte3 = new Objeto(10, 30, 60, 83, "pasaporte.2_3.png", "papeles.mp3");
		    			mainStage.addActor(pasaporte3);
		
		    			platano = new Objeto(119, 29, 34, 36, "objeto.platano.png", "pistola.mp3");
		    			mainStage.addActor(platano);
		    			cuchillo = new Objeto(85, 32, 30, 38, "objeto.cuchillo.png", "pistola.mp3");
		    			mainStage.addActor(cuchillo);
		    			
		    			contador++;
			        } else if (contador==11) {
			        	
			        	AudioManager.playSound("01-FS/Audio/sounds/menuBoton.mp3");
						texto.remove();
						Parametros.controlesActivos=true;
						contador=0;
						Parametros.analizar=true;
						
			        } else if (Parametros.analizado3==true) {
			        	
			        	AudioManager.playSound("01-FS/Audio/sounds/menuBoton.mp3");
						Parametros.controlesActivos=false;
						texto = new Texto("LLAMAR AL SIGUIENTE\n"
										+ "(Pulsa CLICK)", 10, 154);
		        		mainStage.addActor(texto);
		            	fs2_3.fadeOut();
			        	pasaporte3.remove();
			        	maletin.hide();
			        	platano.remove();
			        	cuchillo.remove();
			        	FS2_3.texto.remove();
						Parametros.analizar=false;
						Parametros.analizado3=false;
						contador=12;
						
		            } else if (contador==12) {
		            	
		            	AudioManager.playSound("01-FS/Audio/sounds/menuBoton.mp3");
		    			texto.remove();
		        		texto = new Texto("�?: Si... Siguiente,\n"
										+ "por aqu�.", 7, 154);
		        		mainStage.addActor(texto);
		        		contador++;
		           
		        	} else if (contador==13) {
		        	
		        		AudioManager.playSound("01-FS/Audio/sounds/menuBoton.mp3");
		    			texto.remove();
						fs2_4.show();
		        		texto = new Texto("�?: E... Equipaje y...\n"
										+ "Pasaporte, por favor.", 7, 154);
						mainStage.addActor(texto);
						
						contador++;
						
		            } else if (contador==14) {
		            	
		            	AudioManager.playSound("01-FS/Audio/sounds/menuBoton.mp3");
		    			texto.remove();
		    			texto = new Texto("(Esta chica... Me\n"
		    							+ "resulta familiar...)", 7, 154);
		    			mainStage.addActor(texto);
		        		AudioManager.playSound("01-FS/Audio/sounds/maletin.mp3");
		    			maletin.show();
		
		    			pasaporte4 = new Objeto(10, 30, 60, 83, "pasaporte.2_4.png", "papeles.mp3");
		    			mainStage.addActor(pasaporte4);
		
		    			sopa = new Objeto(84, 28, 26, 30, "objeto.sopa.png", "botella.mp3");
		    			mainStage.addActor(sopa);
		    			botella = new Objeto(113, 28, 36, 43, "objeto.botella.png", "botella.mp3");
		    			mainStage.addActor(botella);
		    			
		    			contador++;
			        } else if (contador==15) {
			        	
			        	AudioManager.playSound("01-FS/Audio/sounds/menuBoton.mp3");
						texto.remove();
						Parametros.controlesActivos=true;
						contador=0;
						Parametros.analizar=true;
						
			        } else if (Parametros.analizado4==true) {
					    musica.stop();
			        	
			        	AudioManager.playSound("01-FS/Audio/sounds/menuBoton.mp3");
			        	FS2_4.texto.remove();
						Parametros.controlesActivos=false;
		            	fs2_4.fadeOut();
			        	
			        	texto = new Texto("(La chica ha salido\n"
	        							+ "corriendo con una ", 7, 154);
			        	mainStage.addActor(texto);
			        	
			        	contador=16;
			        	
						Parametros.analizar=false;
						Parametros.analizado4=false;
						Parametros.correcto=false;
						
			        } else if (contador==16) {
			        	
			        	AudioManager.playSound("01-FS/Audio/sounds/menuBoton.mp3");
			        	
			        	texto = new Texto("expresi�n terrible en\n"
			        					+ "su rostro...)", 7, 154);
			        	mainStage.addActor(texto);
			        	
			        	contador++;
						
			        } else if (contador==17) {
			        	
			        	AudioManager.playSound("01-FS/Audio/sounds/menuBoton.mp3");
	
			    		mainStage.addActor(blackBackgroundActor);
			    		blackBackgroundActor.setSize(240,180);
			    		
			        	texto = new Texto("(No s� qu� est� su-\n"
										+ "cediendo... Pero", 7, 154);
			    		
			        	mainStage.addActor(texto);
			        	
			        	contador++;
			        	
			        } else if (contador==18) {
			        	
			        	AudioManager.playSound("01-FS/Audio/sounds/menuBoton.mp3");
			        	
			        	texto = new Texto("debo averiguar qu�\n"
			        					+ "se esconde detr�s ", 7, 154);
			        	mainStage.addActor(texto);
			        	
			        	contador++;
			        	
			        	
			        } else if (Parametros.analizado4==true && Parametros.correcto==false || contador==19) {
			        	
			        	AudioManager.playSound("01-FS/Audio/sounds/menuBoton.mp3");
		        		texto = new Texto("de todo esto... Cues-\n"
		        						+ "te lo que cueste...)", 7, 154);
		        		mainStage.addActor(texto);
			        	pasaporte4.remove();
			        	maletin.hide();
			        	sopa.remove();
			        	botella.remove();
						Parametros.analizar=false;
						Parametros.analizado4=false;	
						contador=0;
						
						terminado = true;
						
			        } else if (terminado==true) {
			        	AudioManager.playSound("01-FS/Audio/sounds/menuBoton.mp3");
						Parametros.dia++;
						game.setScreen(new StatsScreen(game));
					    musica2.stop();
			        }
		        }
		        
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
			Parametros.dia++;	
			contador=0;
			game.setScreen(new StatsScreen(game));
		    musica.stop();
		    musica2.stop();
	    }
	    
	}
}
