package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");

        Game game = new Game(50, 50);
        game.init(
                new Coordinate(1, 5),
                new Coordinate(1, 6),
                new Coordinate(2, 5),
                new Coordinate(2, 6),

                new Coordinate(11, 5),
                new Coordinate(11, 6),
                new Coordinate(11, 7),
                new Coordinate(12, 4),
                new Coordinate(12, 8),
                new Coordinate(13, 3),
                new Coordinate(13, 9),
                new Coordinate(14, 3),
                new Coordinate(14, 9),
                new Coordinate(15, 6),
                new Coordinate(16, 4),
                new Coordinate(16, 8),
                new Coordinate(17, 5),
                new Coordinate(17, 6),
                new Coordinate(17, 7),
                new Coordinate(18, 6),

                new Coordinate(21, 3),
                new Coordinate(21, 4),
                new Coordinate(21, 5),
                new Coordinate(22, 3),
                new Coordinate(22, 4),
                new Coordinate(22, 5),
                new Coordinate(23, 2),
                new Coordinate(23, 6),
                new Coordinate(25, 2),
                new Coordinate(25, 3),
                new Coordinate(25, 7),
                new Coordinate(25, 8),

                new Coordinate(35, 3),
                new Coordinate(35, 4),
                new Coordinate(36, 3),
                new Coordinate(36, 4));

        String input;
        do {
            System.out.flush();
            game.print().forEach(System.out::println);
            game.play();
            Scanner scanner = new Scanner(System.in);
            input = scanner.nextLine();
        } while (!input.equals("exit"));
    }

}