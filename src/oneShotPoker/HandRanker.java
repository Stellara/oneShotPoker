package oneShotPoker;

import java.util.*;

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
    private static final String STRAIGHT_FLUSH = "Straight Flush";
    private static final String FOUR_OF_A_KIND = "Four of a Kind";
    private static final String FULL_HOUSE = "Full House";
    private static final String FLUSH = "Flush";
    private static final String STRAIGHT = "Straight";
    private static final String THREE_OF_A_KIND = "Three of a Kind";
    private static final String TWO_PAIRS = "Two Pairs";
    private static final String PAIR = "Pair" ;
    private static final String HIGH_CARD = "High Card";

    Comparator<Card> byCardRank = Comparator
            .comparing(Card::getRankAsInt);

    //Should I big switch that checks each of these?
    // Should I make each of these individual methods, passing in the player's hand?
    //Assigning a rank means that it needs the internal rank value + what kind of semantic hand they have for communications purposes

    /* RANKING RULES
    X Straight flush: 5 cards of the same suit with consecutive values. Ranked by the highest card in the hand.

    Four of a kind: 4 cards with the same value. Ranked by the value of the 4 cards.

    Full House: 3 cards of the same value, with the remaining 2 cards forming a pair. Ranked by the value of the 3 cards.

    Flush: Hand contains 5 cards of the same suit. Hands which are both flushes are ranked using the rules for High Card.

    Straight: Hand contains 5 cards with consecutive values. Hands which both contain a straight are ranked by their highest card.

    Three of a Kind: Three of the cards in the hand have the same value. Hands which both contain three of a kind are ranked by the value of the 3 cards.

    Two Pairs: The hand contains 2 different pairs. Hands which both contain 2 pairs are ranked by the value of their highest pair. Hands with the same highest     pair     are ranked by the value of their other pair. If these values are the same the hands are ranked by the value of the remaining card.

    Pair: 2 of the 5 cards in the hand have the same value. Hands which both contain a pair are ranked by the value of the cards forming the pair. If these         values   are the same, the hands are ranked by the values of the cards not forming the pair, in decreasing order.

    High Card: Hands which do not fit any higher category are ranked by the value of their highest card. If the highest cards have the same value, the hands are    ranked   by the next highest, and so on.
     */
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

    //**SUIT CHECKING ATOMIC METHODS**
    public boolean handHasAllSameSuit(ArrayList<Card> handBeingChecked) {
        System.out.println("This is count of suits inside handHasAllSameSuit: " + countSuits(handBeingChecked));
        int suitsFrequencies = Collections.frequency(countSuits(handBeingChecked).values(), 5);
        //this is true if any one of the keys has a value of 5
        return suitsFrequencies == 5;
    }

    //**RANK VALUES CHECKING ATOMIC METHODS***
    public boolean handHasAllConsecutiveValues(ArrayList<Card> handBeingChecked) {
        Collections.sort(handBeingChecked, byCardRank);

        for (int i = 1; i < handBeingChecked.size(); i++) {
            if (handBeingChecked.get(i).getRankAsInt() != handBeingChecked.get(i-1).getRankAsInt() + 1) {
                return false;
            }
        }
        return true;
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

    //TODO: Cleanup print statements
    public Card getHighCard(ArrayList<Card> handBeingChecked) {
        System.out.println("Getting high card value for " + handBeingChecked + "...");
        Collections.sort(handBeingChecked, byCardRank);

        System.out.println("This is the sorted hand being checked: ");
        for(int i=0; i < handBeingChecked.size(); i++){
            System.out.print(handBeingChecked.get(i).getRank());
            System.out.print(handBeingChecked.get(i).getSuit());
            System.out.print(" ");
        }

        System.out.println("This is the high card..." + handBeingChecked.get(4).getRank() + handBeingChecked.get(4).getSuit());
        return handBeingChecked.get(4);
    }

    //check hand type methods should all be compositions of the atomic handHasX methods
    // checkX returns what? boolean, just sets the properties on the hand for value and rankname?
    //assignWorthAndHandRanks should be composition of the check hand type methods, put the big switch in there?
    public boolean isStraightFlush(ArrayList<Card> handBeingChecked) {
        System.out.println("Checking for Straight Flush...");
        return handHasAllSameSuit(handBeingChecked) && handHasAllConsecutiveValues(handBeingChecked);
    }

    public boolean isFourOfAKind(ArrayList<Card> handBeingChecked) {
        System.out.println("Checking for Four of a Kind...");
        return false;
    }

    //implement a worth lookup method
    // public int lookupHandWorth(handBeingProcessed);

    public void assignHandWorth(Player playerBeingRanked) {
        HandOfCards currentHandStatus = playerBeingRanked.getCurrentHandInformation();
        ArrayList<Card> handBeingProcessed = currentHandStatus.getCards();

        System.out.println("This is the hand being processed inside assignHandWorth: ");
        System.out.println(handBeingProcessed);

        //TODO: What better way to implement this?
        if(isStraightFlush(handBeingProcessed)) {
            System.out.println("The hand is a Straight Flush!");
            // call lookupHandWorth and setCurrentHandWorth
        } else if(isFourOfAKind(handBeingProcessed)) {
            System.out.println("The hand is a Four of a Kind!");
            // repeat looking up worth of a four of a kind and assign it to hand information
        } else {
            System.out.println("No special ranks. The player can only win on high card");
            getHighCard(handBeingProcessed);
        }
    }

}
