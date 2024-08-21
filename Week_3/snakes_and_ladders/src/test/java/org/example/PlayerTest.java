package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerTest {
    @Test
    void movePlayer() {
        Player test = new Player("test");

        test.move(5);

        assertThat(test.getLocation()).isEqualTo(5);
    }
}