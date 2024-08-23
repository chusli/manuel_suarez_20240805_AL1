package org.example;

public class Player {

    private final String name;

    private int location = 0;

    public Player(String name) {
        this.name = name;
    }

    public int getLocation() {
        return location;
    }

    public int move(int amount) {
        location += amount;
        return location;
    }

}
