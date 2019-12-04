package oneShotPoker;

import oneShotPoker.Card;

public class Deck {
    //TODO: refactor
    private Card[] deck = new Card[52];

    private Card[] createBlankDeck() {
        for (int i = 0; i < 52; i++) {
            Card blankCard = new Card();
            deck[i] = blankCard;
       }
        return deck;
    }

    public Card[] getDeckOfCards() {
        return createBlankDeck();
    }




    public void assignSuit(char suit) {

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

