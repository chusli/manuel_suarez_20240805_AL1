package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class CoordinateTest {

    public static Stream<Arguments> provideNeighbours() {
        return Stream.of(
                arguments(new Coordinate(4, 4)),
                arguments(new Coordinate(4, 5)),
                arguments(new Coordinate(4, 6)),
                arguments(new Coordinate(5, 4)),
                arguments(new Coordinate(5, 6)),
                arguments(new Coordinate(6, 4)),
                arguments(new Coordinate(6, 5)),
                arguments(new Coordinate(6, 6))
        );
    }

    public static Stream<Arguments> provideNonAdjacent() {
        return Stream.of(
                arguments(new Coordinate(5, 5)),
                arguments(new Coordinate(3, 5)),
                arguments(new Coordinate(3, 4)),
                arguments(new Coordinate(6, 7)),
                arguments(new Coordinate(4, 8))
        );
    }

    @ParameterizedTest
    @MethodSource("provideNeighbours")
    void validNeighbours(Coordinate neighbour) {
        Coordinate coordinate = new Coordinate((5), 5);

        boolean actual = coordinate.neighbours(neighbour);

        assertThat(actual).isTrue();
    }

    @ParameterizedTest
    @MethodSource("provideNonAdjacent")
    void invalidNeighbours(Coordinate nonadjacent) {
        Coordinate coordinate = new Coordinate((5), 5);

        boolean actual = coordinate.neighbours(nonadjacent);

        assertThat(actual).isFalse();
    }

}