package org.example;

import java.util.stream.Stream;

public class Game {

    private static final int END_OF_GAME = 100;

    private final Player firstPlayer;

    private final Player secondPlayer;

    int round = 0;

    public Game(Player firstPlayer, Player secondPlayer) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
    }

    public void play(Die die1, Die die2) {
        if (!isRunning()) {
            throw new IllegalStateException("game is not running anymore");
        }

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

    public boolean isRunning() {
        return Stream.of(firstPlayer, secondPlayer)
                .allMatch(player -> player.getLocation() != END_OF_GAME);
    }

}
