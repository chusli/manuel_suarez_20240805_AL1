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

    public void move(int amount) {
        this.location += amount;
        System.out.println("moving " + name + " to " + location);
    }
}
