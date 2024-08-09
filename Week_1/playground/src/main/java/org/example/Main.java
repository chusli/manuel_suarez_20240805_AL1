package org.example;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");
        Player player1 = new Player(100);
        Player player2 = new Player(100);
        Game game = new Game(player1, player2);

        while (game.allPlayersAlive()) {
            game.playTurn();
        }
        game.gameOver();
    }

}