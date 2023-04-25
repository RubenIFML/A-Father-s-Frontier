package game;

public class Parametros {

 //Screen
 private static int anchoPantalla=800;
 private static int altoPantalla=600;
 public static float zoom=0.65f;
 public static int zona = 1;

 //Debug
 public static boolean debug=true;
 
 //Audio;
 public static float musicVolume = 1;
 public static float soundVolume = 1;
 
 //Estadísticas
 public static int dia = 1;
 public static int segundos = 100;
 public static int dineroAnterior = 0;
 public static int dinero = 1;
 public static boolean haComidoHoy = false;
 
 //Variables
 public static boolean frontera = false;
 public static boolean controlesActivos = true;
 public static boolean lockClick = false;
 public static boolean comienzo = false;
 public static boolean analizar = false;
 public static boolean analizado1 = false;
 public static boolean analizado2 = false;
 public static boolean analizado3 = false;
 public static boolean analizado4 = false;
 public static boolean correcto = false;
 public static boolean musicaUnaVez = true;
 
 //Misiones
 public static boolean mision_una_lettera_d_amore = false;
 public static boolean mision_un_encuentro_agridulce = false;
 public static boolean mision_dein_kampf = false;
 
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
