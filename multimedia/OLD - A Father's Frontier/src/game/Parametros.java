package game;

public class Parametros {

//Screen
 //private static int anchoPantalla=1200;
 //private static int altoPantalla=900;
 
 private static int anchoPantalla=800;
 private static int altoPantalla=600;
 
 public static boolean debug=true;
 
 //Audio;
 public static float musicVolume=1;
 public static float soundVolume=1;
 public static boolean controlesActivos = false;
 public static boolean quitarTexto = false;
 public static boolean analizar = false;
 public static boolean analizadoP1 = false;
 public static boolean analizadoP2 = false;
 public static boolean analizadoP3 = false;

public static boolean ganas = false;

// public static float zoom=0.24f;
 public static float zoom=0.30f;
 public static int segundos=100;

 
public static int getAnchoPantalla() {
	return anchoPantalla;
}

public static void setAnchoPantalla(int anchoPantalla) {
	Parametros.anchoPantalla = anchoPantalla;
}

public static int getAltoPantalla() {
	return altoPantalla;
}

public static void setAltoPantalla(int altoPantalla) {
	Parametros.altoPantalla = altoPantalla;
}

public static float getMusicVolume() {
	return musicVolume;
}

public static void setMusicVolume(float musicVolume) {
	Parametros.musicVolume = musicVolume;
}




 
}
