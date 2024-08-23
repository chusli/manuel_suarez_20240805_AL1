package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerTest {

    @Test
    void moveUpdatesLocation() {
        Player player = new Player("test");

        player.move(123);

        assertThat(player.getLocation()).isEqualTo(123);
    }

    @Test
    void movingTwiceUpdatesLocation() {
        Player player = new Player("test");

        player.move(123);
        player.move(123);

        assertThat(player.getLocation()).isEqualTo(246);
    }

    @Test
    void movingReturnsNewLocation() {
        assertThat(new Player("test").move(6)).isEqualTo(6);
    }

}