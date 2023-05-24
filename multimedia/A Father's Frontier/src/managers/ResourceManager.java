package managers;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.NinePatchDrawable;

public final class ResourceManager {
	private ResourceManager() {}
	public static AssetManager assets=new AssetManager();
	public static LabelStyle buttonStyle;
	public static TextButtonStyle textButtonStyle;
	public BitmapFont fuentePropia;
	public static Music musicaTitulo;
	public static Music tiktak;
	
	public static void loadAllResources(){
		
		//Mapas
		assets.setLoader(TiledMap.class, new TmxMapLoader());
		assets.load("Mapas/PapersBackground.tmx", TiledMap.class);
		assets.load("Mapas/OverWorld.tmx", TiledMap.class);
		assets.load("Mapas/CasaProtagonista.tmx", TiledMap.class);
		assets.load("Mapas/SuperUKMarket.tmx", TiledMap.class);
		assets.load("Mapas/CasaSur.tmx", TiledMap.class);
		assets.load("Mapas/Habitacion.tmx", TiledMap.class);
		
        //Men�
		assets.load("Menu/tsxB.png", Texture.class);
        assets.load("Menu/titleB.jpg", Texture.class);
        assets.load("Menu/titleTitle.png", Texture.class);
        assets.load("Menu/blackBackground.png", Texture.class);
        assets.load("Menu/menuBoton.png", Texture.class);
        assets.load("Menu/lluvia.png", Texture.class);
        assets.load("Menu/raindrop.png", Texture.class);
        assets.load("Menu/niebla.png", Texture.class);
        assets.load("Menu/periodico.0_0.png", Texture.class);
        assets.load("Menu/periodico.0_1.png", Texture.class);
        assets.load("Menu/periodico.1_0.png", Texture.class);
        assets.load("Menu/periodico.2_0.png", Texture.class);
        assets.load("Menu/periodico.3_0.png", Texture.class);
        assets.load("Menu/mapaEsquema.png", Texture.class);
        assets.load("Menu/dialogoOW.png", Texture.class);
        assets.load("Menu/listaTareas1.png", Texture.class);
        assets.load("Menu/controlesOw.png", Texture.class);
        assets.load("Menu/controlesFs.png", Texture.class);
        assets.load("Menu/controlesOw2.png", Texture.class);
        assets.load("Menu/controlesOw3.png", Texture.class);
        assets.load("Menu/controlesFs2.png", Texture.class);
        assets.load("Menu/controlesFs3.png", Texture.class);
        assets.load("Menu/advertencia.png", Texture.class);
        assets.load("Menu/final.png", Texture.class);
       
        //Pasaportes      
        assets.load("01-FS/Objetos/pasaporte.1_1.png", Texture.class);
        assets.load("01-FS/Objetos/pasaporte.1_2.png", Texture.class);
        assets.load("01-FS/Objetos/pasaporte.1_3.png", Texture.class);
        assets.load("01-FS/Objetos/pasaporte.1_4.png", Texture.class);
        assets.load("01-FS/Objetos/pasaporte.2_1.png", Texture.class);
        assets.load("01-FS/Objetos/pasaporte.2_2.png", Texture.class);
        assets.load("01-FS/Objetos/pasaporte.2_3.png", Texture.class);
        assets.load("01-FS/Objetos/pasaporte.2_4.png", Texture.class);
        assets.load("01-FS/Objetos/pasaporte.3_1.png", Texture.class);
        assets.load("01-FS/Objetos/pasaporte.3_2.png", Texture.class);
        assets.load("01-FS/Objetos/pasaporte.3_3.png", Texture.class);
        assets.load("01-FS/Objetos/pasaporte.3_4.png", Texture.class);
        
        //Reglas
        assets.load("01-FS/Objetos/reglas.1_0.png", Texture.class);
        assets.load("01-FS/Objetos/reglas.2_0.png", Texture.class);
        assets.load("01-FS/Objetos/reglas.2_1.png", Texture.class);
        assets.load("01-FS/Objetos/reglas.3_0.png", Texture.class);
        assets.load("01-FS/Objetos/reglas.3_1.png", Texture.class);
        assets.load("01-FS/Objetos/reglas.3_2.png", Texture.class);
        
        //Permisos
        assets.load("01-FS/Objetos/permiso.3_1.png", Texture.class);
        assets.load("01-FS/Objetos/permiso.3_2.png", Texture.class);
        assets.load("01-FS/Objetos/permiso.3_4.png", Texture.class);
        
        //Objetos est�ticos
        assets.load("01-FS/Objetos/botonRojo.png", Texture.class);
        assets.load("01-FS/Objetos/br_p.png", Texture.class);
        assets.load("01-FS/Objetos/botonVerde.png", Texture.class);
        assets.load("01-FS/Objetos/bv_p.png", Texture.class);
        assets.load("01-FS/Objetos/mesa.png", Texture.class);
        assets.load("01-FS/Objetos/maletin.png", Texture.class);
        
        //Objetos FS
        assets.load("01-FS/Objetos/objeto.pistola.png", Texture.class);
        assets.load("01-FS/Objetos/objeto.botella.png", Texture.class);
        assets.load("01-FS/Objetos/objeto.carta.png", Texture.class);
        assets.load("01-FS/Objetos/objeto.cuchillo.png", Texture.class);
        assets.load("01-FS/Objetos/objeto.cuchillo.png", Texture.class);
        assets.load("01-FS/Objetos/objeto.duxer.png", Texture.class);
        assets.load("01-FS/Objetos/objeto.hucha.png", Texture.class);
        assets.load("01-FS/Objetos/objeto.llave.png", Texture.class);
        assets.load("01-FS/Objetos/objeto.pintalabios.png", Texture.class);
        assets.load("01-FS/Objetos/objeto.platano.png", Texture.class);
        assets.load("01-FS/Objetos/objeto.sombrero.png", Texture.class);
        assets.load("01-FS/Objetos/objeto.sopa.png", Texture.class);
        
        //Objetos OW
        assets.load("02-OW/Objetos/objeto.bolsa.png", Texture.class);
        assets.load("02-OW/Objetos/objeto.carta.png", Texture.class);
        assets.load("02-OW/Objetos/objeto.collar.png", Texture.class);
        assets.load("02-OW/Objetos/objeto.gafas.png", Texture.class);
        assets.load("02-OW/Objetos/objeto.hueso.png", Texture.class);
        assets.load("02-OW/Objetos/objeto.libra.png", Texture.class);
        assets.load("02-OW/Objetos/objeto.libro.png", Texture.class);
        assets.load("02-OW/Objetos/objeto.manzana.png", Texture.class);
        assets.load("02-OW/Objetos/objeto.peluche.png", Texture.class);
        
        //Personajes FS
        assets.load("01-FS/Personajes/FS.1_1.png", Texture.class);
        assets.load("01-FS/Personajes/FS.1_2.png", Texture.class);
        assets.load("01-FS/Personajes/FS.1_3.png", Texture.class);
        assets.load("01-FS/Personajes/FS.1_4.png", Texture.class);
        assets.load("01-FS/Personajes/FS.2_1.png", Texture.class);
        assets.load("01-FS/Personajes/FS.2_2.png", Texture.class);
        assets.load("01-FS/Personajes/FS.2_3.png", Texture.class);
        assets.load("01-FS/Personajes/FS.2_4.png", Texture.class);
        assets.load("01-FS/Personajes/FS.3_1.png", Texture.class);
        assets.load("01-FS/Personajes/FS.3_2.png", Texture.class);
        assets.load("01-FS/Personajes/FS.3_3.png", Texture.class);
        assets.load("01-FS/Personajes/FS.3_4.png", Texture.class);
        
        //Personajes OW
        assets.load("02-OW/Personajes/b.png", Texture.class);
        assets.load("02-OW/Personajes/b_mision.png", Texture.class);
        assets.load("02-OW/Personajes/b_mail.png", Texture.class);
        assets.load("02-OW/Personajes/b_objeto.png", Texture.class);
        assets.load("02-OW/Personajes/p.prota.png", Texture.class);
        assets.load("02-OW/Personajes/p.ahorcado.png", Texture.class);
        assets.load("02-OW/Personajes/p.chica.png", Texture.class);
        assets.load("02-OW/Personajes/p.chica1.png", Texture.class);
        assets.load("02-OW/Personajes/p.dependiente.png", Texture.class);
        assets.load("02-OW/Personajes/p.detective.png", Texture.class);
        assets.load("02-OW/Personajes/p.evans.png", Texture.class);
        assets.load("02-OW/Personajes/p.extra.png", Texture.class);
        assets.load("02-OW/Personajes/p.extra1.png", Texture.class);
        assets.load("02-OW/Personajes/p.extra2.png", Texture.class);
        assets.load("02-OW/Personajes/p.extra3.png", Texture.class);
        assets.load("02-OW/Personajes/p.extra4.png", Texture.class);
        assets.load("02-OW/Personajes/p.extra5.png", Texture.class);
        assets.load("02-OW/Personajes/p.extra6.png", Texture.class);
        assets.load("02-OW/Personajes/p.extra7.png", Texture.class);
        assets.load("02-OW/Personajes/p.extra8.png", Texture.class);
        assets.load("02-OW/Personajes/p.extra9.png", Texture.class);
        assets.load("02-OW/Personajes/p.extra10.png", Texture.class);
        assets.load("02-OW/Personajes/p.extra11.png", Texture.class);
        assets.load("02-OW/Personajes/p.extra12.png", Texture.class);
        assets.load("02-OW/Personajes/p.herido.png", Texture.class);
        assets.load("02-OW/Personajes/p.perro.png", Texture.class);
        assets.load("02-OW/Personajes/p.policia.png", Texture.class);
        assets.load("02-OW/Personajes/p.final.prota.png", Texture.class);
        assets.load("02-OW/Personajes/p_sil.png", Texture.class);
        assets.load("02-OW/Personajes/p.recuerdos.png", Texture.class);
        assets.load("02-OW/Personajes/p.viejo.png", Texture.class);
        assets.load("02-OW/Personajes/p.viejo1.png", Texture.class);
        assets.load("02-OW/Personajes/p.final1.png", Texture.class);
        assets.load("02-OW/Personajes/p.final2.png", Texture.class);
        assets.load("02-OW/Personajes/p.final3.png", Texture.class);
        assets.load("02-OW/Personajes/p.recuerdos1.png", Texture.class);
        assets.load("02-OW/Personajes/recuerdos2.png", Texture.class);
        assets.load("02-OW/Personajes/recuerdos3.png", Texture.class);
        
        //Tiles
        assets.load("02-OW/Tiles/tree.png", Texture.class);
        assets.load("02-OW/Tiles/farolaA.png", Texture.class);
        assets.load("02-OW/Tiles/farolaB.png", Texture.class);
        assets.load("02-OW/Tiles/telephoneBox.png", Texture.class);
        assets.load("02-OW/Tiles/semaforo.png", Texture.class);
        assets.load("02-OW/Tiles/cedaSign.png", Texture.class);
        assets.load("02-OW/Tiles/treintaSign.png", Texture.class);
        assets.load("02-OW/Tiles/fuente.png", Texture.class);
        assets.load("02-OW/Tiles/coche.png", Texture.class);
        assets.load("02-OW/Tiles/mailBox.png", Texture.class);
        assets.load("02-OW/Tiles/cajaReg_2.png", Texture.class);
        assets.load("02-OW/Tiles/cajaReg_3.png", Texture.class);
        assets.load("02-OW/Tiles/cajaReg_4.png", Texture.class);
        
        //Sonidos
        assets.load("01-FS/Audio/sounds/boton.wav", Sound.class);
        assets.load("01-FS/Audio/sounds/correcto.wav", Sound.class);
        assets.load("01-FS/Audio/sounds/incorrecto.wav", Sound.class);
        assets.load("01-FS/Audio/sounds/boton.wav", Sound.class);
        assets.load("01-FS/Audio/sounds/menuBoton.wav", Sound.class);
        assets.load("01-FS/Audio/sounds/papeles.wav", Sound.class);
        assets.load("01-FS/Audio/sounds/botella.wav", Sound.class);
        assets.load("01-FS/Audio/sounds/pistola.wav", Sound.class);
        assets.load("01-FS/Audio/sounds/hucha.wav", Sound.class);
        assets.load("01-FS/Audio/sounds/sombrero.wav", Sound.class);
        assets.load("01-FS/Audio/sounds/lata.wav", Sound.class);
        assets.load("01-FS/Audio/sounds/banana.wav", Sound.class);
        assets.load("01-FS/Audio/sounds/duxer.wav", Sound.class);
        assets.load("01-FS/Audio/sounds/llaves.wav", Sound.class);
        assets.load("01-FS/Audio/sounds/maletin.wav", Sound.class);
        assets.load("01-FS/Audio/sounds/tension.wav", Sound.class);
        assets.load("02-OW/Audio/sounds/pasos.wav", Sound.class);
        assets.load("02-OW/Audio/sounds/comprar.wav", Sound.class);
        assets.load("02-OW/Audio/sounds/mision.wav", Sound.class);
        assets.load("02-OW/Audio/sounds/cerrarPuerta.wav", Sound.class);
        assets.load("02-OW/Audio/sounds/item.wav", Sound.class);
        assets.load("02-OW/Audio/sounds/talk1.wav", Sound.class);
        assets.load("02-OW/Audio/sounds/talk2.wav", Sound.class);
        assets.load("02-OW/Audio/sounds/respiracion.wav", Sound.class);
        assets.load("02-OW/Audio/sounds/grito.wav", Sound.class);
        assets.load("02-OW/Audio/sounds/disparo.wav", Sound.class);
        assets.load("02-OW/Audio/sounds/forzarPuerta.wav", Sound.class);
        assets.load("02-OW/Audio/sounds/romperPuerta.wav", Sound.class);
        assets.load("02-OW/Audio/sounds/apunalar.wav", Sound.class);
        assets.load("02-OW/Audio/sounds/muerte.wav", Sound.class);
        assets.load("02-OW/Audio/sounds/drama.wav", Sound.class);
        
        //M�sica
        assets.load("01-FS/Audio/music/frontera1.mp3", Music.class);
        assets.load("01-FS/Audio/music/frontera2.mp3", Music.class);
        assets.load("01-FS/Audio/music/frontera3.mp3", Music.class);
        assets.load("01-FS/Audio/music/final.mp3", Music.class);
        assets.load("01-FS/Audio/music/lluvia.mp3", Music.class);
        assets.load("01-FS/Audio/music/title.mp3", Music.class);
        assets.load("02-OW/Audio/music/ciudad_dia1.mp3", Music.class);
        assets.load("02-OW/Audio/music/ciudad_dia2.mp3", Music.class);
        assets.load("02-OW/Audio/music/ciudad_dia3.mp3", Music.class);
        assets.load("02-OW/Audio/music/ambiente.mp3", Music.class);
        assets.load("02-OW/Audio/music/tiktak.mp3", Sound.class);
        assets.load("02-OW/Audio/music/policia.mp3", Sound.class);
        assets.load("02-OW/Audio/music/lloros.mp3", Sound.class);
        assets.load("02-OW/Audio/music/risa.mp3", Sound.class);
        assets.load("02-OW/Audio/music/scary.mp3", Sound.class);
	}
	
