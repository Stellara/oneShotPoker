package oneShotPoker;

import oneShotPoker.Card;

public class Deck {
    //TODO: refactor
    private static Card[] deck = new Card[52];
    public static Card[] filledAndShuffledDeck;

    private static Card[] createBlankDeck() {
        for (int i = 0; i < 52; i++) {
            Card blankCard = new Card();
            deck[i] = blankCard;
       }
        return deck;
    }

    public static Card[] getDeckOfCards() {
        filledAndShuffledDeck = createBlankDeck();
        return filledAndShuffledDeck;
    }




    private void assignSuit(char suit) {
        //iterate over a chunk of array, 13 places
            // does it have a suit?
            // yes, move on to next 13
            // no, assign it an unused suit
                // what is an unused suit?

    }



    //DS to hold all the values
    // assignSuits(suit);
    // card setters, 13 times
    //assign suit(S);
    //assign suit(D);
    //assign suit(C);

    //assignValues

    // fillHearts();
    // assign suit to 13 cards (13 times)

    //return the array deck

    //shuffling the oneShotPoker.Deck is not the oneShotPoker.Deck's responsbility, it is the GameRunners
}

