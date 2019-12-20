package main.oneShotPoker;

import java.util.Scanner;

public class GameRunner {
    public static void main(String[] args) {
        Scanner command = new Scanner(System.in);
        Dealer.greetPlayer();
        boolean firstGreeting = false;

        String playerInput = "";
        while(!playerInput.equalsIgnoreCase("no"))
        {
            if(firstGreeting){
                System.out.println("Would you like to play again?");
            } else {
                System.out.println("Would you like to play?");
                firstGreeting = true;
            }
            playerInput = command.nextLine();
            switch(playerInput){
                case "yes":
                    Game currentGame = new Game();
                    currentGame.setNumOfPlayers(2);
                    currentGame.runGame();
                    break;
                case "no":
                    System.out.println("Quitting the game and packing up! Thanks for playing!");
                    break;
                default:
                    System.out.println("I'm not sure what you're trying to do. Please try again!");
                    break;
            }
        }
    }
}