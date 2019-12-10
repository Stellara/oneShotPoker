package oneShotPoker;

import oneShotPoker.Card;
import oneShotPoker.Deck;
import oneShotPoker.Player;

import java.util.ArrayList;
import java.util.Arrays;

public class Game{
        //TODO: this will probably get bloated with methods real fast, pull out into fitting classes
        private int numOfPlayers;
        private Player[] currentPlayers;

        //TODO: give better name than gameDeck
        private Deck gameDeck = new Deck();

        public void setNumOfPlayers(int requestedNumOfPlayers){
            this.numOfPlayers = requestedNumOfPlayers;
        }

        private Player[] getPlayers(int numOfPlayers) {
            currentPlayers = new Player[numOfPlayers];

            for (int i = 0; i < numOfPlayers; i++) {
                Player nextSeatingPlayer = new Player();
                currentPlayers[i] = nextSeatingPlayer;
            }
            return currentPlayers;
        }

        //TODO: refactor
        private HandOfCards drawHand(int handSize) {
            System.out.println("Drawing hand...");
            HandOfCards hand = new HandOfCards();
            Card drawnCard;

            for(int i=0; i < handSize; i++) {
                //TODO: cleaner way to implement this, like ruby pop?
                drawnCard = gameDeck.giveDealerDeck().get(i);
                gameDeck.giveDealerDeck().remove(i);
                hand.add(drawnCard);
            }
            return hand;
        }

        private void dealHands() {
            for (Player currentlyDealingPlayer : currentPlayers) {
                System.out.println("Drawing hand for " + currentlyDealingPlayer);
                currentlyDealingPlayer.setCurrentHandOfCards(drawHand(5));
            }
        }

        public void runGame(){
            //TODO: Pull all text strings out into other methods and constants? eg: greetPlayers, etc
            System.out.println("Running a brand new game...");
            System.out.println("The number of players for this game is: ");
            System.out.println(this.numOfPlayers);

            //Main Game loop
            currentPlayers = getPlayers(2);
            gameDeck.setupNewDeck();
            gameDeck.validateDeck();
            dealHands();

            //TODO: helper debugging statements, remove
            for (Player currentlyDealingPlayer : currentPlayers) {
                System.out.println("The current player is " + currentlyDealingPlayer);
                System.out.println("Validating current player's hand...");
                System.out.println(currentlyDealingPlayer.getCurrentHandOfCards());
                for(Card currentCardInHand: currentlyDealingPlayer.getCurrentHandOfCards()){
                    System.out.print(currentCardInHand.getRank() + " ");
                    System.out.println(currentCardInHand.getSuit() + " ");
                }
            }
        }

        // TODO: implement MAIN GAME LOOP
        // X set num of players
        // X get deck
        // X deal hands to players
        // _ rank hands with an internal value or something similar?
        // _ compare players hands
        // _ choose winner
        // _ set winner
            // Player.isWinner(true);
        // _ output outcome
        // _ record stats *extra*
        // _ end game
        // _ play again or exit?
}
