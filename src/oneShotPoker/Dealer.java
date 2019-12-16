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
            System.out.println("Drawing hand for " + currentlyDealingPlayer);
            currentlyDealingPlayer.setCurrentHandOfCards(drawHand(5));
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
        
    }

    //set a winner

    //declare winner
        //rankHands
        //compare hands
        //set winner
}
