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
        location += amount;
    }

    public void goTo(int target) {
        location = target;
    }

    public boolean sitsOn(Teleporter teleporter) {
        return location == teleporter.source();
    }

}
