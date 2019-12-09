package oneShotPoker;

import oneShotPoker.Card;
import oneShotPoker.Deck;
import oneShotPoker.Player;
import java.util.Arrays;

public class Game{
        //TODO: this will probably get bloated with methods real fast, pull out into fitting classes
        private int numOfPlayers;
        private Player[] currentPlayers = new Player[numOfPlayers];
        //TODO: give better name than gameDeck
        private Deck gameDeck = new Deck();

        public void setNumOfPlayers(int requestedNumOfPlayers){
            this.numOfPlayers = requestedNumOfPlayers;
        }

        //TODO: fix this
        private Player[] getPlayers(int numOfPlayers) {
            for (int i = 0; i < numOfPlayers; i++) {
                Player nextSeatingPlayer = new Player();
//                currentPlayers[i] = nextSeatingPlayer;
            }
            return currentPlayers;
        }

        public void runGame(){
            //TODO: Pull all text strings out into other methods and constants? eg: greetPlayers, etc
            System.out.println("Running a brand new game...");
            System.out.println("The number of players for this game is: ");
            System.out.println(this.numOfPlayers);

            currentPlayers = getPlayers(2);
            gameDeck.setupNewDeck();
            gameDeck.validateDeck();
        }

        // TODO: implement MAIN GAME LOOP
        // set num of players
        // get deck
        // deal hands to players
        // rank hands with an internal value or something similar?
        // compare players hands
        // choose winner
        // set winner
        // Player.isWinner(true);
        // output outcome
        // record stats *extra*
        // end game
        // play again or exit?
}
