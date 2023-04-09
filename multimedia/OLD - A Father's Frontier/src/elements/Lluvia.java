package elements;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Array;
import game.Parametros;
import managers.ResourceManager;

public class Lluvia extends Actor {
	protected Animation<TextureRegion> animation;
	protected float animationTime;
	protected Vector2 velocity;
	protected Vector2 acceleration;
	protected float deceleration;
	protected float maxSpeed;
	protected Polygon colision;
	protected boolean enabled;
	protected ShapeRenderer shapeRenderer;
	protected float polyHigh;
	protected float polyWidth;
	protected float padY=0;
	protected float padX=0;
    
    public Lluvia() {
        setPosition(-10, -1);
		   velocity = new Vector2(0,0);
	        acceleration = new Vector2(0,0);
	      
	        maxSpeed = 1000;
	        deceleration = 0;
	        enabled=true;
	        
	        shapeRenderer=new ShapeRenderer();
        this.loadFullAnimation("maps/images/lluvia.png",6,5,0.07f,true);
    }

	
	
	public boolean getEnabled() {
		return enabled;
	}


	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
		@Override
		public void draw(Batch batch, float parentAlpha) {
			// TODO Auto-generated method stub
			if(this.getEnabled()) {
				
			if(animation!=null ) {batch.draw( animation.getKeyFrame(animationTime), 
		                getX(), getY(), getOriginX(), getOriginY(),
		                animation.getKeyFrame(animationTime).getRegionWidth(), animation.getKeyFrame(animationTime).getRegionHeight(), getScaleX(), getScaleY(), getRotation() );
			}
			if(Parametros.debug) {
				pintarCaja(batch);
			}
			super.draw(batch, parentAlpha);
		}
		
	
	
	}
		public Polygon getBoundaryPolygon()
	    {
	        colision.setPosition( getX()+this.padX, getY() +this.padY);
	        colision.setOrigin( getOriginX(), getOriginY() );
	        colision.setRotation( getRotation() );
	        colision.setScale( getScaleX(), getScaleY() );        
	        return colision;
	    }
	
	public void pintarCaja(Batch batch) {
		batch.end();
		shapeRenderer.setProjectionMatrix(batch.getProjectionMatrix());
		shapeRenderer.begin(ShapeType.Line);
		shapeRenderer.setColor(Color.WHITE);
		if(this.getBoundaryPolygon()!=null) {
		float[] vertices =	new float[this.getBoundaryPolygon().getTransformedVertices().length];
				
		for(int i=0;i<vertices.length/2;i++) {
			vertices[2*i]=(this.getBoundaryPolygon().getTransformedVertices()[2*i]);
			vertices[2*i+1]=(this.getBoundaryPolygon().getTransformedVertices()[2*i+1]);
			
		}
		
		shapeRenderer.polygon(vertices);
	
		}
		shapeRenderer.end();	
		batch.begin();
	}
	
	
	  @Override
	public void act(float delta) {
		// TODO Auto-generated method stub
		if(this.getEnabled()) {
				super.act(delta);
		animationTime+=delta;}
	}

	   public void setAnimation(Animation<TextureRegion> anim)
	    {
	        animation = anim;
	        if(anim==null) {System.out.println("Es nulaaaa");}
	        TextureRegion tr = animation.getKeyFrame(0);
	        float w = tr.getRegionWidth();
	        float h = tr.getRegionHeight();
	        setSize( w, h );
	        this.polyHigh=h;
	        this.polyWidth=w;
	        
	        setOrigin( w/2, h/2 );

	        if (colision== null)
	            setRectangle();
	    }
	  
	  public Animation<TextureRegion> loadFullAnimation(String name, int rows, int cols, float frameDuration, boolean loop)
	    { 
		  
	        Texture texture = ResourceManager.getTexture(name);
	       // texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
	        int frameWidth = texture.getWidth() / cols;
	        int frameHeight =texture.getHeight() / rows;

	        TextureRegion[][] temp = TextureRegion.split(texture, frameWidth, frameHeight);
	        
	        Array<TextureRegion> textureArray = new Array<TextureRegion>();

	        for (int r = 0; r < rows; r++)
	            for (int c = 0; c < cols; c++)
	                textureArray.add( temp[r][c] );

	        Animation<TextureRegion> anim = new Animation<TextureRegion>(frameDuration, textureArray);

	        if (loop)
	            anim.setPlayMode(Animation.PlayMode.LOOP);
	        else
	            anim.setPlayMode(Animation.PlayMode.NORMAL);

	        if (animation == null) {
	            
	        	 this.setAnimation(anim);}

	        return anim;
	    }

	  
	  public void setRectangle()
	    {
		  float w, h;
		  if(this.polyWidth!=getWidth() && this.polyWidth>0) {
		   w = this.polyWidth;}
		  else {w=this.getWidth();}
		  if(this.polyHigh!=this.getHeight()&& this.polyHigh>0) {
	        h = this.polyHigh;}
		  else { h=getHeight();}
	        float[] vertices = {padX,padY, w-padX,padY, w-padX,h-padY, padX,h-padY};
	        colision = new Polygon(vertices);
	        this.setOrigin(w/2,h/2);
	    }
	
}