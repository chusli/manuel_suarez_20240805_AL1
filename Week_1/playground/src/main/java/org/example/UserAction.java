package org.example;

public interface UserAction {

    void apply(Player player);

    class Heal implements UserAction {

        private final int value;

        public Heal(int value) {
            this.value = value;
        }

        @Override
        public void apply(Player player) {
            player.receiveDamage(value);
        }

    }

    class Attack implements UserAction {

        private final int value;

        public Attack(int value) {
            this.value = value;
        }

        @Override
        public void apply(Player player) {
            player.receiveDamage(-value);
        }

    }

}
