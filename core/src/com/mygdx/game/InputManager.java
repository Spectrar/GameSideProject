package com.mygdx.game;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;

public class InputManager implements InputProcessor {

    GameCharacter myPlayer;
    Vector2 velocity;
    CharacterCommandControler ctrler;

    public InputManager(GameCharacter myPlayer, CharacterCommandControler ctrler) {
        this.myPlayer = myPlayer;
        this.ctrler =  ctrler;
        ctrler.loadSettings();
    }

    @Override
    public boolean keyDown(int keycode) {
        switch(keycode) {
            case Input.Keys.W:
            ctrler.pressW(myPlayer);
                break;
            case Input.Keys.A:
                ctrler.pressA(myPlayer);
                break;
            case Input.Keys.D:
                ctrler.pressD(myPlayer);
                break;
            case Input.Keys.S:
                ctrler.pressS(myPlayer);
                break;

        }
        return true;
    }




    @Override
    public boolean keyUp(int keycode) {
        switch(keycode) {
            case Input.Keys.W:
                ctrler.releasedW(myPlayer);
                break;
            case Input.Keys.A:
                ctrler.releasedA(myPlayer);
                break;
            case Input.Keys.D:
                ctrler.releasedD(myPlayer);
                break;
            case Input.Keys.S:
                ctrler.releasedS(myPlayer);
                break;
        }
        return true;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

}
