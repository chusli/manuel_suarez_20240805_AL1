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

}