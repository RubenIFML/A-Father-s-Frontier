package ow_elements;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Actor;

import game.Parametros;
import managers.ResourceManager;

public class Tareas extends Actor {

    private BitmapFont font;
    public static float tiempoRestante = 300;
    private String titulo;
    private String lista = "";
    private Texture tareas;
    
    private String[] tareasStrings = {"He de comer algo.",
                                      "He de pagar mis deudas.",
                                      "Un extraño muñeco.",
                                      "El tesoro perdido.",
                                      "El viejo general.",
                                      "Lettera d'amore.",
                                      "Buen chico.",
                                      "Malas vistas.",
                                      "Elemental, querido Simon.",
                                      "Magia blanca.",
                                      "Un glamuroso collar.",
                                      "Caos en la ciudad.",
                                      };
    
    private static boolean[] tareasBoolean = {Parametros.haComidoHoy,
                                              Parametros.haPagadoDeuda,
                                              Parametros.mision_un_extrano_muneco,
                                              Parametros.mision_el_tesoro_perdido,
                                              Parametros.mision_el_viejo_general,
                                              Parametros.mision_una_lettera_d_amore,
                                              Parametros.mision_buen_chico,
                                              Parametros.mision_malas_vistas,
                                              Parametros.mision_elemental_mi_querido_simon,
                                              Parametros.mision_magia_blanca,
                                              Parametros.mision_un_glamuroso_collar,
                                              Parametros.mision_caos_en_la_ciudad,
                                              };

    public Tareas() {
        // Cargar la fuente desde el archivo Peepo.ttf
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("Peepo.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 17; // Tamaño de la fuente
        this.font = generator.generateFont(parameter);
        generator.dispose();
        
        // Configurar el resto de los atributos
        this.titulo = "- LISTA DE TAREAS -";
        setBounds(10, 300, 232, 290);
        this.tareas = ResourceManager.getTexture("Menu/listaTareas.png");
        
        // Actualizar la lista con las tareas que estén en true
        actualizarLista();
    }
    
    private void actualizarLista() {
        lista = "";
        boolean hayMisiones = false;
        for (int i = 0; i < tareasBoolean.length; i++) {
            if (tareasBoolean[i] == false) {
                lista += tareasStrings[i] + "\n";
                hayMisiones = true;
            }
        }
        if (!hayMisiones) {
            lista = "No tiene más misiones...";
        }
    }

    public void act(float delta) {
        super.act(delta);
        // Actualizar la lista si hay cambios en las tareas
        for (int i = 0; i < tareasBoolean.length; i++) {
            boolean tareaActual = tareasBoolean[i];
            tareasBoolean[i] = obtenerValorBooleano(i);
            if (tareasBoolean[i] != tareaActual) {
                actualizarLista();
                break;
            }
        }
    }
    
    private boolean obtenerValorBooleano(int indice) {
        boolean valor = true ;
        switch (indice) {
            case 0: valor = Parametros.haComidoHoy; break;
            case 1: valor = Parametros.haPagadoDeuda; break;
            case 2: valor = Parametros.mision_un_extrano_muneco; break;
            case 3: valor = Parametros.mision_el_tesoro_perdido; break;
            case 4: valor = Parametros.mision_el_viejo_general; break;
            case 5: valor = Parametros.mision_una_lettera_d_amore; break;
            case 6: valor = Parametros.mision_buen_chico; break;
            case 7: valor = Parametros.mision_malas_vistas; break;
            case 8: valor = Parametros.mision_elemental_mi_querido_simon; break;
            case 9: valor = Parametros.mision_magia_blanca; break;
            case 10: valor = Parametros.mision_un_glamuroso_collar; break;
            case 11: valor = Parametros.mision_caos_en_la_ciudad; break;
            default: break;
        }
        return valor;
    }

    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.draw(tareas, getX(), getY(), getWidth(), getHeight());
        font.draw(batch, titulo, 43, 569);
        font.draw(batch, lista, 22, 527);
    }
} 