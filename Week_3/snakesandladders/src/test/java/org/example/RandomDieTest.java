package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class RandomDieTest {
    @Test
    void valueIsBetweenOneAndSixInclusive() {
        RandomDie randomDie = new RandomDie();
        
        assertThat(randomDie.getValue()).isBetween(1, 6);
    }

    @Test
    void valueCanOnlyBeAccessedOnce() {
        RandomDie randomDie = new RandomDie();
        randomDie.getValue();

        assertThatExceptionOfType(IllegalStateException.class).isThrownBy(randomDie::getValue);
    }

    @Test
    void whenThrownAlotThenValueIsBetweenOneAndSixInclusive() {
        int SAMPLE = 1_000_000;
        for(int i = 0; i < SAMPLE; i++) {
            assertThat(new RandomDie().getValue()).isBetween(1, 6);
        }
    }

    @Test
    void whenThrownAlotThenHaveProperDistribution() {
        int SAMPLE = 1000;
        List<Integer> values = new ArrayList<>();
        for (int i = 0; i < SAMPLE; i++) {
            values.add(new RandomDie().getValue());
        }
        Map<Integer, Long> collect = values.stream().collect(Collectors.groupingBy(num -> num, Collectors.counting()));

        assertThat(collect).allSatisfy((integer, aLong) -> assertThat(aLong).isBetween((SAMPLE / 6L) -20L, (SAMPLE / 6L) + 20L));
    }
}