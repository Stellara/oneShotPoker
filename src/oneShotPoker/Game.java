package oneShotPoker;

import oneShotPoker.Card;
import oneShotPoker.Deck;
import oneShotPoker.Player;

public class Game{
        // get players
        private int numOfPlayers;
        private Player[] currentPlayers = new Player[numOfPlayers];


        public void setNumOfPlayers(int requestedNumOfPlayers){
            this.numOfPlayers = requestedNumOfPlayers;
        }

        private Player[] getPlayers(int numOfPlayers) {
            for (int i = 0; i < numOfPlayers; i++) {
                Player nextSeatingPlayer = new Player();
//                currentPlayers[i] = nextSeatingPlayer;
            }
            return currentPlayers;
        }

        public void runGame(){
            System.out.println("Running a brand new game...");
            System.out.println("The number of players for this game is: ");
            System.out.println(this.numOfPlayers);
            currentPlayers = this.getPlayers(2);
        }





    // get a deck
//        Card[] gameDeck = Deck.getDeckOfCards();
//
//        System.out.println("We will be using this deck: ");
//        System.out.println(gameDeck);

        // shuffle deck
        // deal out hands
            /* public static hand dealHand{
            * Card card;

            *  card[] hand;
            *  hand = new card[5];
            */
        // compare hands
        // rank hands
        // choose winner
        // set winner
        // Player.isWinner(true);
        // output outcome
        // record stats }
}
