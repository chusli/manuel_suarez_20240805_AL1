package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {

    @Test
    void getAliveCells() {
        Game game = new Game(1, 1);
        game.init(new Coordinate(0, 0));

        List<Coordinate> actual = game.getAliveCells();

        assertThat(actual).containsExactly(new Coordinate(0, 0));
    }

    @Test
    void playWhenOnlyOnceCellAliveReturnEmpty() {
        Game game = new Game(3, 3);
        game.init(new Coordinate(1, 1));

        game.play();

        assertThat(game.getAliveCells()).isEmpty();
    }

}