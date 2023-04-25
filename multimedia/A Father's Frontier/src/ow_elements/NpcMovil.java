package ow_elements;

import com.badlogic.gdx.scenes.scene2d.Stage;

import screens.OverWorldScreen;

public class NpcMovil extends Element{
	
	private float velocidad;
	private int direccionMovimiento;
	private OverWorldScreen nivel;
	
	public NpcMovil(float x, float y, Stage s, OverWorldScreen nivel, String animacion) {
		super(x,y,s);
       
		this.nivel=nivel;
		prepararAnimacion(animacion, true);
		this.setPolygon(8, 32, 23, 5, 5);
		
		direccionMovimiento=-1;
        velocidad=70;
	}
	
	public void act(float delta) {
		super.act(delta);
		moveBy(direccionMovimiento*velocidad*delta,0);
		animaciones();
		comprobarColisiones();
	}
	
	private void comprobarColisiones() {
		for(Solid solido:this.nivel.solidos) {
			if(this.overlaps(solido)) {
				this.direccionMovimiento*=-1;
			}
		}
		if(this.nivel.prota.overlaps(this)) {
			this.nivel.prota.preventOverlap(this);
		}
	}
	
	private void animaciones() {
        if (direccionMovimiento>0) {
            this.setAnimation(this.derecha);
        }
        else if (direccionMovimiento<0){
            this.setAnimation(this.izquierda);
        }
	}
}