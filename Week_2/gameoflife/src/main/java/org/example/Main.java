package org.example;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");

        Game game = new Game(10, 10);
        game.init(List.of(new Coordinate(1, 1), new Coordinate(3, 3), new Coordinate(5, 8)));
        System.out.println(game.print());
    }

}