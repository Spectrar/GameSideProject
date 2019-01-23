package com.mygdx.game.commands;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.GameCharacter;

public class UpCommand implements Command {
    private Vector2 velocity;
    @Override
    public void pressed(GameCharacter person) {
        person.setMoveUp(true);
    }

    @Override
    public void released(GameCharacter person) {
        person.setMoveUp(false);
        velocity = person.getVelocity();
        velocity.y = 0;
        person.setAnimationTime(0);
        person.setVelocity(velocity);
    }
}

