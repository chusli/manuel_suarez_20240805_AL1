package org.example;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private final List<List<Cell>> cells;

    private final List<CoordinatedCell> cooridnatedCells = new ArrayList<>();

    public Game(List<List<Cell>> cells) {
        this.cells = cells;
        int y = 0;
        for (List<Cell> cell : cells) {
            int x = 0;
            for (Cell horizontalCell : cell) {
                cooridnatedCells.add(new CoordinatedCell(horizontalCell, x, y));
                x++;
            }
            y++;
        }
    }

    public long getAliveNeighbours(int x, int y) {
        return cooridnatedCells
                .stream()
                .filter(c -> c.x() != x || c.y() != y)
                .filter(c -> Math.abs(c.x() - x) <= 1)
                .filter(c -> Math.abs(c.y() - y) <= 1)
                .filter(c -> c.cell().getAlive())
                .count();
    }

}
