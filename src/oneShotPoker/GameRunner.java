package oneShotPoker;

import oneShotPoker.Game;

public class GameRunner {
    public static void main(String[] args) {
        System.out.println("One Shot Poker is running...");

        Game currentGame = new Game();

        currentGame.setNumOfPlayers(2);
        currentGame.runGame();

        // responsible for running the game loop, the Game class itself handles its implementation of poker
        // this should be some of the most concise code outside of Card


    }
}