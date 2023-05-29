package ow_elements;

import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.scenes.scene2d.Stage;

/**
 * Crea los sólidos de la Ciudad.
 */
public class Solid extends Element{

	public Solid(float x, float y, Stage s, float w, float h) {
		super(x, y, s, w, h);
		// TODO Auto-generated constructor stub
		
		float[] vertices= {0,0,w,0,w,h,0,h};
		colision=new Polygon(vertices);
		this.setSize(w, h);
	}
	
	public Solid(float x, float y, Stage s, Polygon poli) {
		super(x,y,s);
		this.colision=poli;
		
	}

}
