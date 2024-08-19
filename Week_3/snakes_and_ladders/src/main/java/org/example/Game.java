package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Game {

    private static final int END_OF_GAME = 100;

    private final Player firstPlayer;

    private final Player secondPlayer;

    private final List<Ladder> ladders = new ArrayList<>();

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
            movePlayer(amount, firstPlayer);
        } else {
            movePlayer(amount, secondPlayer);
        }
        advanceRoundIfNotEqual(die1, die2);
    }

    private void movePlayer(int amount, Player player) {
        int newLocation = player.getLocation() + amount > END_OF_GAME ? 2 * END_OF_GAME - (player.getLocation() + amount) : player.getLocation() + amount;
        player.move(ladders.stream().filter(ladder -> ladder.source() == newLocation)
                .findFirst()
                .map(ladder -> ladder.target() - player.getLocation())
                .orElse(amount));
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

    public void add(Ladder... ladder) {
        ladders.addAll(Arrays.stream(ladder).toList());
    }

}
