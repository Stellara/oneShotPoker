package oneShotPoker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//TODO: Do I need these explicit imports? More DRY way to access?
import static oneShotPoker.Card.Suits.CLUBS;
import static oneShotPoker.Card.Suits.DIAMONDS;
import static oneShotPoker.Card.Suits.HEARTS;
import static oneShotPoker.Card.Suits.SPADES;


public class HandRanker {
    //Should I big switch that checks each of these?
    // Should I make each of these individual methods, passing in the player's hand?
    //Assigning a rank means that it needs the internal rank value + what kind of semantic hand they have for communications purposes

    /* RANKING RULES
    Straight flush: 5 cards of the same suit with consecutive values. Ranked by the highest card in the hand.

    Four of a kind: 4 cards with the same value. Ranked by the value of the 4 cards.

    Full House: 3 cards of the same value, with the remaining 2 cards forming a pair. Ranked by the value of the 3 cards.

    Flush: Hand contains 5 cards of the same suit. Hands which are both flushes are ranked using the rules for High Card.

    Straight: Hand contains 5 cards with consecutive values. Hands which both contain a straight are ranked by their highest card.

    Three of a Kind: Three of the cards in the hand have the same value. Hands which both contain three of a kind are ranked by the value of the 3 cards.

    Two Pairs: The hand contains 2 different pairs. Hands which both contain 2 pairs are ranked by the value of their highest pair. Hands with the same highest     pair     are ranked by the value of their other pair. If these values are the same the hands are ranked by the value of the remaining card.

    Pair: 2 of the 5 cards in the hand have the same value. Hands which both contain a pair are ranked by the value of the cards forming the pair. If these         values   are the same, the hands are ranked by the values of the cards not forming the pair, in decreasing order.

    High Card: Hands which do not fit any higher category are ranked by the value of their highest card. If the highest cards have the same value, the hands are    ranked   by the next highest, and so on.
     */

    Map<String, Integer> handRankNamesAndWorth = Map.of(
            "Straight Flush", 9,
            "Four of a Kind", 8,
            "Full House", 7,
            "Flush", 6,
            "Straight", 5,
            "Three of a Kind", 4,
            "Two Pairs", 3,
            "Pair", 2,
            "High Card", 1
    );

    private static Map<Card.Suits, Integer> createSuitsCounter() {
        Map<Card.Suits, Integer> suitsCounter = new HashMap<>();
        for (Card.Suits suit : Card.Suits.values()) {
            suitsCounter.put(suit, 0);
        }
        return suitsCounter;
    }

    //TODO: implement value counter method
//    private static Map<String, Integer> createRanksCounter() {
//        Map<String, Integer> ranksCounter = new HashMap<String,Integer>();
//        //loop over enum on Card
//        ranksCounter.put(currentRank, 0);
//
//
//        return ranksCounter;
//    }

    //TODO: refactor
    private Map countSuits(ArrayList<Card> handOfCards) {
        System.out.println("Inside countSuits...");
        Map<Card.Suits, Integer> suitsCounter = createSuitsCounter();

       for(int i=0; i<handOfCards.size(); i++){
           Card.Suits currentCardSuit = handOfCards.get(i).getSuit();

           System.out.println("Checking this suit for each player in countSuits " + currentCardSuit);

           switch(currentCardSuit) {

               case CLUBS:
                   System.out.println("We got us a club");
                   suitsCounter.put(CLUBS, suitsCounter.get(CLUBS) + 1);
                   break;
               case DIAMONDS:
                   System.out.println("We got us a diamond");
                   suitsCounter.put(DIAMONDS, suitsCounter.get(DIAMONDS) + 1);
                   break;
               case HEARTS:
                   System.out.println("We got us a heart");
                   suitsCounter.put(HEARTS, suitsCounter.get(HEARTS) + 1);
                   break;
               case SPADES:
                   System.out.println("We got us a spade");
                   suitsCounter.put(SPADES, suitsCounter.get(SPADES) + 1);
                   break;

           }
       }
       return suitsCounter;
    }

    //**These atomic functions will be composed together in the check hand type functions, with a combination of suits counting and values comparisons
    //
    //The following are suits checking methods
    public boolean handHasAllSameSuit(ArrayList<Card> handBeingChecked) {
        //this is true if any one of the keys has a value of 5
        return false;
    }

    //The following are values checking methods
    //We need to check for counts of 5, 4, 3, 2 of same value
    //Make a value count function that returns the number of same values
    public boolean handHasAllConsecutiveValues() {
        // implement a recursive function here
        // this is true when card 1 is smaller than card 0, card 2 is smaller than card 1, etc after sorting by value
        return false;
    }

    public boolean handHasPair() {
        // this is true when at least one of the keys in suitsCounter has a value 2
        return false;
    }

    public boolean handHasTwoPair() {
        // this is true when
        return false;
    }

    public boolean handHasTrio() {
        return false;
    }



    //check hand type methods should all be compositions of the atomic handHasX methods
    // checkX returns what? boolean, just sets the properties on the hand for value and rankname?
    //assignWorthAndHandRanks should be composition of the check hand type methods, put the big switch in there?
    public void checkStraightFlush(ArrayList<Card> handBeingChecked) {
        System.out.println("Checking for Straight Flush...");
        Map suitsCounter = countSuits(handBeingChecked);
        System.out.println("This hand has the following amounts of suits: " + suitsCounter);

        //Implement rest of logic for what constitutes a Straight Flush and score it
        // If it is a straight flush, then what? Set the hand's worth and name? What stops the rest of assignHandWorth from firing?
        // Should assignHandWorth have an if-else tree or a switch?
    }

    public void assignHandWorth(Player playerBeingRanked) {
        ArrayList<Card> handBeingProcessed = playerBeingRanked.getCurrentHandOfCards();
        System.out.println(handBeingProcessed);
        checkStraightFlush(handBeingProcessed);
    }

}
