package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Game {

    private static final int LIMIT = 100;

    private final Player first;

    private final Player second;

    private final List<Teleporter> teleporters = new ArrayList<>();

    private int playerTurn = 0;

    public Game(Player first, Player second, Teleporter... teleporters) {
        this.first = first;
        this.second = second;
        this.teleporters.addAll(Arrays.stream(teleporters).toList());
    }

    public boolean over() {
        Optional<Player> winner = Stream.of(first, second)
                .filter(player -> player.getLocation() == LIMIT)
                .findAny();
        winner.ifPresent(player -> System.out.printf("%s has won after %d rounds!%n", player.getName(), playerTurn));
        return winner.isPresent();
    }

    public void play(Die die1, Die die2) {
        int amount = die1.value + die2.value;
        if (playerTurn % 2 == 0) {
            move(first, amount);
        } else {
            move(second, amount);
        }
        playerTurn = die1.value == die2.value ? playerTurn : playerTurn + 1;
    }

    private void move(Player player, int amount) {
        player.move(amount);
        handleBounce(player);
        handleTeleporter(player);
    }

    private void handleBounce(Player player) {
        if (player.getLocation() > LIMIT) {
            player.move(-2 * (player.getLocation() - LIMIT));
        }
    }

    private void handleTeleporter(Player player) {
        teleporters.stream().filter(teleporter -> teleporter.isBeingSatOnBy(player))
                .forEach(teleporter -> teleporter.applyTo(player));
    }

}
