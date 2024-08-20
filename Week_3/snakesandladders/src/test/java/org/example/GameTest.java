package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void playWhenDiesNotEqualThenAdvancePlayers() {

        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");
        Game game = new Game(player1, player2);

        game.play(new FixedDie(3), new FixedDie(4));
        game.play(new FixedDie(1), new FixedDie(2));

        assertThat(player1.getLocation()).isEqualTo(7);
        assertThat(player2.getLocation()).isEqualTo(3);
    }
    @Test
    void playWhenDiesEqualThenAdvanceSamePlayer() {
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");
        Game game = new Game(player1, player2);

        game.play(new FixedDie(2), new FixedDie(2));
        game.play(new FixedDie(1), new FixedDie(2));

        assertThat(player1.getLocation()).isEqualTo(7);
        assertThat(player2.getLocation()).isEqualTo(0);
    }

    @Test
    void playWhenOvershootingThenBounceBack() {
        Player player1 = new Player("Player 1");
        Game game = new Game(player1, new Player("Player 2"));

        game.play(new FixedDie(99), new FixedDie(3));

        assertThat(player1.getLocation()).isEqualTo(98);
    }

    @Test
    void gameOverWhenPlayerReachedLimitThenReturnTrue() {
        Game game = new Game(new Player(""), new Player(""));
        game.play(new FixedDie(1), new FixedDie(2));
        game.play(new FixedDie(10), new FixedDie(90));

        boolean actual = game.gameOver();

        assertThat(actual).isTrue();
    }
    @Test
    void gameOverWhenNoPlayerReachedLimitThenReturnFalse() {
      Game game = new Game(new Player(""), new Player(""));

        boolean actual = game.gameOver();

        assertThat(actual).isFalse();
    }

    private class FixedDie extends Die {
        private final int value;

        public FixedDie(int value) {
            this.value = value;
        }

        @Override
        int getValue() {
            return value;
        }
    }
}