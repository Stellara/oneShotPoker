package main.oneShotPoker;

public class Dealer {
    private Deck gameDeck = new Deck();
    private HandRanker ranker = new HandRanker();
    private Player[] currentPlayers;
    private Player player1;
    private Player player2;
    private HandOfCards player1HandInfo;
    private HandOfCards player2HandInfo;
    private int sizeOfAHand = 5;

    public static void greetPlayer() {
        System.out.println("Welcome to One Shot Poker, the quick single hand poker game!");
        System.out.println("In this pared down version of poker, two players will be dealt a hand of five cards.");
        System.out.println("The dealer (that's me!) will rank your hands and the player with the better hand of cards wins!");
    }

    public void seatPlayers(Player[] players) {
        this.currentPlayers = players;
    }

    private HandOfCards drawHand(int handSize) {
        HandOfCards hand = new HandOfCards();
        Card drawnCard;

        for(int i=0; i < handSize; i++) {
            drawnCard = gameDeck.giveDealerDeck().get(i);
            gameDeck.giveDealerDeck().remove(i);
            hand.setNewCard(drawnCard);
        }
        return hand;
    }

    public void dealHands() {
        gameDeck.setupNewDeck();

        for (Player currentlyDealingPlayer : currentPlayers) {
            System.out.println("Drawing hand for " + currentlyDealingPlayer.getPlayerName() + "...");
            currentlyDealingPlayer.setCurrentHandOfCards(drawHand(5));
            currentlyDealingPlayer.getCurrentHandInformation().printCards();
        }
    }

    public void rankHands() {
        for (Player currentlyRankingPlayer: currentPlayers) {
            ranker.assignHandWorth(currentlyRankingPlayer);
        }
    }

    private void compareHighCards(int positionOfCardToCheck) {
        if(player1HandInfo.getBestCards().get(positionOfCardToCheck).getRankWorth() > player2HandInfo.getBestCards().get(positionOfCardToCheck).getRankWorth()) {
            player1.setWinner(true);
            System.out.println("Player 1 is the winner!");
            System.out.println("Player 1 wins with " + player1HandInfo.getBestCards().get(positionOfCardToCheck).getRank() + " " + player1HandInfo.getBestCards().get(positionOfCardToCheck).getSuit() + "!");
            System.out.println("Player 2 loses with " + player2HandInfo.getBestCards().get(positionOfCardToCheck).getRank() + " " + player2HandInfo.getBestCards().get(0).getSuit() + "!");
        } else if (player2HandInfo.getBestCards().get(positionOfCardToCheck).getRankWorth() > player1HandInfo.getBestCards().get(positionOfCardToCheck).getRankWorth()) {
            player2.setWinner(true);
            System.out.println("Player 2 is the winner!");
            System.out.println("Player 2 wins with " + player2HandInfo.getBestCards().get(positionOfCardToCheck).getRank() + " " + player2HandInfo.getBestCards().get(positionOfCardToCheck).getSuit() + "!");
            System.out.println("Player 1 loses with " + player1HandInfo.getBestCards().get(positionOfCardToCheck).getRank() + " " + player1HandInfo.getBestCards().get(positionOfCardToCheck).getSuit() + "!");
        } else {
            System.out.println("Both players still tie! There is no winner.");
        }
    }

    private void compareMatchedMultiples(String handName) {
        player1 = currentPlayers[0];
        player2 = currentPlayers[1];
        player1HandInfo = player1.getCurrentHandInformation();
        player2HandInfo = player2.getCurrentHandInformation();
        Card player1HighCard = ranker.getHighCard(player1HandInfo.getCards()).get(0);
        Card player2HighCard = ranker.getHighCard(player2HandInfo.getCards()).get(0);
        System.out.println("Both players have a " + handName + "!");
        if(player1HandInfo.getBestCards().get(0).getRankWorth() > player2HandInfo.getBestCards().get(0).getRankWorth()) {
            player1.setWinner(true);
            System.out.println("Player 1 is the winner!");
            System.out.println("Player 1 wins with a " + handName + " of " + player1HandInfo.getBestCards().get(0).getRank() + " " + player1HandInfo.getBestCards().get(0).getSuit() + "!");
            System.out.println("Player 2 loses with a " + handName + " of "  + player2HandInfo.getBestCards().get(0).getRank() + " " + player2HandInfo.getBestCards().get(0).getSuit() + "!");
        }  else if(player2HandInfo.getBestCards().get(0).getRankWorth() > player1HandInfo.getBestCards().get(0).getRankWorth()) {
            player2.setWinner(true);
            System.out.println("Player 2 is the winner!");
            System.out.println("Player 2 wins with a " + handName + " of " + player2HandInfo.getBestCards().get(0).getRank() + " " + player2HandInfo.getBestCards().get(0).getSuit() + "!");
            System.out.println("Player 1 loses with a " + handName + " of " + player1HandInfo.getBestCards().get(0).getRank() + " " + player1HandInfo.getBestCards().get(0).getSuit() + "!");
        } else {
            System.out.println("Both players' " + handName + "are ties...");
            if (player1HighCard.getRankWorth() > player2HighCard.getRankWorth()) {
                player1.setWinner(true);
                System.out.println("Player 1 wins with ");
                player1HighCard.printCardInfo();
                System.out.println("Player 2 loses with ");
                player2HighCard.printCardInfo();
            } else if (player2HighCard.getRankWorth() > player1HighCard.getRankWorth()) {
                player2.setWinner(true);
                System.out.println("Player 2 wins with ");
                player2HighCard.printCardInfo();
                System.out.println("Player 1 loses with ");
                player1HighCard.printCardInfo();
            }
        }
    }

