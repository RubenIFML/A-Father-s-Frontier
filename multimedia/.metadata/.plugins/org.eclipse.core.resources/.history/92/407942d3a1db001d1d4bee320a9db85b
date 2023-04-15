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
	
	public static void loadAllResources(){
		//mapas
		assets.setLoader(TiledMap.class, new TmxMapLoader());
		assets.load("maps/PapersBackground.tmx", TiledMap.class);
		
        //elementos de mapa
		assets.load("maps/images/PapersBackgraundTsx.png", Texture.class);
        assets.load("elements/maletin.png", Texture.class);
        assets.load("elements/menuBoton.png", Texture.class);
        assets.load("elements/pasaporte1.png", Texture.class);
        assets.load("elements/pasaporte2.png", Texture.class);
        assets.load("elements/pasaporte3.png", Texture.class);
        assets.load("elements/reglas.png", Texture.class);
        assets.load("elements/botonRojo.png", Texture.class);
        assets.load("elements/botonRojo_Pressed.png", Texture.class);
        assets.load("elements/botonVerde.png", Texture.class);
        assets.load("elements/botonVerde_Pressed.png", Texture.class);
        assets.load("elements/mesa.png", Texture.class);
        assets.load("elements/pistola.png", Texture.class);
        assets.load("elements/botella.png", Texture.class);
        assets.load("enemies/persona1.png", Texture.class);
        assets.load("enemies/persona2.png", Texture.class);
        assets.load("enemies/transparente.png", Texture.class);
        assets.load("maps/images/titleBackground.jpg", Texture.class);
        assets.load("maps/images/blackBackground.png", Texture.class);
        assets.load("maps/images/lluvia.png", Texture.class);
        
        //Audio
        assets.load("audio/sounds/boton.mp3", Sound.class);
        assets.load("audio/sounds/correcto.mp3", Sound.class);
        assets.load("audio/sounds/incorrecto.mp3", Sound.class);
        assets.load("audio/sounds/boton.mp3", Sound.class);
        assets.load("audio/sounds/menuBoton.mp3", Sound.class);
        assets.load("audio/sounds/papeles.mp3", Sound.class);
        assets.load("audio/sounds/botella.mp3", Sound.class);
        assets.load("audio/sounds/pistola.mp3", Sound.class);
        assets.load("audio/sounds/maletin.mp3", Sound.class);
        assets.load("audio/music/maletin_por_favor.mp3", Music.class);
        assets.load("audio/music/final.mp3", Music.class);
        assets.load("audio/music/lluvia.mp3", Music.class);
        assets.load("audio/music/title_theme.mp3", Music.class);
	
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
		Texture buttonText = ResourceManager.getTexture("elements/menuBoton.png");
		NinePatch buttonPatch = new NinePatch(buttonText);
		textButtonStyle.up=new NinePatchDrawable(buttonPatch);
		textButtonStyle.font=fuentePropia;
		
		musicaTitulo = Gdx.audio.newMusic(Gdx.files.internal("audio/music/title_theme.mp3"));
		musicaTitulo.play();
	    musicaTitulo.setVolume(0.5f);
		musicaTitulo.setLooping(true);
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
