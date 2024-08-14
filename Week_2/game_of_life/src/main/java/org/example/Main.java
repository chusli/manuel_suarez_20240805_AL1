package org.example;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");
        Game game = new Game(3, 3);
        game.init(List.of(new Coordinate(1, 1)));

    }

}