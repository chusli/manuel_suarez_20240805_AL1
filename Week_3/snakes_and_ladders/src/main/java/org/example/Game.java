package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Game {
    private static final int LIMIT = 100;

    private final Player first;
    private final Player second;
    private int round = 0;
    private List<Ladder> ladders = new ArrayList<>();

    public Game(Player first, Player second) {
        this.first = first;
        this.second = second;
    }

    public void play(Die die1, Die die2) {
        if (round % 2 == 0) {
            move(first, die1, die2);
        } else {
            move(second, die1, die2);
        }
    }

    private void move(Player player, Die die1, Die die2) {
        int amount = die1.add(die2);
        if (die1.getValue() != die2.getValue()) {
            round++;
        }
        if (overshoot(player.getLocation(), amount)) {
            player.move(2 * LIMIT - (player.getLocation() + amount));
        } else {
            player.move(amount);
        }
        handleLadder(player);
    }

    private void handleLadder(Player player) {
        ladders.stream()
                .filter(ladder -> ladder.getSource() == player.getLocation())
                .forEach(ladder -> player.move(ladder.getTarget() - player.getLocation()));
    }

    private boolean overshoot(int location, int amount) {
        return location + amount > LIMIT;
    }

    public boolean gameOver() {
        return Stream.of(first, second)
                .anyMatch(player -> player.getLocation() == LIMIT);
    }

    public void add(Ladder ladder) {
        this.ladders.add(ladder);
    }
}
