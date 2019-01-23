package com.mygdx.game.commands;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.GameCharacter;

public class RightCommand implements Command {
    private Vector2 velocity;

    @Override
    public void pressed(GameCharacter person) {
        person.setMoveRight(true);
    }

    @Override
    public void released(GameCharacter person) {
        person.setMoveRight(false);
        velocity = person.getVelocity();
        velocity.x = 0;
        person.setAnimationTime(0);
        person.setVelocity(velocity);
    }
}
