package oneShotPoker;

public class Game{
        //TODO: this will probably get bloated with methods real fast, pull out into fitting classes
        private int numOfPlayers;
        private Player[] currentPlayers;
        private Dealer dealer = new Dealer();

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

        public void runGame(){
            //TODO: Pull all text strings out into other methods and constants? eg: greetPlayers, etc
            System.out.println("Running a brand new game...");
            System.out.println("The number of players for this game is: ");
            System.out.println(this.numOfPlayers);

            //Main Game loop
            //TODO: refactor this call to take input from the GameRunner
            currentPlayers = getPlayers(2);

            dealer.seatPlayers(currentPlayers);
            dealer.dealHands();

            //TODO: helper debugging statements, remove
            //TODO: better name than currentlyDealingPlayer
            for (Player currentlyDealingPlayer : currentPlayers) {
                System.out.println("The current player is " + currentlyDealingPlayer);
                System.out.println("Validating current player's hand...");
                System.out.println(currentlyDealingPlayer.getCurrentHandInformation());
                for(Card currentCardInHand: currentlyDealingPlayer.getCurrentHandInformation().getCards()){
                    System.out.print(currentCardInHand.getRank() + " ");
                    System.out.println(currentCardInHand.getSuit() + " ");
                }
            }

            dealer.judgeWinner();
        }

        // TODO: implement MAIN GAME LOOP
        // X set num of players
        // X get deck
        // X deal hands to players
        // X rank hands with an internal value or something similar?
        // _ compare players hands
            // Naive inclination to handle this in HandRanker, but it's not HandRanker's job, that's something else's job
            // TODO: implement a dealer class. That should probably be the dealer's job.
        // _ choose winner
            // This should also probably be the dealer's job...
            // If my hand ranking and worth assigning logic is right...
            // Is the worth of your hand higher than the worth of all other players' hands?
            // Yes? You're the winner.
        // _ set winner
            // This should also probably be the dealer's job...
            // Player.isWinner(true);
        // _ show winner
            // ...and this should ALSO be the dealer's job. The Game calls the Dealer's actions in the loop.
            // declare the winner
            // show the winner's winning hand type and their cards, show the loser's hand type and their cards?
        // _ record stats *extra*
        // _ end game
        // _ play again or exit?
}
