package org.example;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private final int x_lmit;

    private final int y_limit;

    private List<Cell> cells = new ArrayList<>();

    public Game(int x, int y) {
        x_lmit = x;
        y_limit = y;
    }

    public void init(List<Coordinate> aliveCells) {
        for (int y = 0; y < y_limit; y++) {
            for (int x = 0; x < x_lmit; x++) {
                int finalX = x;
                int finalY = y;
                cells.add(new Cell(new Coordinate(x, y), aliveCells.stream().anyMatch(cell -> cell.x() == finalX && cell.y() == finalY)));
            }
        }
    }

    public String print() {
        StringBuilder stringBuilder = new StringBuilder();
        int index = 0;
        for (Cell cell : cells) {
            stringBuilder.append(cell.alive() ? "❤" : "💀");
            index = index == x_lmit - 1 ? 0 : index + 1;
            if (index == 0) {
                stringBuilder.append("\n");
            }

        }
        return stringBuilder.toString();
    }

    public void play() {
        List<Cell> nextGeneration = new ArrayList<>();

        for (Cell cell : cells) {
            List<Cell> neighbours = getNeighours(cell.coordinate());
            long aliveNeighbours = neighbours.stream().filter(Cell::alive).count();
            boolean survives = false;
            if (cell.alive() && aliveNeighbours < 2) {
                survives = false;
            } else if (cell.alive() && (aliveNeighbours == 2 || aliveNeighbours == 3)) {
                survives = true;
            } else if (cell.alive() && aliveNeighbours > 3) {
                survives = false;
            } else if (!cell.alive() && aliveNeighbours == 3) {
                survives = true;
            }
            nextGeneration.add(new Cell(cell.coordinate(), survives));
        }
        cells = nextGeneration;
    }

    private List<Cell> getNeighours(Coordinate targetCell) {
        return cells.stream()
                .filter(cell -> cell.coordinate().x() != targetCell.x() && cell.coordinate().y() != targetCell.y()) // not cell itself
                .filter(cell -> targetCell.x() - 1 <= cell.coordinate().x() && targetCell.x() + 1 >= cell.coordinate().x()) // x coordinate +/- 1 of target
                .filter(cell -> targetCell.y() - 1 <= cell.coordinate().y() && targetCell.y() + 1 >= cell.coordinate().y()) // y coordinate +/- 1 of target
                .toList();
    }

    public List<Cell> getCells() {
        return cells;
    }

}
