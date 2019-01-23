package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.math.Vector2;

public class GameCharacter {

    /** the movement velocity */
    private Vector2 velocity = new Vector2();
    private float speed = 60 * 2, gravity = 60 * 1.8f, increment;
    private boolean canJump;
    private Animation still, left, right, up, down;
    private Sprite player;
    private TiledMapTileLayer collisionLayer;
    private String blockedKey = "blocked";
    private float animationTime=0;
    private boolean jump,moveLeft,moveRight,moveDown,moveUp;


    public GameCharacter(Animation still, Animation left, Animation right, Animation up, Animation down, Sprite s, TiledMapTileLayer collisionLayer) {
       // super(still.getKeyFrame(0));
        this.still = still;
        this.left = left;
        this.right = right;
        this.up = up;
        this.down = down;
        player=s;
        this.collisionLayer = collisionLayer;
        player.setSize(collisionLayer.getWidth() / 3, collisionLayer.getHeight() * 1.25f);
    }



    public void update(float delta) {


        // clamp velocity
        if(velocity.y > speed)
            velocity.y = speed;
        else if(velocity.y < -speed)
            velocity.y = -speed;

        // save old position
        float oldX = player.getX(), oldY = player.getY();
        boolean collisionX = false, collisionY = false;

        // move on x
        player.setX(player.getX() + velocity.x * delta);

        // calculate the increment for step in #collidesLeft() and #collidesRight()
        increment = collisionLayer.getTileWidth();
        increment = player.getWidth() < increment ? player.getWidth() / 2 : increment / 2;

        if(velocity.x < 0) // going left
            collisionX = collidesLeft();
        else if(velocity.x > 0) // going right
            collisionX = collidesRight();

        // react to x collision
        if(collisionX) {
            player.setX(oldX);
            velocity.x = 0;
        }

        // move on y
        player.setY(player.getY() + velocity.y * delta);

        // calculate the increment for step in #collidesBottom() and #collidesTop()
        increment = collisionLayer.getTileHeight();
        increment = player.getHeight() < increment ? player.getHeight() / 2 : increment / 2;

        if(velocity.y < 0) // going down
            canJump = collisionY = collidesBottom();
        else if(velocity.y > 0) // going up
            collisionY = collidesTop();

        // react to y collision
        if(collisionY) {
            player.setY(oldY);
            velocity.y = 0;
        }

        if(jump){
            if(canJump) {
                velocity.y = speed / 1.8f;
                canJump=false;
            }
        }
        if(moveLeft){
            velocity.x = -speed;
            //animationTime = 0;
        }
        if(moveRight){
            velocity.x = speed;
            //animationTime = 0;
        }
        if(moveDown){
            velocity.y = -speed;
            //animationTime = 0;
        }
        if(moveUp){
            velocity.y = speed;
            //animationTime = 0;
        }




        player.setRegion((TextureRegion) (velocity.x < 0 ? left.getKeyFrame(animationTime) : velocity.x > 0 ? right.getKeyFrame(animationTime) :
                velocity.y < 0 ? down.getKeyFrame(animationTime) : velocity.y > 0 ? up.getKeyFrame(animationTime) : still.getKeyFrame(animationTime)));

    }

    private boolean isCellBlocked(float x, float y) {
        Cell cell = collisionLayer.getCell((int) (x / collisionLayer.getTileWidth()), (int) (y / collisionLayer.getTileHeight()));
        return cell != null && cell.getTile() != null && cell.getTile().getProperties().containsKey(blockedKey);
    }

    public boolean collidesRight() {
        for(float step = 0; step <= player.getHeight(); step += increment)
            if(isCellBlocked(player.getX() + player.getWidth(), player.getY() + step))
                return true;
        return false;
    }

    public boolean collidesLeft() {
        for(float step = 0; step <= player.getHeight(); step += increment)
            if(isCellBlocked(player.getX(), player.getY() + step))
                return true;
        return false;
    }

    public boolean collidesTop() {
        for(float step = 0; step <= player.getWidth(); step += increment)
            if(isCellBlocked(player.getX() + step, player.getY() + player.getHeight()))
                return true;
        return false;

    }

    public boolean collidesBottom() {
        for(float step = 0; step <= player.getWidth(); step += increment)
            if(isCellBlocked(player.getX() + step, player.getY()))
                return true;
        return false;
    }

    public Vector2 getVelocity() {
        return velocity;
    }

    public void setVelocity(Vector2 velocity) {
        this.velocity = velocity;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getGravity() {
        return gravity;
    }

    public void setGravity(float gravity) {
        this.gravity = gravity;
    }

    public TiledMapTileLayer getCollisionLayer() {
        return collisionLayer;
    }

    public void setCollisionLayer(TiledMapTileLayer collisionLayer) {
        this.collisionLayer = collisionLayer;
    }

    public Sprite getSprite(){
        return player;
    }

    public float getAnimationTime() {
        return animationTime;
    }

    public void setAnimationTime(float animationTime) {
        this.animationTime = animationTime;
    }

    public boolean isCanJump() {
        return canJump;
    }

    public void setCanJump(boolean canJump) {
        this.canJump = canJump;
    }

    public void setJump(boolean jump) {
        this.jump = jump;
    }

    public void setMoveLeft(boolean moveLeft) {
        this.moveLeft = moveLeft;
    }

    public void setMoveRight(boolean moveRight) {
        this.moveRight = moveRight;
    }

    public void setMoveDown(boolean moveDown) {
        this.moveDown = moveDown;
    }

    public void setMoveUp(boolean moveUp) {
        this.moveUp = moveUp;
    }
}


