package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {

    @Test
    void playWhenIdenticalDiesThenAdvanceSamePlayer() {
        Player one = new Player("one");
        Player two = new Player("two");
        Game game = new Game(one, two);

        game.play(new TestDie(1), new TestDie(1));
        game.play(new TestDie(1), new TestDie(2));
        game.play(new TestDie(3), new TestDie(4));

        assertThat(one.getLocation()).isEqualTo(5);
        assertThat(two.getLocation()).isEqualTo(7);
    }

    @Test
    void playWhenLimitReachedThenBounceBack() {
        Player one = new Player("one");
        Game game = new Game(one, new Player("two"));

        game.play(new TestDie(90), new TestDie(11));

        assertThat(one.getLocation()).isEqualTo(99);
    }

    @Test
    void playWhenHittingTeleporterThenSetLocation() {
        Player one = new Player("one");
        Game game = new Game(one, new Player("two"));
        game.add(new Teleporter(6, 18));

        game.play(new TestDie(3), new TestDie(3));

        assertThat(one.getLocation()).isEqualTo(18);
    }

    @Test
    void playWhenPlayerTwoReachesEndThenGameOver() {
        Player one = new Player("one");
        Player two = new Player("two");
        Game game = new Game(one, two);

        game.play(new TestDie(2), new TestDie(1));
        game.play(new TestDie(33), new TestDie(67));

        assertThat(game.gameOver()).isTrue();
    }

    @Test
    void playWhenNoPlayerReachesEndThenNotGameOver() {
        Player one = new Player("one");
        Player two = new Player("two");
        Game game = new Game(one, two);

        game.play(new TestDie(2), new TestDie(1));
        game.play(new TestDie(33), new TestDie(1));

        assertThat(game.gameOver()).isFalse();
    }

    private static class TestDie extends Die {

        public TestDie(int value) {
            super(value);
        }

    }

}