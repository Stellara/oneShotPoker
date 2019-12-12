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
    Comparator<Card> byCardRank = Comparator
            .comparing(Card::getRankAsInt);

    public enum HandWorth {
        STRAIGHT_FLUSH("Straight Flush", 9),
        FOUR_OF_A_KIND("Four of a Kind", 8),
        FULL_HOUSE("Full House", 7),
        FLUSH("Flush", 6),
        STRAIGHT("Straight", 5),
        THREE_OF_A_KIND("Three of a Kind", 4),
        TWO_PAIR("Two Pair", 3),
        PAIR("Pair", 2),
        HIGH_CARD("High Card", 1);



        public final String handName;
        public final int handWorth;

        private HandWorth(String handName, int handWorth) {
            this.handName = handName;
            this.handWorth = handWorth;
        }

    }

    private HandWorth handWorth;

    /*   **________________________________________________RANKING RULES________________________________________________**
    X Straight flush: 5 cards of the same suit && consecutive values.
        Dealer Class job -> Ranked by the highest card in the hand.

    X Four of a kind: 4 cards with the same value. Ranked by the value of the 4 cards.

    X Full House: 3 cards of the same value, with the remaining 2 cards forming a pair. Ranked by the value of the 3 cards.

    X Flush: Hand contains 5 cards of the same suit.
        Dealer Class job ->  Hands which are both flushes are ranked using the rules for High Card.

    X Straight: Hand contains 5 cards with consecutive values.
        Dealer Class job ->Hands which both contain a straight are ranked by their highest card.

    X Three of a Kind: Three of the cards in the hand have the same value. Hands which both contain three of a kind are ranked by the value of the 3 cards.

    X Two Pairs: The hand contains 2 different pairs. Hands which both contain 2 pairs are ranked by the value of their highest pair. Hands with the same highest pair are ranked by the  value of their other pair. If these values are the same the hands are ranked by the value of the remaining card.

    X Pair: 2 of the 5 cards in the hand have the same value. Hands which both contain a pair are ranked by the value of the cards forming the pair. If these         values   are the same, the hands are ranked by the values of the cards not forming the pair, in decreasing order.

    X High Card: Hands which do not fit any higher category are ranked by the value of their highest card.
       Dealer class job -> If the highest cards have the same value, the hands are    ranked   by the next highest, and so on.
     */
    // **________________________________________________END RANKING RULES________________________________________________**

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

