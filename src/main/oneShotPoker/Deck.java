package main.oneShotPoker;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> cards = new ArrayList<>();

    public ArrayList<Card> giveDealerDeck() {
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

    public void setupNewDeck() {
        buildNewDeck();
        shuffleDeck();
    }
}

