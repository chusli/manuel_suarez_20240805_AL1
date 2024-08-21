package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Player player1 = new Player("Player 1");
        Player player2= new Player("Player 2");

        Game game = new Game(player1, player2);
    }
}