    private void compareHands(){
        Player player1 = currentPlayers[0];
        Player player2 = currentPlayers[1];
        HandOfCards player1HandInfo = player1.getCurrentHandInformation();
        HandOfCards player2HandInfo = player2.getCurrentHandInformation();
        int player1HandWorth = player1HandInfo.getCurrentHandWorth();
        int player2HandWorth = player2HandInfo.getCurrentHandWorth();
        String player1HandName = player1HandInfo.getCurrentHandRankName();
        String player2HandName = player2HandInfo.getCurrentHandRankName();

        if(player1HandWorth > player2HandWorth) {
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
            System.out.println("It's a tie! Let's look at the tie breakers...");
            if(player1HandName == "High Card" && player2HandName == "High Card"){
                System.out.println("Both players have a high card!");
                for(int i=(sizeOfAHand-1); i > 0; i--) {
                    if(player1HandInfo.getCards().get(i).getRankWorth() > player2HandInfo.getCards().get(i).getRankWorth()) {
                        player1.setWinner(true);
                        System.out.println("Player 1 is the winner!");
                        System.out.println("Player 1 wins with " + player1HandInfo.getCards().get(i).getRank() + " " + player1HandInfo.getCards().get(i).getSuit() + "!");
                        System.out.println("Player 2 loses with " + player2HandInfo.getCards().get(i).getRank() + " " + player2HandInfo.getCards().get(i).getSuit() + "!");
                        break;
                    } else if (player2HandInfo.getCards().get(i).getRankWorth() > player1HandInfo.getCards().get(i).getRankWorth()) {
                        player2.setWinner(true);
                        System.out.println("Player 2 is the winner!");
                        System.out.println("Player 2 wins with " + player2HandInfo.getCards().get(i).getRank() + " " + player2HandInfo.getCards().get(i).getSuit() + "!");
                        System.out.println("Player 1 loses with " + player1HandInfo.getCards().get(i).getRank() + " " + player1HandInfo.getCards().get(i).getSuit() + "!");
                        break;
                    } else {
                        System.out.println("Both players have the same high card!");
                        System.out.println("Comparing both players' next highest card!");
                    }
                }
            } else if(player1HandName == "Pair" && player2HandName == "Pair") {
                  compareMatchedMultiples("Pair");
            } else if(player1HandName == "Two Pair" && player2HandName == "Two Pair") {
                System.out.println("Both players have two pair!");
                compareHighCards(4);
                if (!player1.isWinner() && !player2.isWinner()) {
                    compareHighCards(2);
                    if(!player1.isWinner() && !player2.isWinner()) {
                        compareHighCards(0);
                    }
                }
            } else if(player1HandName == "Three of a Kind" && player2HandName == "Three of a Kind") {
                System.out.println("Both players have three of a kind!");
                compareHighCards(4);
            } else if(player1HandName == "Straight" && player2HandName == "Straight") {
                System.out.println("Both players have a straight!");
                compareHighCards(sizeOfAHand-1);
            } else if(player1HandName == "Flush" && player2HandName == "Flush") {
                System.out.println("Both players have a flush!");
                compareHighCards(sizeOfAHand-1);
            } else if(player1HandName == "Full House" && player2HandName == "Full House") {
                System.out.println("Both players have a full house!");
                compareMatchedMultiples("Full House");
            } else if(player1HandName == "Four of a Kind" && player2HandName == "Four of a Kind") {
                System.out.println("Both players have a four of a kind!");
                compareHighCards(3);
            } else if(player1HandName == "Straight Flush" && player2HandName == "Straight Flush") {
                System.out.println("Both players have a straight flush!");
                compareHighCards(4);
            }
        }
    }

   public void judgeWinner() {
        rankHands();
        System.out.println("Judging winner of the game...");
        compareHands();
   }
}