	public static boolean update(){
		return assets.update();
	}
	public static void botones() {
		
		//estilo para botones
        FreeTypeFontGenerator ftfg= new FreeTypeFontGenerator(Gdx.files.internal("Peepo.ttf"));
		FreeTypeFontParameter ftfp= new FreeTypeFontParameter();
		
		ftfp.size=36;
		ftfp.color=Color.WHITE;
		ftfp.borderWidth=2;
		
		BitmapFont fuentePropia=ftfg.generateFont(ftfp);
		buttonStyle=new LabelStyle();
		buttonStyle.font=fuentePropia;
		textButtonStyle=new TextButtonStyle();
		Texture buttonText = ResourceManager.getTexture("Menu/menuBoton.png");
		NinePatch buttonPatch = new NinePatch(buttonText);
		textButtonStyle.up=new NinePatchDrawable(buttonPatch);
		textButtonStyle.font=fuentePropia;
		
		musicaTitulo = Gdx.audio.newMusic(Gdx.files.internal("01-FS/Audio/music/title.mp3"));
	    musicaTitulo.setVolume(0.5f);
		musicaTitulo.setLooping(true);

		tiktak = Gdx.audio.newMusic(Gdx.files.internal("02-OW/Audio/music/tiktak.mp3"));

	}
	
	/*public static TextureAtlas getAtlas(String path){
		return assets.get(path, TextureAtlas.class);
		
	}*/
	
	public static Texture getTexture(String path) {
		return assets.get(path, Texture.class);
	}
	
	public static Music getMusic(String path){
		return assets.get(path, Music.class);
	}

	public static Sound getSound(String path)
	{
		return assets.get(path, Sound.class);
	}
	
	public static TiledMap getMap(String path){
		return assets.get(path, TiledMap.class);
	}

	public static void dispose(){
		assets.dispose();
	}
}
