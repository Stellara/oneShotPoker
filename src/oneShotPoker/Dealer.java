package oneShotPoker;

public class Dealer {
    private Deck gameDeck = new Deck();
    private HandRanker ranker = new HandRanker();
    private Player[] currentPlayers;

    public void seatPlayers(Player[] players) {
        this.currentPlayers = players;
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
            hand.setNewCard(drawnCard);
        }
        return hand;
    }

    public void dealHands() {
        gameDeck.setupNewDeck();

        for (Player currentlyDealingPlayer : currentPlayers) {
            System.out.println("Drawing hand for " + currentlyDealingPlayer.getPlayerName());
            currentlyDealingPlayer.setCurrentHandOfCards(drawHand(5));
            currentlyDealingPlayer.getCurrentHandInformation().printCards();
        }
    }

    public void rankHands() {
        for (Player currentlyRankingPlayer: currentPlayers) {
            System.out.println("Ranking hand for " + currentlyRankingPlayer);
            ranker.assignHandWorth(currentlyRankingPlayer);
        }
    }

    //compare hands
    private void compareHands(){
        System.out.println("Comparing hands...");
        Player player1 = currentPlayers[0];
        Player player2 = currentPlayers[1];
        HandOfCards player1HandInfo = player1.getCurrentHandInformation();
        HandOfCards player2HandInfo = player2.getCurrentHandInformation();
        int player1HandWorth = player1HandInfo.getCurrentHandWorth();
        int player2HandWorth = player2HandInfo.getCurrentHandWorth();
        String player1HandName = player1HandInfo.getCurrentHandRankName();
        String player2HandName = player2HandInfo.getCurrentHandRankName();
        int sizeOfAHand = 5;

        System.out.println("Player 1 internal hand score: " + player1HandWorth);
        System.out.println("Player 2 internal hand score: " + player2HandWorth);

        if(player1HandWorth > player2HandWorth ) {
            player1.setWinner(true);
            System.out.println("Player 1 is the winner!");
            System.out.println("Player 1 wins with " + player1HandName + "!");
            player1HandInfo.printBestCards();
            System.out.println("Player 2 loses with " + player2HandName + "!");
            player2HandInfo.printBestCards();
        } else if (player2HandWorth > player1HandWorth) {
            player2.setWinner(true);
            System.out.println("Player 2 is the winner!");
            System.out.println("Player 2 wins with " + player2HandName + "!");
            player2HandInfo.printBestCards();
            System.out.println("Player 1 loses with " + player1HandName + "!");
            player1HandInfo.printBestCards();
        } else {
            System.out.println("It's a tie! Going into edge cases...");
            //TODO: pull this logic out into high card tie breaker, since I will have to reuse it
            if(player1HandName == "High Card" && player2HandName == "High Card"){
                System.out.println("Both players have a high card!");

                for(int i=0; i < sizeOfAHand; i++) {
                    if(player1HandInfo.getBestCards().get(i).getRankWorth() > player2HandInfo.getBestCards().get(i).getRankWorth()) {
                        player1.setWinner(true);
                        System.out.println("Player 1 is the winner!");
                        System.out.println("Player 1 wins with " + player1HandInfo.getBestCards().get(i).getRank() + " " + player1HandInfo.getBestCards().get(i).getSuit() + "!");
                        System.out.println("Player 2 loses with " + player2HandInfo.getBestCards().get(i).getRank() + " " + player2HandInfo.getBestCards().get(i).getSuit() + "!");
                        break;
                    } else if (player2HandInfo.getBestCards().get(0).getRankWorth() > player1HandInfo.getBestCards().get(i).getRankWorth()) {
                        player2.setWinner(true);
                        System.out.println("Player 2 is the winner!");
                        System.out.println("Player 2 wins with " + player2HandInfo.getBestCards().get(i).getRank() + " " + player2HandInfo.getBestCards().get(i).getSuit() + "!");
                        System.out.println("Player 1 loses with " + player1HandInfo.getBestCards().get(i).getRank() + " " + player1HandInfo.getBestCards().get(i).getSuit() + "!");
                        break;
                    }
                }
            } else if(player1HandName == "Pair" && player2HandName == "Pair") {

                Card player1HighCard = ranker.getHighCard(player1HandInfo.getCards()).get(0);
                Card player2HighCard = ranker.getHighCard(player2HandInfo.getCards()).get(0);
                System.out.println("Both players have a pair!");
                if(player1HandInfo.getBestCards().get(0).getRankWorth() > player2HandInfo.getBestCards().get(0).getRankWorth()) {
                    System.out.println("Player 1 is the winner!");
                    System.out.println("Player 1 wins with a pair of " + player1HandInfo.getBestCards().get(0).getRank() + " " + player1HandInfo.getBestCards().get(0).getSuit() + "!");
                    System.out.println("Player 2 loses with a pair of " + player2HandInfo.getBestCards().get(0).getRank() + " " + player2HandInfo.getBestCards().get(0).getSuit() + "!");
                }  else if(player2HandInfo.getBestCards().get(0).getRankWorth() > player1HandInfo.getBestCards().get(0).getRankWorth()) {
                    System.out.println("Player 2 is the winner!");
                    System.out.println("Player 2 wins with a pair of " + player2HandInfo.getBestCards().get(0).getRank() + " " + player2HandInfo.getBestCards().get(0).getSuit() + "!");
                    System.out.println("Player 1 loses with a pair of " + player1HandInfo.getBestCards().get(0).getRank() + " " + player1HandInfo.getBestCards().get(0).getSuit() + "!");
                } else {
                    System.out.println("Both players' pairs are ties...");
                    if (player1HighCard.getRankWorth() > player2HighCard.getRankWorth()) {
                        System.out.println("Player 1 wins with ");
                        player1HighCard.printCardInfo();
                        System.out.println("Player 2 loses with ");
                        player2HighCard.printCardInfo();
                    } else if (player2HighCard.getRankWorth() > player1HighCard.getRankWorth()) {
                        System.out.println("Player 2 wins with ");
                        player2HighCard.printCardInfo();
                        System.out.println("Player 1 loses with ");
                        player1HighCard.printCardInfo();
                    }
                }
            }
        }
    }

   public void judgeWinner() {
        rankHands();
       System.out.println("Judging winner of the game...");
       compareHands();
   }

    //declare winner
        //rankHands
        //compare hands
        //set winner
}
