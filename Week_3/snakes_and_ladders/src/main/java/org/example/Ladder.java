package org.example;

public class Ladder {
    private final int source;
    private final int target;

    public int getSource() {
        return source;
    }

    public int getTarget() {
        return target;
    }

    public Ladder(int source, int target) {
        this.source = source;
        this.target = target;
    }
}
