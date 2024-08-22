package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {

    private static final int LIMIT = 100;

    private final Player first;

    private final Player second;

    private final List<Teleporter> teleporters = new ArrayList<>();

    private int round = 0;

    public Game(Player first, Player second) {
        this.first = first;
        this.second = second;
    }

    public boolean gameOver() {
        return false;
    }

    public void play(Die die1, Die die2) {
        if (round % 2 == 0) {
            move(first, die1, die2);
        } else {
            move(second, die1, die2);
        }
    }

    private void move(Player player, Die die1, Die die2) {
        if (!die1.equals(die2)) {
            round++;
        }
        player.move(die1.add(die2), LIMIT);

        handleTeleporter(player);
    }

    private void handleTeleporter(Player player) {
        teleporters.stream()
                .filter(player::sitsOn)
                .forEach(teleporter -> player.goTo(teleporter.target()));
    }

    public void add(Teleporter... teleporters) {
        this.teleporters.addAll(Arrays.stream(teleporters).toList());
    }

}
