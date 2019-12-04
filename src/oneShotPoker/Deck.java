package oneShotPoker;

import oneShotPoker.Card;
import java.util.Arrays;

public class Deck {
    //TODO: refactor
    private static Card[] deck = new Card[52];
    private static char[] cardValues = {'1', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A'};
    public static Card[] filledAndShuffledDeck;


    private static Card[] createBlankDeck() {
        for (int i = 0; i < deck.length; i++) {
            Card blankCard = new Card();
            deck[i] = blankCard;
       }
        return deck;
    }

    private static void assignValues(){
        for(int i = 0; i < deck.length; i += 13) {
            for(int j = 0; j < cardValues.length; j++) {
                System.out.println("Printing the value of the current index:" + j + " into cardValues...");
                System.out.println(cardValues[j]);
                
                System.out.println("Printing what the value of the i iterator is...");
                System.out.println(i);

                deck[i].setValue(cardValues[j]);
            }
        }
    }

    private void assignSuit(char suit) {
        //iterate over a chunk of array, 13 places
        // does it have a suit?
        // yes, move on to next 13
        // no, assign it an unused suit
        // what is an unused suit?

    }

    public static void assignSuitsAndValues() {

    }

    public static void shuffleDeck() {

    }

    public static void fillAndShuffleDeck() {
        assignSuitsAndValues();
        shuffleDeck();
    }

    public static Card[] getDeckOfCards() {
        filledAndShuffledDeck = createBlankDeck();
        assignValues();
        return filledAndShuffledDeck;

        // end goal:
        // fillAndShuffledDeck = filledAndShuffledDeck();
        // return filledAndShuffledDeck;
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

