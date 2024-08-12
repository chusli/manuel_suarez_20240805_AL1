package org.example;

public class Cell {

    private boolean isAlive;

    public Cell(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public void toggle() {
        isAlive = !isAlive;
    }

    public boolean getAlive() {
        return isAlive;
    }

}
