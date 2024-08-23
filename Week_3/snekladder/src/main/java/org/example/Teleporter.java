package org.example;

public abstract class Teleporter {

    private final int source;

    private final int destination;

    public Teleporter(int source, int destination) {
        this.source = source;
        this.destination = destination;
    }

    public int getSource() {
        return source;
    }

    public int getDestination() {
        return destination;
    }

    public void applyTo(Player player) {
        String name = getClass().getSimpleName();
        System.out.println(player.getName() + " hit a " + name + " and goes from " + source + " to " + destination);
        player.move(destination - player.getLocation());
    }

    public boolean isBeingSatOnBy(Player player) {
        return source == player.getLocation();
    }

}
