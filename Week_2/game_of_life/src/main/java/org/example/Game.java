package org.example;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private final int xLimit;

    private final int yLimit;

    private final List<Coordinate> aliveCells = new ArrayList<>();

    public Game(int x_limit, int y_limit) {
        xLimit = x_limit;
        yLimit = y_limit;
    }

    public void init(List<Coordinate> coordinates) {
        aliveCells.addAll(coordinates);
    }

    public void play() {
        ArrayList<Coordinate> nextGeneration = new ArrayList<>();
        for (int y = 0; y < yLimit; y++) {
            for (int x = 0; x < xLimit; x++) {
                int finalX = x;
                int finalY = y;
                Coordinate currentCoordinate = new Coordinate(finalX, finalY);
                long aliveNeighbours = aliveCells.stream()
                        .filter(coordinate -> coordinate.neighbours(currentCoordinate))
                        .count();
                boolean isAlive = aliveCells.stream()
                        .anyMatch(coordinate -> coordinate.x() == finalX && coordinate.y() == finalY);
                if (isAlive && (aliveNeighbours == 2 || aliveNeighbours == 3)) {
                    nextGeneration.add(new Coordinate(x, y));
                } else if (!isAlive && aliveNeighbours == 3) {
                    nextGeneration.add(new Coordinate(x, y));
                }
            }
        }
        aliveCells.clear();
        aliveCells.addAll(nextGeneration);
    }

    public List<Coordinate> getAliveCells() {
        return aliveCells;
    }

}