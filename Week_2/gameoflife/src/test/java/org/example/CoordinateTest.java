package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CoordinateTest {

    @Test
    void equalsAreNotNeighbours() {
        Coordinate coordinate = new Coordinate(3, 6);
        Coordinate equalCoodriante = new Coordinate(3, 6);

        boolean actual = coordinate.neighbours(equalCoodriante);

        assertThat(actual).isFalse();
    }

    @Test
    void validNeighbours() {
        Coordinate coordinate
    }

}