package org.example;

public class Game {

    private final Player firstPlayer;

    private final Player secondPlayer;

    int round = 0;

    public Game(Player firstPlayer, Player secondPlayer) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
    }

    public void play(Die die1, Die die2) {
        int amount = die1.getValue() + die2.getValue();
        if (round % 2 == 0) {
            firstPlayer.move(amount);
        } else {
            secondPlayer.move(amount);
        }
        advanceRoundIfNotEqual(die1, die2);
    }

    private void advanceRoundIfNotEqual(Die die1, Die die2) {
        if (die1.getValue() != die2.getValue()) {
            round++;
        }
    }

}
