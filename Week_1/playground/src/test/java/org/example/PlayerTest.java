package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerTest {

    @Test
    void whenPlayerHealthPositiveThenIsAlive() {
        Player player = new Player(100);

        assertThat(player.isAlive()).isTrue();
    }

    @Test
    void whenPlayerHealthNonPositiveThenIsNotAlive() {
        Player player = new Player(-1);

        assertThat(player.isAlive()).isFalse();
    }

    @Test
    void whenPlayerReceivesDamageThenLowerHealth() {
        Player player = new Player(10);

        player.receiveDamage(2);

        assertThat(player.getHealth()).isEqualTo(8);
    }

}