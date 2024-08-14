package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {

    @Test
    void singleCellDoesNotSurviveFirstGeneration() {
        Game game = new Game(3, 3);
        game.init(List.of(new Coordinate(1, 1)));

        game.play();

        List<Coordinate> actual = game.getAliveCells();
        assertThat(actual).isEmpty();
    }

    @Test
    void deadCellWithThreeNeighboursBecomesAlive() {
        Game game = new Game(3, 3);
        game.init(List.of(new Coordinate(2, 0), new Coordinate(2, 1), new Coordinate(2, 2)));

        game.play();

        List<Coordinate> actual = game.getAliveCells();
        assertThat(actual).containsExactly(new Coordinate(1, 1));
    }

}