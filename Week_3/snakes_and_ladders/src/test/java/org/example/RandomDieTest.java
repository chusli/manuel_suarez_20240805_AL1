package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class RandomDieTest {

    private final int SAMPLE_SIZE = 1_000_000;

    @Test
    void inRange() {
        for (int i = 0; i < SAMPLE_SIZE; i++) {
            assertThat(new RandomDie().getValue()).isBetween(1, 6);
        }
    }

    @Test
    void distribution() {
        List<Integer> randomValue = new ArrayList<>();
        for (int i = 0; i < SAMPLE_SIZE; i++) {
            randomValue.add(new RandomDie().getValue());
        }
        Map<Integer, Long> distribution = randomValue.stream()
                .collect(Collectors.groupingBy(
                        num -> num,
                        Collectors.counting()
                ));
        final long lowerLimit = (SAMPLE_SIZE / 6) - (SAMPLE_SIZE / 50);
        final long upperLimit = (SAMPLE_SIZE / 6) + (SAMPLE_SIZE / 50);
        assertThat(distribution.values()).allMatch(aLong -> (aLong > lowerLimit) && (aLong < upperLimit));
    }

}