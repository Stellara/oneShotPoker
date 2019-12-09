package oneShotPoker;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    //TODO: clean up
    private ArrayList<Card> cards = new ArrayList<>();

    private ArrayList<Card> giveDealerDeck() {
        return this.cards;
    }

    private void buildNewDeck() {
        for (Card.Suits suit : Card.Suits.values()) {
            for (Card.Ranks rank : Card.Ranks.values()) {
                Card currentlyBuiltCard = new Card(suit, rank);
                cards.add(currentlyBuiltCard);
            }
        }
    }

    private void shuffleDeck() {
        Collections.shuffle(this.cards);
    }

    //Helper method.
    //TODO: remove
    public void validateDeck() {
        System.out.println("Validating cards in deck...");
        System.out.println("Deck size: " + cards.size());
        for(int i=0; i < cards.size(); i++){
            System.out.println("Rank: " + cards.get(i).getRank());
            System.out.println("Suit: " + cards.get(i).getSuit());
        }
        //add in set functionality so we know each card is unique
    }

    public void setupNewDeck() {
        buildNewDeck();
        shuffleDeck();
        giveDealerDeck();
    }
}

