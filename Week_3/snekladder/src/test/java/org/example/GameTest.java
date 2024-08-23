package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class GameTest {

    public static Stream<Arguments> bouceBackScenarios() {
        return Stream.of(
                arguments(98, 4, 98),
                arguments(95, 15, 90),
                arguments(92, 9, 99)
        );
    }

    @Test
    void playWhenDiesDifferentThenNextTurnIsPlayerTwo() {
        Player player1 = new Player("one");
        Player player2 = new Player("two");
        Game game = new Game(player1, player2);

        game.play(new TestDie(1), new TestDie(2));
        game.play(new TestDie(3), new TestDie(4));

        assertThat(player1.getLocation()).isEqualTo(3);
        assertThat(player2.getLocation()).isEqualTo(7);
    }

    @Test
    void playWhenDiesIdenticalThenPlayerOneGetsAnotherTurn() {
        Player player1 = new Player("one");
        Player player2 = new Player("two");
        Game game = new Game(player1, player2);

        game.play(new TestDie(2), new TestDie(2));
        game.play(new TestDie(3), new TestDie(4));
        game.play(new TestDie(1), new TestDie(5));

        assertThat(player1.getLocation()).isEqualTo(11);
        assertThat(player2.getLocation()).isEqualTo(6);
    }

    @Test
    void playWhenCrossingBoundaryThenBounceBack() {
        Player player1 = new Player("one");
        Player player2 = new Player("two");
        Game game = new Game(player1, player2);

        game.play(new TestDie(2), new TestDie(102));

        assertThat(player1.getLocation()).isEqualTo(96);
    }

    @ParameterizedTest
    @MethodSource("bouceBackScenarios")
    void playWhenBoucingBack(int die1, int die2, int expectedLocation) {
        Player player1 = new Player("one");
        Game game = new Game(player1, new Player("two"));

        game.play(new TestDie(die1), new TestDie(die2));

        assertThat(player1.getLocation()).isEqualTo(expectedLocation);
    }

    @Test
    void playWhenHittingSnakeThenGoBack() {
        Player player1 = new Player("one");
        Player player2 = new Player("two");
        Game game = new Game(player1, player2, new Snake(13, 7));

        game.play(new TestDie(3), new TestDie(10));

        assertThat(player1.getLocation()).isEqualTo(7);
    }

    private static class TestDie extends Die {

        public TestDie(int value) {
            super(value);
        }

    }

}