package ow_elements;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Intersector.MinimumTranslationVector;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;

import game.Parametros;
import managers.ResourceManager;
;

public class Element extends Actor{
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
    private Array<TextureRegion>[] animationArray;
    private Array<TextureRegion> idleArray;
    private Array<TextureRegion> frenteArray;
    private Array<TextureRegion> espaldaArray;
    private Array<TextureRegion> derechaArray;
    private Array<TextureRegion> izquierdaArray;
    protected Animation<TextureRegion> idleFrente;
    protected Animation<TextureRegion> idleIzquierda;
    protected Animation<TextureRegion> idleDerecha;
    protected Animation<TextureRegion> idleEspaldas;
    protected Animation<TextureRegion> frente;
    protected Animation<TextureRegion> espalda;
    protected Animation<TextureRegion> derecha;
    protected Animation<TextureRegion> izquierda;
	
	
	
	public boolean getEnabled() {
		return enabled;
	}


	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}


	public Element(float x, float y, Stage s) {
		
		this.setPosition(x, y);
		s.addActor(this);
		   velocity = new Vector2(0,0);
	        acceleration = new Vector2(0,0);
	      
	        maxSpeed = 1000;
	        deceleration = 0;
	        enabled=true;
	        
	        shapeRenderer=new ShapeRenderer();
		
	}
	
	
	public Element(float x, float y, Stage s, float w, float h) {
		this.setPosition(x, y);
		s.addActor(this);
		   velocity = new Vector2(0,0);
	        acceleration = new Vector2(0,0);
	      
	        maxSpeed = 1000;
	        deceleration = 0;
	        enabled=true;
	        
	        shapeRenderer=new ShapeRenderer();
	        this.polyWidth=w;
	        this.polyHigh=h;
		
		
		
	}
	
	
	/*@Override
	public void draw(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		if(this.getEnabled()&&((GameScreen.playerY>this.getY() && GameScreen.encima )|| (GameScreen.playerY<=this.getY() && GameScreen.encima==false))) {
			
		if(animation!=null ) {batch.draw( animation.getKeyFrame(animationTime), 
	                getX(), getY(), getOriginX(), getOriginY(),
	                animation.getKeyFrame(animationTime).getRegionWidth(), animation.getKeyFrame(animationTime).getRegionHeight(), getScaleX(), getScaleY(), getRotation() );
		}
		if(GameScreen.debug) {
			pintarCaja(batch);
		}
		super.draw(batch, parentAlpha);
	}*/
		
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
	public Animation<TextureRegion> loadSegmentedAnimagion(String[] names, float frameDuration, boolean loop)
	    { 
	       
	        Array<TextureRegion> textureArray = new Array<TextureRegion>();

	        for (int i = 0; i < names.length; i++)
	        {   
	            String name = names[i];
	        
	            textureArray.add( new TextureRegion( ResourceManager.getTexture(name)) );
	        }

	        Animation<TextureRegion> anim = new Animation<TextureRegion>(frameDuration, textureArray);

	        if (loop)
	            anim.setPlayMode(Animation.PlayMode.LOOP);
	        else
	            anim.setPlayMode(Animation.PlayMode.NORMAL);

	        if (animation == null)
	            this.setAnimation(anim);

	        return anim;
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
	
	public Array<TextureRegion>[] loadFullAnimationArray(String name, int rows, int cols, float frameDuration, boolean loop) { 
	    Texture texture = ResourceManager.getTexture(name);
	    int frameWidth = texture.getWidth() / cols;
	    int frameHeight = texture.getHeight() / rows;
	    TextureRegion[][] temp = TextureRegion.split(texture, frameWidth, frameHeight);

	    @SuppressWarnings("unchecked")
		Array<TextureRegion>[] animationArrays = new Array[5];

	    animationArrays[0] = new Array<TextureRegion>();
	    animationArrays[0].add(temp[0][0]);
	    animationArrays[0].add(temp[1][0]);
	    animationArrays[0].add(temp[2][0]);
	    animationArrays[0].add(temp[3][0]);

	    animationArrays[1] = new Array<TextureRegion>();
	    for (int i = 1; i < 7; i++) {
	        animationArrays[1].add(temp[0][i]);
	    }

	    animationArrays[2] = new Array<TextureRegion>();
	    for (int i = 2; i < 7; i++) {
	        animationArrays[2].add(temp[1][i]);
	    }

	    animationArrays[3] = new Array<TextureRegion>();
	    for (int i = 2; i < 7; i++) {
	        animationArrays[3].add(temp[2][i]);
	    }

	    animationArrays[4] = new Array<TextureRegion>();
	    for (int i = 2; i < 7; i++) {
	        animationArrays[4].add(temp[3][i]);
	    }

	    Array<TextureRegion> textureArray = new Array<TextureRegion>();
	    for (int r = 0; r < rows; r++) {
	        for (int c = 0; c < cols; c++) {
	            textureArray.add(temp[r][c]);
	        }
	    }

	    Animation<TextureRegion> anim = new Animation<TextureRegion>(frameDuration, textureArray);

	    if (loop) {
	        anim.setPlayMode(Animation.PlayMode.LOOP);
	    } else {
	        anim.setPlayMode(Animation.PlayMode.NORMAL);
	    }

	    if (animation == null) {
	        this.setAnimation(anim);
	    }

	    return animationArrays;
	}
	
	public Animation<TextureRegion> loadAnimationFromArray(Array<TextureRegion> array, float frameDuration, boolean loop) {
	    Animation<TextureRegion> anim = new Animation<TextureRegion>(frameDuration, array);

	    if (loop) {
	        anim.setPlayMode(Animation.PlayMode.LOOP);
	    } else {
	        anim.setPlayMode(Animation.PlayMode.NORMAL);
	    }

	    return anim;
	}
	
	  public void applyPhysics(float dt)
	    {
	        // apply acceleration
	        velocity.add( acceleration.x * dt, acceleration.y * dt );
	      
	        float speed = velocity.len();

	        // decrease speed (decelerate) when not accelerating
	        if (acceleration.len() == 0)
	            speed -= deceleration * dt;
	       

	        // keep speed within set bounds
	        speed = MathUtils.clamp(speed, 0, maxSpeed);

	      // update velocity
	        /*
	        if (velocity.len() == 0)
	            velocity.set(speed, 0);
	        else*/
	            velocity.setLength(speed);
	    

	        // update position according to value stored in velocity vector
	        moveBy( velocity.x * dt, velocity.y * dt );

	        // reset acceleration
	        acceleration.set(0,0);  
	        
	        
	    }

	  public Vector2 getVelocity() {
		return velocity;
	}


	public void setVelocity(Vector2 velocity) {
		this.velocity = velocity;
	}


	public boolean overlaps(Element elemento)
	    {
	        Polygon poly1 = this.getBoundaryPolygon();
	        Polygon poly2 = elemento.getBoundaryPolygon();

	        // initial test to improve performance
	        if ( !poly1.getBoundingRectangle().overlaps(poly2.getBoundingRectangle()) )
	            return false;

	        return Intersector.overlapConvexPolygons( poly1, poly2 );
	    }
	  
	  
	  
	  
	  public Vector2 preventOverlap(Element other)
	    {
	        Polygon poly1 = this.getBoundaryPolygon();
	        Polygon poly2 = other.getBoundaryPolygon();

	        // initial test to improve performance
	        if ( !poly1.getBoundingRectangle().overlaps(poly2.getBoundingRectangle()) )
	            return null;

	        MinimumTranslationVector mtv = new MinimumTranslationVector();
	        boolean polygonOverlap = Intersector.overlapConvexPolygons(poly1, poly2, mtv);

	        if ( !polygonOverlap )
	            return null;

	        this.moveBy( mtv.normal.x * mtv.depth, mtv.normal.y * mtv.depth );
	        return mtv.normal;
	    }
	  
	 /* public void setRectangle()
	    {
		  float w = getWidth();
	        float h = getHeight();
	        float[] vertices = {0,0, w,0, w,h, 0,h};
	        colision = new Polygon(vertices);
	    }*/
	  
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
	  
	  public void setRectangle(float polyWidth, float polyHigh, float padX, float padY) {
		  this.polyWidth=polyWidth;
		  this.polyHigh=polyHigh;
		  this.padX=padX;
		  this.padY=padY;
		  setRectangle();
	  }
	  
	  
	  public void setPolygon(int numSides)
	    {
	       /* float w = getWidth();
	        float h = getHeight();*/
		  this.setOrigin(polyWidth/2,polyHigh/2);

	        float[] vertices = new float[2*numSides];
	        for (int i = 0; i < numSides; i++)
	        {
	            float angle = i * 6.28f / numSides;
	            // x-coordinate
	            vertices[2*i] = this.polyWidth/2 * MathUtils.cos(angle) + this.polyWidth/2;
	            // y-coordinate
	            vertices[2*i+1] = this.polyHigh/2 * MathUtils.sin(angle) + this.polyHigh/2;
	        /* // x-coordinate
	            vertices[2*i] = this.getOriginX() * MathUtils.cos(angle) + this.getOriginX()/2;
	            // y-coordinate
	            vertices[2*i+1] = this.getOriginY()/2 * MathUtils.sin(angle) + this.getOriginY()/2;
	        */}
	        colision = new Polygon(vertices);

	    }
	  
	  
	  public void setPolygonShort(int numSides, int factor)
	    {
	       /* float w = getWidth();
	        float h = getHeight();*/
		  this.setOrigin(polyWidth/2,polyHigh/2);
		  this.polyHigh=this.polyHigh/factor;

	        float[] vertices = new float[2*numSides];
	        for (int i = 0; i < numSides; i++)
	        {
	            float angle = i * 6.28f / numSides;
	            // x-coordinate
	            vertices[2*i] = this.polyWidth/2 * MathUtils.cos(angle) + this.polyWidth/2;
	            // y-coordinate
	            vertices[2*i+1] = this.polyHigh/2 * MathUtils.sin(angle) + this.polyHigh/2;
	        /* // x-coordinate
	            vertices[2*i] = this.getOriginX() * MathUtils.cos(angle) + this.getOriginX()/2;
	            // y-coordinate
	            vertices[2*i+1] = this.getOriginY()/2 * MathUtils.sin(angle) + this.getOriginY()/2;
	        */}
	        colision = new Polygon(vertices);

	    }
	  
	  public void setPolygon(int numSides, float polyWidth, float polyHigh, float padX, float padY) {
		  
		  this.polyWidth=polyWidth;
		  this.polyHigh=polyHigh;
		  this.padX=padX;
		  this.padY=padY;
		setPolygon(numSides);  
		
		  
	  }
	  
	
	public void prepararAnimacion(String spriteSheet, boolean loop) {
        	animationArray = loadFullAnimationArray(spriteSheet, 4, 7, 0.2f, loop);
        
	        idleArray = animationArray[0];
	        frenteArray = animationArray[1];
	        izquierdaArray = animationArray[2];
	        derechaArray = animationArray[3];
	        espaldaArray = animationArray[4];
	
	        idleFrente = new Animation<TextureRegion>(0.15f, idleArray.get(0));
	        idleIzquierda = new Animation<TextureRegion>(0.15f, idleArray.get(1));
	        idleDerecha = new Animation<TextureRegion>(0.15f, idleArray.get(2));
	        idleEspaldas = new Animation<TextureRegion>(0.15f, idleArray.get(3));
	        
	        frente = loadAnimationFromArray(frenteArray, 0.15f, loop);
	        espalda = loadAnimationFromArray(espaldaArray, 0.15f, loop);
	        derecha = loadAnimationFromArray(derechaArray, 0.15f, loop);
	        izquierda = loadAnimationFromArray(izquierdaArray, 0.15f, loop);
	}


	public float getMaxSpeed() {
		return maxSpeed;
	}


	public void setMaxSpeed(float maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	  
	
	public void reanimate() {
		this.setEnabled(true);
	}
}
