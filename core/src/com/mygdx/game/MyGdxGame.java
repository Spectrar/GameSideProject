package com.mygdx.game;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;

import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

public class MyGdxGame extends ApplicationAdapter {


    SpriteBatch batch;
    GameCharacter myPlayer;
    float posX, posY;
    TiledMap tiledMap;
    OrthographicCamera camera;
    OrthogonalTiledMapRendererWithSprites tiledMapRenderer;
    CharacterCommandControler playerController;


    @Override
    public void create() {
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
        batch = new SpriteBatch();

        //setting up the camera
        camera = new OrthographicCamera();
        camera.setToOrtho(false, w, h);
        camera.update();

        //loading the map and is renderer
        tiledMap = new TmxMapLoader().load("data/basic.tmx");
        tiledMapRenderer = new OrthogonalTiledMapRendererWithSprites(tiledMap);

        //creating the player animations
        TextureAtlas playerAtlas = new TextureAtlas("data/player/light.txt");
        Animation still, left, right, up, down;
        still = new Animation(1f, playerAtlas.findRegions("WalkDownStand"));
        left = new Animation(1 / 8f, playerAtlas.findRegions("WalkLeft"));
        right = new Animation(1 / 8f, playerAtlas.findRegions("WalkRight"));
        up = new Animation(1 / 8f, playerAtlas.findRegions("WalkUp"));
        down = new Animation(1 / 8f, playerAtlas.findRegions("WalkDown"));
        still.setPlayMode(Animation.PlayMode.LOOP);
        left.setPlayMode(Animation.PlayMode.LOOP);
        right.setPlayMode(Animation.PlayMode.LOOP);
        up.setPlayMode(Animation.PlayMode.LOOP);
        down.setPlayMode(Animation.PlayMode.LOOP);

        //initiate the player class
        myPlayer = new GameCharacter(still, left,right, up, down, new Sprite(playerAtlas.findRegion("WalkDownStand").getTexture()), (TiledMapTileLayer) tiledMap.getLayers().get(0));
        //myPlayer.getSprite().setBounds(16,16,16,32f);
        myPlayer.getSprite().setSize(32f,32f);

        //create player position
        posX = w / 2 - myPlayer.getSprite().getWidth() / 2;
        posY = h / 2 - myPlayer.getSprite().getHeight() / 2;
        myPlayer.getSprite().setPosition(posX, posY);

        //add player sprite to map
        tiledMapRenderer.addSprite(myPlayer.getSprite());

        //setup input proccesor
        //InputMultiplexer inputMultiplexer = new InputMultiplexer();
        playerController = new CharacterCommandControler();
        InputManager myInput = new InputManager(myPlayer, playerController);
        //inputMultiplexer.addProcessor(myInput);
        Gdx.input.setInputProcessor(myInput);
    }

    @Override
    public void render() {
        //essential window setup
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //position the camera
        camera.position.x = myPlayer.getSprite().getX();
        camera.position.y = myPlayer.getSprite().getY();

        //begin batch to update the map
        batch.begin();
        camera.update();
        tiledMapRenderer.setView(camera);
        tiledMapRenderer.render();
        batch.end();

        //update player class
        myPlayer.update(Gdx.graphics.getDeltaTime());

        //update player animation timing
        myPlayer.setAnimationTime(myPlayer.getAnimationTime()+ Gdx.graphics.getDeltaTime());


    }


    @Override
    public void dispose() {


        batch.dispose();
        //playerTexture.dispose();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

}
