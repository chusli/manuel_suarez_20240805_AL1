package org.example;

public class Player {
    private final String name;
    private int location = 0;

    public Player(String name) {
        this.name = name;
    }

    public void move(int amount) {
        this.location += amount;
        System.out.println(name + " moves to " + location);
    }

    public int getLocation() {
        return location;
    }
}
