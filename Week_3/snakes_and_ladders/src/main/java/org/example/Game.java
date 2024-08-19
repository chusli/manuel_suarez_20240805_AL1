package org.example;

public class Game {

    private final Player firstPlayer;

    private final Player secondPlayer;

    public Game(Player firstPlayer, Player secondPlayer) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
    }

    public void play(Die die1, Die die2) {
        firstPlayer.move(die1.getValue() + die2.getValue());
    }

}
