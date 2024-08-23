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

}
