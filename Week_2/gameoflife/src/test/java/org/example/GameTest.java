package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {

    @Test
    void checkHowManyNeighouringCellsAreAlive() {
        Game game = new Game(List.of(List.of(new Cell(true), new Cell(false), new Cell(false))));

        long actual = game.getAliveNeighbours(1, 0);

        assertThat(actual).isEqualTo(1);
    }

}