package org.example;

public class Player {

    private int health;

    public Player(int health) {
        this.health = health;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public int getHealth() {
        return health;
    }

    public void receiveDamage(int damage) {
        health -= damage;
        System.out.println("health left: " + health);
    }

}
