package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.actions.RotateToAction;
import com.badlogic.gdx.scenes.scene2d.actions.ScaleToAction;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;

import java.util.Iterator;

public class TutorialReferenceCode {
    World world;
    Body body;
    SpriteBatch batch;
    Texture playerTexture;
    Sprite sprite;
    Stage stage;
    float posX, posY;
    TiledMap tiledMap;
    OrthographicCamera camera;
    OrthogonalTiledMapRendererWithSprites tiledMapRenderer;
    Box2DDebugRenderer debugRenderer;
    Matrix4 debugMatrix;


    public void create () {
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
        batch = new SpriteBatch();

//		stage=new Stage();
//		Gdx.input.setInputProcessor(stage);

//		MyActor myActor = new MyActor();
//		myActor.setTouchable(Touchable.enabled);
//		myActor.addAction(myActor.actorAction());
//		stage.addActor(myActor);


        playerTexture = new Texture(Gdx.files.internal("data/chestSingle.png"));
        sprite = new Sprite(playerTexture);
        posX=w/2-sprite.getWidth()/2;
        posY=h/2-sprite.getHeight()/2;
        sprite.setPosition(posX, posY);

        camera = new OrthographicCamera();
        camera.setToOrtho(false, w, h);
        camera.update();
        tiledMap = new TmxMapLoader().load("data/first.tmx");
        tiledMapRenderer = new OrthogonalTiledMapRendererWithSprites(tiledMap);
        tiledMapRenderer.addSprite(sprite);
        //Gdx.input.setInputProcessor(this);

        // Create a physics world, the heart of the simulation.  The Vector
        //passed in is gravity
        world = new World(new Vector2(0, -98f), true);

        // Now create a BodyDefinition.  This defines the physics objects type
        //and position in the simulation
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        // We are going to use 1 to 1 dimensions.  Meaning 1 in physics engine
        //is 1 pixel
        // Set our body to the same position as our sprite
        bodyDef.position.set(sprite.getX(), sprite.getY());

        // Create a body in the world using our definition
        body = world.createBody(bodyDef);

        // Now define the dimensions of the physics shape
        PolygonShape shape = new PolygonShape();
        // We are a box, so this makes sense, no?
        // Basically set the physics polygon to a box with the same dimensions
        //as our sprite
        shape.setAsBox(sprite.getWidth()/2, sprite.getHeight()/2);

        // FixtureDef is a confusing expression for physical properties
        // Basically this is where you, in addition to defining the shape of the
        //body
        // you also define it's properties like density, restitution and others
        //we will see shortly
        // If you are wondering, density and area are used to calculate over all
        //mass
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 1f;

        Fixture fixture = body.createFixture(fixtureDef);

        // Shape is the only disposable of the lot, so get rid of it
        shape.dispose();


    }


    public void render () {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Advance the world, by the amount of time that has elapsed since the
        //last frame
        // Generally in a real game, dont do this in the render loop, as you are
        //tying the physics
        // update rate to the frame rate, and vice versa
        world.step(Gdx.graphics.getDeltaTime(), 6, 2);

        // Now update the spritee position accordingly to it's now updated
        //Physics body
        sprite.setPosition(body.getPosition().x, body.getPosition().y);

        batch.begin();
        camera.update();
        tiledMapRenderer.setView(camera);
        tiledMapRenderer.render();
        batch.end();

//		stage.act(Gdx.graphics.getDeltaTime());
//		stage.draw();

        //position sprite with key functions
        //keyFunctions();
        //sprite.setPosition(posX,posY);

        //batch.setProjectionMatrix(camera.combined);
        //batch.begin();
        //sprite.draw(batch);
        //batch.end();
    }



    public void dispose () {

        world.dispose();
        batch.dispose();
        playerTexture.dispose();
    }


    public void resize(int width, int height){

    }


    public void pause(){

    }


    public void resume(){

    }

