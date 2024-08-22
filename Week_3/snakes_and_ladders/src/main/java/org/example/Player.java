package org.example;

public class Player {

    private final String name;

    private int location = 0;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }

    public void goTo(int target) {
        System.out.println(name + " teleports to " + target);
        location = target;
    }

    public boolean sitsOn(Teleporter teleporter) {
        return location == teleporter.source();
    }

    public void move(int amount, int limit) {
        if (location + amount > limit) {
            location = 2 * limit - (location + amount);
        } else {
            location += amount;
        }
        System.out.println(name + " now sits on " + location);
    }

}
