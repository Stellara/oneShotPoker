package oneShotPoker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//TODO: Do I need these explicit imports? More DRY way to access?
import static oneShotPoker.Card.Suits.CLUBS;
import static oneShotPoker.Card.Suits.DIAMONDS;
import static oneShotPoker.Card.Suits.HEARTS;
import static oneShotPoker.Card.Suits.SPADES;

//TODO: I hate this! How else can I get these?
import static oneShotPoker.Card.Ranks.TWO;
import static oneShotPoker.Card.Ranks.THREE;
import static oneShotPoker.Card.Ranks.FOUR;
import static oneShotPoker.Card.Ranks.FIVE;
import static oneShotPoker.Card.Ranks.SIX;
import static oneShotPoker.Card.Ranks.SEVEN;
import static oneShotPoker.Card.Ranks.EIGHT;
import static oneShotPoker.Card.Ranks.NINE;
import static oneShotPoker.Card.Ranks.TEN;
import static oneShotPoker.Card.Ranks.JACK;
import static oneShotPoker.Card.Ranks.QUEEN;
import static oneShotPoker.Card.Ranks.KING;
import static oneShotPoker.Card.Ranks.ACE;



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

    private static Map<Card.Ranks, Integer> createRanksCounter() {
        Map<Card.Ranks, Integer> ranksCounter = new HashMap<>();
        for(Card.Ranks rank : Card.Ranks.values()) {
            ranksCounter.put(rank, 0);
        }
        return ranksCounter;
    }

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

    //TODO: refactor
    private Map countRanks(ArrayList<Card> handOfCards) {
        System.out.println("Inside countRanks...");
        Map<Card.Ranks, Integer> ranksCounter = createRanksCounter();

        for(int i=0; i<handOfCards.size(); i++){
            Card.Ranks currentCardRank = handOfCards.get(i).getRank();

            System.out.println("Checking this suit for each player in countRanks " + currentCardRank);

            switch(currentCardRank) {

                case TWO:
                    System.out.println("We got us a two!");
                    ranksCounter.put(TWO, ranksCounter.get(TWO) + 1);
                    break;
                case THREE:
                    System.out.println("We got us a three!");
                    ranksCounter.put(THREE, ranksCounter.get(THREE) + 1);
                    break;
                case FOUR:
                    System.out.println("We got us a four!");
                    ranksCounter.put(FOUR, ranksCounter.get(FOUR) + 1);
                    break;
                case FIVE:
                    System.out.println("We got us a five!");
                    ranksCounter.put(FIVE, ranksCounter.get(FIVE) + 1);
                    break;
                case SIX:
                    System.out.println("We got us a six!");
                    ranksCounter.put(SIX, ranksCounter.get(SIX) + 1);
                    break;
                case SEVEN:
                    System.out.println("We got us a seven!");
                    ranksCounter.put(SEVEN, ranksCounter.get(SEVEN) + 1);
                    break;
                case EIGHT:
                    System.out.println("We got us a eight!");
                    ranksCounter.put(EIGHT, ranksCounter.get(EIGHT) + 1);
                    break;
                case NINE:
                    System.out.println("We got us a nine!");
                    ranksCounter.put(NINE, ranksCounter.get(NINE) + 1);
                    break;
                case TEN:
                    System.out.println("We got us a ten!");
                    ranksCounter.put(TEN, ranksCounter.get(TEN) + 1);
                    break;
                case JACK:
                    System.out.println("We got us a jack!");
                    ranksCounter.put(JACK, ranksCounter.get(JACK) + 1);
                    break;
                case QUEEN:
                    System.out.println("We got us a queen!");
                    ranksCounter.put(QUEEN, ranksCounter.get(QUEEN) + 1);
                    break;
                case KING:
                    System.out.println("We got us a king!");
                    ranksCounter.put(KING, ranksCounter.get(KING) + 1);
                    break;
                case ACE:
                    System.out.println("We got us a ace");
                    ranksCounter.put(ACE, ranksCounter.get(ACE) + 1);
                    break;
            }
        }
        return ranksCounter;
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
        //TODO: needs a better name, confusing with suitsCounter and countSuits method
        Map suitsOfCurrentHand = countSuits(handBeingChecked);
        System.out.println("This hand has the following amounts of suits: " + suitsOfCurrentHand);

        //Implement rest of logic for what constitutes a Straight Flush and score it
        // If it is a straight flush, then what? Set the hand's worth and name? What stops the rest of assignHandWorth from firing?
        // Should assignHandWorth have an if-else tree or a switch?
    }

    public void checkFourOfAKind(ArrayList<Card> handBeingChecked) {
        System.out.println("Checking for Four of a Kind...");
        Map ranksOfCurrentHand = countRanks(handBeingChecked);
        System.out.println("This hand has the following amounts of ranks: " + ranksOfCurrentHand);
    }

    public void assignHandWorth(Player playerBeingRanked) {
        ArrayList<Card> handBeingProcessed = playerBeingRanked.getCurrentHandOfCards();
        System.out.println(handBeingProcessed);
        checkStraightFlush(handBeingProcessed);
        checkFourOfAKind(handBeingProcessed);
    }

}
