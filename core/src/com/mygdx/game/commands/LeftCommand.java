package com.mygdx.game.commands;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.GameCharacter;

public class LeftCommand implements Command {
    private Vector2 velocity;

    @Override
    public void pressed(GameCharacter person) {
        person.setMoveLeft(true);
    }

    @Override
    public void released(GameCharacter person) {
        person.setMoveLeft(false);
        velocity = person.getVelocity();
        velocity.x = 0;
        person.setAnimationTime(0);
        person.setVelocity(velocity);
    }
}
