package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class GameTest {
    public static Stream<Arguments> provideOvershoots() {
        return Stream.of(
                arguments(99, 2, 99),
                arguments(99, 3, 98),
                arguments(95, 6, 99)
        );
    }

    @ParameterizedTest
    @MethodSource("provideOvershoots")
    void whenPlayerOvershootsGoalThenBounce(int die1, int die2, int expectedLocation) {
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");
        Game game = new Game(player1, player2);

        game.play(new TestDie(die1), new TestDie(die2));

        assertThat(player1.getLocation()).isEqualTo(expectedLocation);
    }

    @Test
    void whenPlayerThrowsPairThenGainAnotherTurn() {
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");
        Game game = new Game(player1, player2);

        game.play(new TestDie(3), new TestDie(3));
        game.play(new TestDie(3), new TestDie(3));
        game.play(new TestDie(4), new TestDie(3));
        game.play(new TestDie(1), new TestDie(2));

        assertThat(player1.getLocation()).isEqualTo(19);
        assertThat(player2.getLocation()).isEqualTo(3);
    }

    @Test
    void whenPlayerReachesLimitThenGameIsOver() {
        Game game = new Game(new Player("Player 1"), new Player("Player 2"));
        game.play(new TestDie(100), new TestDie(0));

        boolean actual = game.gameOver();

        assertThat(actual).isTrue();
    }

    @Test
    void whenNoPlayerReachedLimitThenGameIsNotOver() {
        Game game = new Game(new Player("Player 1"), new Player("Player 2"));
        game.play(new TestDie(10), new TestDie(0));
        game.play(new TestDie(10), new TestDie(0));

        boolean actual = game.gameOver();

        assertThat(actual).isFalse();
    }

    @Test
    void whenPlayerHitsLadderThenAdvance() {
        Player player = new Player("player 1");
        Game game = new Game(player, new Player("player 2"));
        game.add(new Ladder(5, 12));

        game.play(new TestDie(2), new TestDie(3));

        assertThat(player.getLocation()).isEqualTo(12);
    }

    @Test
    void whenPlayerHitsSnakeThenGoBack() {
        Player player = new Player("player 1");
        Game game = new Game(player, new Player("player 2"));
        game.add(new Snake(13, 2));

        game.play(new TestDie(12), new TestDie(1));

        assertThat(player.getLocation()).isEqualTo(2);
    }

    private static class TestDie extends Die {
        private final int value;

        public TestDie(int value) {
            this.value = value;
        }

        @Override
        public int getValue() {
            return value;
        }

        @Override
        public int add(Die die) {
            return value + die.getValue();
        }
    }
}