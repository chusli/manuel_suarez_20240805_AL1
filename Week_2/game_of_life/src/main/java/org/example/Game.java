package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {

    private final int xLimit;

    private final int yLimit;

    private final List<Coordinate> aliveCells = new ArrayList<>();

    public Game(int xLimit, int yLimit) {
        this.xLimit = xLimit;
        this.yLimit = yLimit;
    }

    public void init(Coordinate... coordinate) {
        aliveCells.addAll(Arrays.stream(coordinate).toList());
    }

    public List<Coordinate> getAliveCells() {
        return aliveCells;
    }

    public void play() {
        List<Coordinate> nextGeneration = new ArrayList<>();
        for (int y = 0; y < yLimit; y++) {
            for (int x = 0; x < xLimit; x++) {
                Coordinate candidate = new Coordinate(x, y);
                long aliveNeighbours = aliveCells.stream()
                        .filter(aliveCells -> aliveCells.neighbours(candidate))
                        .count();
                boolean isCandidateAlive = isCandidateAlive(candidate);
                if (isCandidateAlive && (aliveNeighbours == 2 || aliveNeighbours == 3)) {
                    nextGeneration.add(candidate);
                } else if (!isCandidateAlive && aliveNeighbours == 3) {
                    nextGeneration.add(candidate);
                }
            }
        }
        aliveCells.clear();
        aliveCells.addAll(nextGeneration);
    }

    private boolean isCandidateAlive(Coordinate candidate) {
        return aliveCells.stream().anyMatch(candidate::equals);
    }

    public List<String> print() {
        List<String> output = new ArrayList<>();
        for (int y = 0; y < yLimit; y++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int x = 0; x < xLimit; x++) {
                if (isCandidateAlive(new Coordinate(x, y))) {
                    stringBuilder.append("o");
                } else {
                    stringBuilder.append(".");
                }
            }
            output.add(stringBuilder.toString());
        }
        return output;
    }

}
