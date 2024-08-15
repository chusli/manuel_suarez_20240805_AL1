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

    @Test
    void printReturnsListWithAliveCells() {
        Game game = new Game(5, 5);
        game.init(
                new Coordinate(2, 1),
                new Coordinate(2, 2),
                new Coordinate(2, 3),
                new Coordinate(2, 4)
        );

        assertThat(game.print()).contains(
                ".....",
                "..o..",
                "..o..",
                "..o..",
                "..o.."
        );
    }

    @Test
    void playWhenDeadCellHasThreeAliveNeighboursThenBecomeAlive() {
        Game game = new Game(3, 3);
        game.init(new Coordinate(2, 0), new Coordinate(2, 1), new Coordinate(2, 2));
        game.play();

        assertThat(game.getAliveCells()).contains(new Coordinate(1, 1));
    }

}