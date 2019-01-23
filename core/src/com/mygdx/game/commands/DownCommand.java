package com.mygdx.game.commands;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.GameCharacter;

public class DownCommand implements Command {
    private Vector2 velocity;

    @Override
    public void pressed(GameCharacter person) {

        person.setMoveDown(true);
    }

    @Override
    public void released(GameCharacter person) {
        person.setMoveDown(false);
        velocity = person.getVelocity();
        velocity.y = 0;
        person.setAnimationTime(0);
        person.setVelocity(velocity);
    }
}
