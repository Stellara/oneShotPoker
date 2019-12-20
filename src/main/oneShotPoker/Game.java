package main.oneShotPoker;

public class Game{
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
                nextSeatingPlayer.setPlayerName(i);
            }
            return currentPlayers;
        }

        public void runGame(){
            System.out.println("Running a brand new game...");
            System.out.println("The number of players for this game is: ");
            System.out.println(this.numOfPlayers);

            //Main Game actions
            currentPlayers = getPlayers(2);
            dealer.seatPlayers(currentPlayers);
            dealer.dealHands();
            dealer.judgeWinner();
        }
}
