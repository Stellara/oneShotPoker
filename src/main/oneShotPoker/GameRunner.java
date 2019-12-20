package main.oneShotPoker;

public class GameRunner {
    public static void main(String[] args) {
        System.out.println("One Shot Poker is running...");
        Game currentGame = new Game();
        currentGame.setNumOfPlayers(2);
        currentGame.runGame();
    }
}