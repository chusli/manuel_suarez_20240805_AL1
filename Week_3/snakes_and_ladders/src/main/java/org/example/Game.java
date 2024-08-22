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

    private int round = 0;

    public Game(Player first, Player second) {
        this.first = first;
        this.second = second;
    }

    public boolean gameOver() {
        Optional<Player> winner = Stream.of(first, second)
                .filter(player -> player.getLocation() == LIMIT)
                .findAny();
        winner.ifPresent(player -> System.out.println(player.getName() + " has won the game!"));
        return winner.isPresent();
    }

    public void play(Die die1, Die die2) {
        if (round % 2 == 0) {
            move(first, die1, die2);
        } else {
            move(second, die1, die2);
        }
    }

    private void move(Player player, Die die1, Die die2) {
        System.out.println(player.getName() + " rolled " + die1.value + " and " + die2.value);
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
