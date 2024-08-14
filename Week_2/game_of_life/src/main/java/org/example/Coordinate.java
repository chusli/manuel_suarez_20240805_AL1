package org.example;

public record Coordinate(int x, int y) {

    public boolean neighbours(Coordinate coordinate) {
        boolean isEqual = coordinate.x == x && coordinate.y == y;
        boolean isOneAbove = coordinate.y + 1 == y;
        boolean isOneBelow = coordinate.y - 1 == y;
        boolean isOneLeft = coordinate.x - 1 == x;
        boolean isOneRight = coordinate.x + 1 == x;
        return !isEqual && (isOneAbove || isOneBelow || isOneLeft || isOneRight);
    }

}
