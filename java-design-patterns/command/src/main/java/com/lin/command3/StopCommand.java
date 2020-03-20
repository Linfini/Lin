package com.lin.command3;

/**
 * ConcreteCommand
 */
public class StopCommand implements Command {

    private AudioPlayer player;

    public StopCommand(AudioPlayer player) {
        this.player = player;
    }

    @Override
    public void execute() {
        player.stop();
    }
}
