package org.example;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");
        Coordinate coordinate = new Coordinate(1, 1);

        Game game = new Game(3, 3);
        game.init(coordinate);
    }

}