package org.example;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");
        Game game = new Game(new Player("one"), new Player("two"));
        while (!game.gameOver()) {
            game.play(new RandomDie(), new RandomDie());
        }
    }

}