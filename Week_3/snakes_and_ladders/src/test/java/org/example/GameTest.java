package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class GameTest {

    @Test
    void playThenAdvancePlayer() {
        Player firstPlayer = new Player("firstPlayerName");
        Game game = new Game(firstPlayer, new Player("second player"));
        Die die1 = new TestDie(3);
        Die die2 = new TestDie(4);

        game.play(die1, die2);

        assertThat(firstPlayer.getLocation()).isEqualTo(7);
    }

    @Test
    void playWhenRolledTwiceThenAdvancePlayerTwo() {
        Player one = new Player("first");
        Player two = new Player("second");
        Game game = new Game(one, two);

        game.play(new TestDie(1), new TestDie(2));
        game.play(new TestDie(2), new TestDie(3));

        assertThat(two.getLocation()).isEqualTo(5);
    }

    @Test
    void playWhenFirstPlayerThrowsPairThenHaveAnotherRoll() {
        Player one = new Player("first");
        Player two = new Player("second");
        Game game = new Game(one, two);

        game.play(new TestDie(2), new TestDie(2));
        game.play(new TestDie(1), new TestDie(2));
        game.play(new TestDie(2), new TestDie(3));

        assertThat(one.getLocation()).isEqualTo(7);
        assertThat(two.getLocation()).isEqualTo(5);
    }

    @Test
    void whenPlayerReachesFieldHundredThenGameOver() {
        Player one = new Player("first");
        Player two = new Player("second");
        Game game = new Game(one, two);

        game.play(new TestDie(2), new TestDie(1));
        game.play(new TestDie(1), new TestDie(99));

        assertThat(game.isRunning()).isFalse();
        assertThatExceptionOfType(IllegalStateException.class)
                .isThrownBy(() -> game.play(new TestDie(1), new TestDie(1)));
    }

    @Test
    void playWhenHittingSnakeThenGoBack() {
        // since the mechanic is the same use ladder but with inverse ussage of params
        Player one = new Player("first");
        Player two = new Player("second");
        Game game = new Game(one, two);
        game.add(new Ladder(16, 6));

        game.play(new TestDie(15), new TestDie(1));

        assertThat(one.getLocation()).isEqualTo(6);
    }

    @Test
    void playWhenHittingLadderThenAdvance() {
        Player one = new Player("first");
        Player two = new Player("second");
        Game game = new Game(one, two);
        game.add(new Ladder(5, 12));

        game.play(new TestDie(2), new TestDie(1));
        game.play(new TestDie(1), new TestDie(4));

        assertThat(two.getLocation()).isEqualTo(12);
    }

}