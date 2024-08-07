package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class HowBigTest {
    public static Stream<Arguments> provideHowBigIsInteger() {
        return Stream.of(
                arguments(5, 3),
                arguments(16, 5),
                arguments(1,1),
                arguments(0,1),
                arguments(2,2),
                arguments(3,2),
                arguments(4,3),
                arguments(14,4),
                arguments(15,4),
                arguments(1023,10),
                arguments(1024,11)
        );
    }

    @ParameterizedTest
    @MethodSource("provideHowBigIsInteger")
    void testHowBig(int input, int expected) {
        int actual = HowBig.is(input);

        assertThat(actual).isEqualTo(expected);
    }
}