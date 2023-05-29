package ow_elements;

import com.badlogic.gdx.scenes.scene2d.Stage;

import screens.OverWorldScreen;

/**
 * Establece los NPC móviles, tanto sus direcciones, como sus velocidades entre otros.
 * @author Rubén Moya
 */
public class NpcMovil extends Element {
    private float velocidad;
    private float velocidadAnterior;
    private int direccionMovimiento;
    private OverWorldScreen nivel;
    private int direccion;
    private int animacionActual;

    public NpcMovil(float x, float y, Stage s, OverWorldScreen nivel, String animacion, int direccion, float velocidad) {
        super(x, y, s);
        
        this.velocidadAnterior = velocidad;
        this.velocidad = velocidad;
        this.direccion = direccion;
        this.nivel = nivel;
        prepararAnimacion(animacion, true);
        this.setPolygon(8, 32, 23, 5, 5);

        if (direccion == 1) {
            direccionMovimiento = -1;
        } else if (direccion == 2) {
            direccionMovimiento = 1;
        }

        this.animacionActual = direccion;
    }

	/**
	 * Controla la dirección, las colisiones y la animación.
	 */
    public void act(float delta) {
        super.act(delta);
        if (direccion == 1) {
            moveBy(direccionMovimiento * this.velocidad * delta, 0);
        } else if (direccion == 2) {
            moveBy(0, direccionMovimiento * this.velocidad * delta);
        }
        animaciones();
        comprobarColisiones();
    }

	/**
	 * Comprueba las colisiones del NpcMovil con el protagonista.
	 * En el caso de que el protagonista esté tocando al NpcMovil,
	 * el NpcMovil parará su marcha en seco.
	 */
    private void comprobarColisiones() {
        for (Solid solido : this.nivel.solidos) {
            if (this.overlaps(solido)) {
                if (direccion == 1) {
                    this.direccionMovimiento *= -1;
                } else if (direccion == 2) {
                    this.direccionMovimiento *= -1;
                }
            }
        }
        if (this.nivel.prota.overlaps(this)) {
            this.velocidad = 0;
            this.nivel.prota.preventOverlap(this);
        } else {
            this.velocidad = this.velocidadAnterior;
        }
    }

	/**
	 * Establece la animación de caminar del NpcMovil.
	 */
    private void animaciones() {
        if (direccionMovimiento > 0) {
            if (direccion == 1) {
                this.setAnimation(this.derecha);
                animacionActual = 3;
            } else if (direccion == 2) {
                this.setAnimation(this.espalda);
                animacionActual = 2;
            }
        } else if (direccionMovimiento < 0) {
            if (direccion == 1) {
                this.setAnimation(this.izquierda);
                animacionActual = 1;
            } else if (direccion == 2) {
                this.setAnimation(this.frente);
                animacionActual = 4;
            }
        }

        if (velocidad == 0) {
            if (animacionActual == 1) {
                this.setAnimation(this.getIdleIzquierda());
            } else if (animacionActual == 2) {
                this.setAnimation(this.idleEspaldas);
            } else if (animacionActual == 3) {
                this.setAnimation(this.idleDerecha);
            } else if (animacionActual == 4) {
                this.setAnimation(this.idleFrente);
            }
        }
    }
}
