package com.mygdx.game.commands;

public enum AllCommands {
    UP(new UpCommand()),
    DOWN(new DownCommand()),
    LEFT(new LeftCommand()),
    RIGHT(new RightCommand());

    public final Command theCommand;

    private AllCommands (Command command){
        this.theCommand = command;
    }

}
