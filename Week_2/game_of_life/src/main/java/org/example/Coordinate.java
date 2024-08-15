package org.example;

public record Coordinate(int x, int y) {

    public boolean neighbours(Coordinate coordinate) {
        if (coordinate.x() == x && coordinate.y() == y) {
            return false;
        }
        if (Math.abs(coordinate.x() - x) > 1) {
            return false;
        }
        if (Math.abs(coordinate.y() - y) > 1) {
            return false;
        }
        return true;
    }

}
