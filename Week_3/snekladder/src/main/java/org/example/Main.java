package org.example;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");

        Player player1 = new Player("one");
        Player player2 = new Player("two");
        Game game = new Game(player1, player2, new Ladder(5, 12), new Snake(13, 7));

        while (!game.over()) {
            game.play(new RandomDie(), new RandomDie());
        }
    }

}