    private void keyFunctions() {


        //Arrow Keys
        if(Gdx.input.isKeyPressed(Input.Keys.A)){

            if (Gdx.input.isKeyPressed(Input.Keys.CONTROL_LEFT))
                posX -= 1f;

            else
                posX -= 5.0f;


        }

        if(Gdx.input.isKeyPressed(Input.Keys.D)) {

            if (Gdx.input.isKeyPressed(Input.Keys.CONTROL_LEFT))
                posX += 1f;

            else
                posX += 5.0f;


        }

        if(Gdx.input.isKeyPressed(Input.Keys.S)){

            if (Gdx.input.isKeyPressed(Input.Keys.CONTROL_LEFT))
                posY -= 1f;

            else
                posY -= 5.0f;

        }

        if(Gdx.input.isKeyPressed(Input.Keys.W)){

            if (Gdx.input.isKeyPressed(Input.Keys.CONTROL_LEFT))
                posY += 1f;

            else
                posY += 5.0f;


        }



        //Mouse movement
        /**if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)){
         posX=Gdx.input.getX() - sprite.getWidth()/2;
         posY=Gdx.graphics.getHeight() - Gdx.input.getY() - sprite.getHeight()/2;
         }
         if(Gdx.input.isButtonPressed(Input.Buttons.RIGHT)){
         posX=Gdx.graphics.getWidth()/2 -sprite.getWidth()/2;
         posY=Gdx.graphics.getHeight()/2 - sprite.getHeight()/2;
         }*/
    }


    public boolean keyDown(int keycode) {
        return false;
    }


    public boolean keyUp(int keycode) {
        if(keycode == Input.Keys.LEFT)
            camera.translate(-32,0);
        if(keycode == Input.Keys.RIGHT)
            camera.translate(32,0);
        if(keycode == Input.Keys.UP)
            camera.translate(0,-32);
        if(keycode == Input.Keys.DOWN)
            camera.translate(0,32);
        if(keycode == Input.Keys.NUM_1)
            tiledMap.getLayers().get(0).setVisible(!tiledMap.getLayers().get(0).isVisible());
        if(keycode == Input.Keys.NUM_2)
            tiledMap.getLayers().get(1).setVisible(!tiledMap.getLayers().get(1).isVisible());
        return false;
    }


    public boolean keyTyped(char character) {
        return false;
    }


    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        //Vector3 clickCoordinates = new Vector3(screenX,screenY,0);
        //Vector3 position = camera.unproject(clickCoordinates);
        //sprite.setPosition(position.x, position.y);

        return true;
    }


    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }


    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }


    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }


    public boolean scrolled(int amount) {
        return false;
    }

    public class MyActor extends Actor {
        Texture texture = new Texture(Gdx.files.internal("data/brick.png"));
        float actorX = 0, actorY = 0;
        public boolean started = false;

        public MyActor(){
            setBounds(getX(),getY(),texture.getWidth(),texture.getHeight());
            addListener(new InputListener(){
                public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                   //((MyGdxGame.MyActor)event.getTarget()).started = true;
                    return true;
                }
            });
        }
        public SequenceAction actorAction(){
            SequenceAction sequenceAction = new SequenceAction();


            MoveToAction moveAction = new MoveToAction();
            RotateToAction rotateAction = new RotateToAction();
            ScaleToAction scaleAction = new ScaleToAction();

            moveAction.setPosition(300f, 300f);
            moveAction.setDuration(5f);
            rotateAction.setRotation(90f);
            rotateAction.setDuration(5f);
            scaleAction.setScale(2f);
            scaleAction.setDuration(5f);

            sequenceAction.addAction(scaleAction);
            sequenceAction.addAction(rotateAction);
            sequenceAction.addAction(moveAction);
            return sequenceAction;
        }



        public void draw(Batch batch, float alpha){
            batch.draw(texture,this.getX(),this.getY(),this.getOriginX(),this.getOriginY(),this.getWidth(),
                    this.getHeight(),this.getScaleX(), this.getScaleY(),this.getRotation(),0,0,
                    texture.getWidth(),texture.getHeight(),false,false);
        }


        public void act(float delta){
            if(started) {
                //	actorX+=5;

                for (Iterator<Action> iter = this.getActions().iterator(); iter.hasNext(); ) {
                    iter.next().act(delta);
                }
            }
        }
    }
}
