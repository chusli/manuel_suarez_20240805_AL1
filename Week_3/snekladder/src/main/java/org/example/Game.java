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

    public Game(Player first, Player second, Teleporter... teleporters) {
        this.first = first;
        this.second = second;
        this.teleporters.addAll(Arrays.stream(teleporters).toList());
    }

    private static int handleBounce(Player player) {
        if (player.getLocation() > LIMIT) {
            return player.move(-2 * (player.getLocation() - LIMIT));
        }
        return player.getLocation();
    }

    public boolean over() {
        return false;
    }

    public void play(Die die1, Die die2) {
        int amount = die1.value + die2.value;
        if (round % 2 == 0) {
            move(first, amount);
        } else {
            move(second, amount);
        }
        round = die1.value == die2.value ? round : round + 1;
    }

    private void move(Player player, int amount) {
        player.move(amount);
        handleBounce(player);
        handleTeleporter(player);
    }

    private void handleTeleporter(Player player) {
        teleporters.stream().filter(teleporter -> teleporter.getSource() == player.getLocation())
                .forEach(teleporter -> player.move(teleporter.getDestination() - player.getLocation()));
    }

}
