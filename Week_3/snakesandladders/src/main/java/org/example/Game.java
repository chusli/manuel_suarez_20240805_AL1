package org.example;

import java.util.IllegalFormatCodePointException;
import java.util.stream.Stream;

public class Game {
    private static final int LIMIT = 100;
    private final Player first;
    private final Player second;
    private int turn = 0;

    public Game(Player first, Player second) {
        this.first = first;
        this.second = second;
    }

    public void play(Die   die1, Die die2) {
        if(turn % 2 == 0) {
            movePlayer(first, die1, die2);
        } else
            movePlayer(second, die1, die2);

        if (die1.getValue() != die2.getValue()) {
            turn++;
        }
    }

    private void movePlayer(Player player, Die die1, Die die2) {
        System.out.println("throw was " +die1.getValue() +" + " + die2.getValue());
        int amount = die1.getValue() + die2.getValue();
        if (overshoots(player, amount)) {
            player.move(2 * LIMIT - (player.getLocation() + amount));
        } else {
            player.move(amount);
        }
    }

    private boolean overshoots(Player player, int amount) {
       return player.getLocation() + amount > LIMIT;
    }

    public boolean gameOver() {
        return Stream.of(first, second)
                .anyMatch(player -> player.getLocation() == LIMIT);
    }
}
