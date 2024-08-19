package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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

}