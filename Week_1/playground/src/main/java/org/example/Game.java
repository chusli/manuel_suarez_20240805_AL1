package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Game {

    private static final Random RANDOM = new Random();

    private final List<Player> players;

    private int turn = 0;

    public Game(Player... players) {
        this.players = Arrays.stream(players).toList();
    }

    public void playTurn() {
        int playerIndex = turn % players.size();
        int damage = randomDamage();
        System.out.format("hitting player#%d for %d damage.", playerIndex, damage);
        System.out.println();
        players.get(playerIndex).receiveDamage(damage);
        turn++;
    }

    public void gameOver() {
        Player deadPlayer = players
                .stream().filter(player -> !player.isAlive())
                .findFirst()
                .orElseThrow();
        int deadPlayerIndex = players.indexOf(deadPlayer);
        System.out.format("game over! player#%d has died.", deadPlayerIndex);
    }

    private int randomDamage() {
        final int low = 1;
        final int high = 10 + 1;
        return RANDOM.nextInt(high - low) + low;
    }

    public boolean allPlayersAlive() {
        return players.stream().allMatch(Player::isAlive);
    }

}