//           System.out.println("Checking this suit for each player in countSuits " + currentCardSuit);

           switch(currentCardSuit) {

               case CLUBS:
//                   System.out.println("We got us a club");
                   suitsCounter.put(CLUBS, suitsCounter.get(CLUBS) + 1);
                   break;
               case DIAMONDS:
//                   System.out.println("We got us a diamond");
                   suitsCounter.put(DIAMONDS, suitsCounter.get(DIAMONDS) + 1);
                   break;
               case HEARTS:
//                   System.out.println("We got us a heart");
                   suitsCounter.put(HEARTS, suitsCounter.get(HEARTS) + 1);
                   break;
               case SPADES:
//                   System.out.println("We got us a spade");
                   suitsCounter.put(SPADES, suitsCounter.get(SPADES) + 1);
                   break;

           }
       }
       return suitsCounter;
    }

    //TODO: refactor
    private Map countRanks(ArrayList<Card> handOfCards) {
//        System.out.println("Inside countRanks...");
        Map<Card.Ranks, Integer> ranksCounter = createRanksCounter();

        for(int i=0; i<handOfCards.size(); i++){
            Card.Ranks currentCardRank = handOfCards.get(i).getRank();

//            System.out.println("Checking this rank for each player in countRanks " + currentCardRank);

            switch(currentCardRank) {

                case TWO:
//                    System.out.println("We got us a two!");
                    ranksCounter.put(TWO, ranksCounter.get(TWO) + 1);
                    break;
                case THREE:
//                    System.out.println("We got us a three!");
                    ranksCounter.put(THREE, ranksCounter.get(THREE) + 1);
                    break;
                case FOUR:
//                    System.out.println("We got us a four!");
                    ranksCounter.put(FOUR, ranksCounter.get(FOUR) + 1);
                    break;
                case FIVE:
//                    System.out.println("We got us a five!");
                    ranksCounter.put(FIVE, ranksCounter.get(FIVE) + 1);
                    break;
                case SIX:
//                    System.out.println("We got us a six!");
                    ranksCounter.put(SIX, ranksCounter.get(SIX) + 1);
                    break;
                case SEVEN:
//                    System.out.println("We got us a seven!");
                    ranksCounter.put(SEVEN, ranksCounter.get(SEVEN) + 1);
                    break;
                case EIGHT:
//                    System.out.println("We got us a eight!");
                    ranksCounter.put(EIGHT, ranksCounter.get(EIGHT) + 1);
                    break;
                case NINE:
//                    System.out.println("We got us a nine!");
                    ranksCounter.put(NINE, ranksCounter.get(NINE) + 1);
                    break;
                case TEN:
//                    System.out.println("We got us a ten!");
                    ranksCounter.put(TEN, ranksCounter.get(TEN) + 1);
                    break;
                case JACK:
//                    System.out.println("We got us a jack!");
                    ranksCounter.put(JACK, ranksCounter.get(JACK) + 1);
                    break;
                case QUEEN:
//                    System.out.println("We got us a queen!");
                    ranksCounter.put(QUEEN, ranksCounter.get(QUEEN) + 1);
                    break;
                case KING:
//                    System.out.println("We got us a king!");
                    ranksCounter.put(KING, ranksCounter.get(KING) + 1);
                    break;
                case ACE:
//                    System.out.println("We got us a ace");
                    ranksCounter.put(ACE, ranksCounter.get(ACE) + 1);
                    break;
            }
        }
        return ranksCounter;
    }

    //**___________________________SUIT CHECKING ATOMIC METHODS___________________________**
    public boolean handHasAllSameSuit(ArrayList<Card> handBeingChecked) {
//        System.out.println("This is count of suits inside handHasAllSameSuit: " + countSuits(handBeingChecked));
        int suitsFrequencies = Collections.frequency(countSuits(handBeingChecked).values(), 5);
        return suitsFrequencies == 5;
    }

    //**________________________RANK VALUES CHECKING ATOMIC METHODS________________________**
    public boolean handHasAllConsecutiveValues(ArrayList<Card> handBeingChecked) {
        Collections.sort(handBeingChecked, byCardRank);

        for (int i = 1; i < handBeingChecked.size(); i++) {
            if (handBeingChecked.get(i).getRankAsInt() != handBeingChecked.get(i-1).getRankAsInt() + 1) {
                return false;
            }
        }
        return true;
    }

    public boolean handHasFourSameValues(ArrayList<Card> handBeingChecked) {
//        System.out.println("This is count of the ranks inside handHasFourSameValues: " + countRanks(handBeingChecked));
        int ranksFrequencies = Collections.frequency(countRanks(handBeingChecked).values(), 4);
        return ranksFrequencies == 1;
    }
    public boolean handHasThreeSameValues(ArrayList<Card> handBeingChecked) {
//        System.out.println("This is count of the ranks inside handHasFourSameValues: " + countRanks(handBeingChecked));
        int ranksFrequencies = Collections.frequency(countRanks(handBeingChecked).values(), 3);
        return ranksFrequencies == 1;
    }

    public boolean handHasPair(ArrayList<Card> handBeingChecked) {
//        System.out.println("This is count of the ranks inside handHasPair: " + countRanks(handBeingChecked));
        int ranksFrequencies = Collections.frequency(countRanks(handBeingChecked).values(), 2);
        return ranksFrequencies == 1;
    }

    public boolean handHasTwoPair(ArrayList<Card> handBeingChecked) {
//        System.out.println("This is count of the ranks inside handHasTwoPair: " + countRanks(handBeingChecked));
        int ranksFrequencies = Collections.frequency(countRanks(handBeingChecked).values(), 2);
        return ranksFrequencies == 2;
    }

    //TODO: Cleanup print statements
    public Card getHighCard(ArrayList<Card> handBeingChecked) {
//        System.out.println("Getting high card value for " + handBeingChecked + "...");
        Collections.sort(handBeingChecked, byCardRank);

//        System.out.println("This is the sorted hand being checked: ");
//        for(int i=0; i < handBeingChecked.size(); i++){
//            System.out.print(handBeingChecked.get(i).getRank());
//            System.out.print(handBeingChecked.get(i).getSuit());
//            System.out.print(" ");
//        }

        System.out.println("This is the high card..." + handBeingChecked.get(4).getRank() + " " + handBeingChecked.get(4).getSuit());
        return handBeingChecked.get(4);
    }

    //**________________________COMPOSED HAND TYPE METHODS________________________**

    public boolean isStraightFlush(ArrayList<Card> handBeingChecked) {
        System.out.println("Checking for Straight Flush...");
        return handHasAllSameSuit(handBeingChecked) && handHasAllConsecutiveValues(handBeingChecked);
    }

    public boolean isFourOfAKind(ArrayList<Card> handBeingChecked) {
        System.out.println("Checking for Four of a Kind...");
        return handHasFourSameValues(handBeingChecked);
    }

    public boolean isFullHouse(ArrayList<Card> handBeingChecked) {
        System.out.println("Checking for FullHouse...");
        return handHasFourSameValues(handBeingChecked) && handHasPair(handBeingChecked);
    }

    public boolean isFlush(ArrayList<Card> handBeingChecked) {
        System.out.println("Checking for Flush...");
        return handHasAllSameSuit(handBeingChecked);
    }

    public boolean isStraight(ArrayList<Card> handBeingChecked) {
        System.out.println("Checking for Straight...");
        return handHasAllConsecutiveValues(handBeingChecked);
    }

    public boolean isThreeOfAKind(ArrayList<Card> handBeingChecked) {
        System.out.println("Checking for Three of a Kind...");
        return handHasThreeSameValues(handBeingChecked);
    }

    public boolean isTwoPair(ArrayList<Card> handBeingChecked) {
        System.out.println("Checking for Two Pair...");
        return handHasTwoPair(handBeingChecked);
    }
    public boolean isPair(ArrayList<Card> handBeingChecked) {
        System.out.println("Checking for a Pair...");
        return handHasPair(handBeingChecked);
    }

    //**________________________ASSIGN HAND WORTH METHOD________________________**
    //implement a worth lookup method
    // remake hand worth map, put here
    // public int lookupHandWorth(handBeingProcessed);
    public void assignHandWorth(Player playerBeingRanked) {
        HandOfCards currentHandStatus = playerBeingRanked.getCurrentHandInformation();
        ArrayList<Card> handBeingProcessed = currentHandStatus.getCards();

        // Inspect hand before it's ranked
        System.out.println("This is the hand being processed inside assignHandWorth: ");
        System.out.println(handBeingProcessed);
        for(int i=0; i<handBeingProcessed.size(); i++){
            System.out.print(handBeingProcessed.get(i).getRank());
            System.out.print(" ");
            System.out.print(handBeingProcessed.get(i).getSuit());
            System.out.print("  ");
        }

        //TODO: What better way to implement this?
        //TODO: Lots of repetition. Can I DRY it up?
        if(isStraightFlush(handBeingProcessed)) {
            System.out.println("The hand is a Straight Flush!");
            currentHandStatus.setCurrentHandRankName(handWorth.STRAIGHT_FLUSH.handName);
            currentHandStatus.setCurrentHandWorth(handWorth.STRAIGHT_FLUSH.handWorth);
            System.out.println(currentHandStatus.getCurrentHandRankName()  + " " + currentHandStatus.getCurrentHandWorth());
        } else if(isFourOfAKind(handBeingProcessed)) {
            System.out.println("The hand is a Four of a Kind!");
            currentHandStatus.setCurrentHandRankName(handWorth.FOUR_OF_A_KIND.handName);
            currentHandStatus.setCurrentHandWorth(handWorth.FOUR_OF_A_KIND.handWorth);
            System.out.println("Hand Rank info: " + currentHandStatus.getCurrentHandRankName()  + " " + currentHandStatus.getCurrentHandWorth());
        } else if(isFullHouse(handBeingProcessed)) {
            System.out.println("The hand is a Full House!");
            currentHandStatus.setCurrentHandRankName(handWorth.FULL_HOUSE.handName);
            currentHandStatus.setCurrentHandWorth(handWorth.FULL_HOUSE.handWorth);
            System.out.println("Hand Rank info: " + currentHandStatus.getCurrentHandRankName()  + " " + currentHandStatus.getCurrentHandWorth());
        } else if(isFlush(handBeingProcessed)) {
            System.out.println("The hand is a Flush!");
            currentHandStatus.setCurrentHandRankName(handWorth.FLUSH.handName);
            currentHandStatus.setCurrentHandWorth(handWorth.FLUSH.handWorth);
            System.out.println("Hand Rank info: " + currentHandStatus.getCurrentHandRankName()  + " " + currentHandStatus.getCurrentHandWorth());
        } else if(isStraight(handBeingProcessed)) {
            System.out.println("The hand is a Straight!");
            currentHandStatus.setCurrentHandRankName(handWorth.STRAIGHT.handName);
            currentHandStatus.setCurrentHandWorth(handWorth.STRAIGHT.handWorth);
            System.out.println("Hand Rank info: " + currentHandStatus.getCurrentHandRankName()  + " " + currentHandStatus.getCurrentHandWorth());
        } else if(isThreeOfAKind(handBeingProcessed)) {
            System.out.println("The hand is a Three of a Kind!");
            currentHandStatus.setCurrentHandRankName(handWorth.THREE_OF_A_KIND.handName);
            currentHandStatus.setCurrentHandWorth(handWorth.THREE_OF_A_KIND.handWorth);
            System.out.println("Hand Rank info: " + currentHandStatus.getCurrentHandRankName() + " " + currentHandStatus.getCurrentHandWorth());
        } else if(isTwoPair(handBeingProcessed)) {
            System.out.println("The hand is a Four of a Kind!");
            currentHandStatus.setCurrentHandRankName(handWorth.TWO_PAIR.handName);
            currentHandStatus.setCurrentHandWorth(handWorth.TWO_PAIR.handWorth);
            System.out.println("Hand Rank info: " + currentHandStatus.getCurrentHandRankName()+ " " + currentHandStatus.getCurrentHandWorth());
        } else if(isPair(handBeingProcessed)) {
            System.out.println("The hand is a Pair!");
            currentHandStatus.setCurrentHandRankName(handWorth.PAIR.handName);
            currentHandStatus.setCurrentHandWorth(handWorth.PAIR.handWorth);
            System.out.println("Hand Rank info: " + currentHandStatus.getCurrentHandRankName() + " " + currentHandStatus.getCurrentHandWorth());
        } else {
            System.out.println("No special ranks. The player can only win on high card");
            getHighCard(handBeingProcessed); // what do I set this to for the dealer?
            currentHandStatus.setCurrentHandRankName(handWorth.HIGH_CARD.handName);
            currentHandStatus.setCurrentHandWorth(handWorth.HIGH_CARD.handWorth);
            System.out.println("Hand Rank info: " +  currentHandStatus.getCurrentHandRankName() + " " + currentHandStatus.getCurrentHandWorth());
        }
    }

}
