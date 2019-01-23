package com.mygdx.game.commands;

import com.mygdx.game.GameCharacter;

import java.io.Serializable;

//Command
public interface Command extends Serializable {
    public void pressed(GameCharacter person);

    public void released(GameCharacter person);
}
