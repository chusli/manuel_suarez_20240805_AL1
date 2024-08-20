package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Player player = new Player("name");
        Player player2 = new Player("name2");

        Game game = new Game(player, player2);

    }
}