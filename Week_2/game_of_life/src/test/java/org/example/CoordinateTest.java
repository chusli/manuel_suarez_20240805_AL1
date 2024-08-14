package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CoordinateTest {

    @Test
    void neighboursWhenNotAdjacentThenReturnFalse() {
        Coordinate coordinate = new Coordinate(0, 0);

        boolean actual = coordinate.neighbours(new Coordinate(2, 1));

        assertThat(actual).isFalse();
    }

    @Test
    void neighboursWhenToTheLeftThenReturnTrue() {
        Coordinate coordinate = new Coordinate(6, 1);

        boolean actual = coordinate.neighbours(new Coordinate(5, 1));

        assertThat(actual).isTrue();
    }

    @Test
    void neighboursWhenToTheRightThenReturnTrue() {
        Coordinate coordinate = new Coordinate(6, 1);

        boolean actual = coordinate.neighbours(new Coordinate(7, 1));

        assertThat(actual).isTrue();
    }

    @Test
    void neighboursWhenAboveThenReturnTrue() {
        Coordinate coordinate = new Coordinate(6, 1);

        boolean actual = coordinate.neighbours(new Coordinate(6, 0));

        assertThat(actual).isTrue();
    }

    @Test
    void neighboursWhenBelowThenReturnTrue() {
        Coordinate coordinate = new Coordinate(6, 1);

        boolean actual = coordinate.neighbours(new Coordinate(6, 2));

        assertThat(actual).isTrue();
    }

    @Test
    void neighboursWhenDiagonalThenReturnTrue() {
        Coordinate coordinate = new Coordinate(6, 1);

        boolean actual = coordinate.neighbours(new Coordinate(5, 0));

        assertThat(actual).isTrue();
    }

    @Test
    void neighboursWhenTwoAboveThenReturnFalse() {
        Coordinate coordinate = new Coordinate(6, 3);

        boolean actual = coordinate.neighbours(new Coordinate(6, 1));

        assertThat(actual).isFalse();
    }

    @Test
    void neighboursWhenSameCoordinatesThenReturnFalse() {
        Coordinate coordinate = new Coordinate(6, 4);

        boolean actual = coordinate.neighbours(new Coordinate(6, 4));

        assertThat(actual).isFalse();
    }

}