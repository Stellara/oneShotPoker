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
        _ Dealer: Ranked by the highest card in the hand.

    X Four of a kind: 4 cards with the same value.
        _ Dealer: Ranked by the value of the 4 cards.

    X Full House: 3 cards of the same value, with the remaining 2 cards forming a pair.
        _ Dealer: Ranked by the value of the 3 cards.

    X Flush: Hand contains 5 cards of the same suit.
        _ Dealer: Hands which are both flushes are ranked using the rules for High Card.

    X Straight: Hand contains 5 cards with consecutive values.
        _ Dealer: Hands which both contain a straight are ranked by their highest card.

    X Three of a Kind: Three of the cards in the hand have the same value.
        _ Dealer: Hands which both contain three of a kind are ranked by the value of the 3 cards.

    X Two Pairs: The hand contains 2 different pairs.
        _ Dealer: Hands which both contain 2 pairs are ranked by the value of their highest pair. Hands with the same highest pair are ranked by the  value of their other pair. If these values are the same the hands are ranked by the value of the remaining card.

    X Pair: 2 of the 5 cards in the hand have the same value.
        _ Dealer: Hands which both contain a pair are ranked by the value of the cards forming the pair. If these values are the same, the hands are ranked by the values of the cards not forming the pair, in decreasing order.

    X High Card: Hands which do not fit any higher category are ranked by the value of their highest card.
       _ Dealer: If the highest cards have the same value, the hands are    ranked   by the next highest, and so on.
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
        Map<Card.Ranks, Integer> ranksCounter = createRanksCounter();

        for(int i=0; i<handOfCards.size(); i++){
            Card.Ranks currentCardRank = handOfCards.get(i).getRank();

            switch(currentCardRank) {

                case TWO:
                    ranksCounter.put(TWO, ranksCounter.get(TWO) + 1);
                    break;
                case THREE:
                    ranksCounter.put(THREE, ranksCounter.get(THREE) + 1);
                    break;
                case FOUR:
                    ranksCounter.put(FOUR, ranksCounter.get(FOUR) + 1);
                    break;
                case FIVE:
                    ranksCounter.put(FIVE, ranksCounter.get(FIVE) + 1);
                    break;
                case SIX:
                    ranksCounter.put(SIX, ranksCounter.get(SIX) + 1);
                    break;
                case SEVEN:
                    ranksCounter.put(SEVEN, ranksCounter.get(SEVEN) + 1);
                    break;
                case EIGHT:
                    ranksCounter.put(EIGHT, ranksCounter.get(EIGHT) + 1);
                    break;
                case NINE:
                    ranksCounter.put(NINE, ranksCounter.get(NINE) + 1);
                    break;
                case TEN:
                    ranksCounter.put(TEN, ranksCounter.get(TEN) + 1);
                    break;
                case JACK:
                    ranksCounter.put(JACK, ranksCounter.get(JACK) + 1);
                    break;
                case QUEEN:
                    ranksCounter.put(QUEEN, ranksCounter.get(QUEEN) + 1);
                    break;
                case KING:
                    ranksCounter.put(KING, ranksCounter.get(KING) + 1);
                    break;
                case ACE:
                    ranksCounter.put(ACE, ranksCounter.get(ACE) + 1);
                    break;
            }
        }
        return ranksCounter;
    }

    //**___________________________SUIT CHECKING ATOMIC METHODS___________________________**
    private boolean handHasAllSameSuit(ArrayList<Card> handBeingChecked) {
        int suitsFrequencies = Collections.frequency(countSuits(handBeingChecked).values(), 5);
        return suitsFrequencies == 5;
    }

    //**________________________RANK VALUES CHECKING ATOMIC METHODS________________________**
    private boolean handHasAllConsecutiveValues(ArrayList<Card> handBeingChecked) {
        for (int i = 1; i < handBeingChecked.size(); i++) {
            if (handBeingChecked.get(i).getRankAsInt() != handBeingChecked.get(i-1).getRankAsInt() + 1) {
                return false;
            }
        }
        return true;
    }

    private boolean handHasFourSameValues(ArrayList<Card> handBeingChecked) {
        int ranksFrequencies = Collections.frequency(countRanks(handBeingChecked).values(), 4);
        return ranksFrequencies == 1;
    }
    private boolean handHasThreeSameValues(ArrayList<Card> handBeingChecked) {
        int ranksFrequencies = Collections.frequency(countRanks(handBeingChecked).values(), 3);
        return ranksFrequencies == 1;
    }

    private boolean handHasPair(ArrayList<Card> handBeingChecked) {
        int ranksFrequencies = Collections.frequency(countRanks(handBeingChecked).values(), 2);
        return ranksFrequencies == 1;
    }

    private boolean handHasTwoPair(ArrayList<Card> handBeingChecked) {
        int ranksFrequencies = Collections.frequency(countRanks(handBeingChecked).values(), 2);
        return ranksFrequencies == 2;
    }

    public ArrayList<Card> getHighCard(ArrayList<Card> handBeingChecked) {
        ArrayList<Card> matchingCards = new ArrayList<>();
        int highestCard = handBeingChecked.size()-1;
        matchingCards.add(handBeingChecked.get(highestCard));
        return matchingCards;
    }

    //**________________________COMPOSED HAND TYPE METHODS________________________**

    private boolean isStraightFlush(ArrayList<Card> handBeingChecked) {
        return handHasAllSameSuit(handBeingChecked) && handHasAllConsecutiveValues(handBeingChecked);
    }

    private boolean isFourOfAKind(ArrayList<Card> handBeingChecked) {
        return handHasFourSameValues(handBeingChecked);
    }

    private boolean isFullHouse(ArrayList<Card> handBeingChecked) {
        return handHasFourSameValues(handBeingChecked) && handHasPair(handBeingChecked);
    }

    private boolean isFlush(ArrayList<Card> handBeingChecked) {
        return handHasAllSameSuit(handBeingChecked);
    }

    private boolean isStraight(ArrayList<Card> handBeingChecked) {
        return handHasAllConsecutiveValues(handBeingChecked);
    }

    private boolean isThreeOfAKind(ArrayList<Card> handBeingChecked) {
        return handHasThreeSameValues(handBeingChecked);
    }

    private boolean isTwoPair(ArrayList<Card> handBeingChecked) {
        return handHasTwoPair(handBeingChecked);
    }
    private boolean isPair(ArrayList<Card> handBeingChecked) {
        return handHasPair(handBeingChecked);
    }

    //**________________________ASSIGN HAND WORTH METHOD________________________**
    private static <K, V> K getKeysByValue(Map<K, V> map, V value) {
        return map.keySet()
                .stream()
                .filter(key -> value.equals(map.get(key)))
                .findFirst().get();
    }

    private ArrayList<Card> getCardsInMatchingSets(ArrayList<Card> handBeingProcessed, int rank) {
        ArrayList<Card> matchingCards = new ArrayList<>();

        Object rankOfMatchingMultiples = getKeysByValue(countRanks(handBeingProcessed), rank);
        for(Card card: handBeingProcessed) {
            if(card.getRank() == rankOfMatchingMultiples){
                matchingCards.add(card);
            }
        }
        return matchingCards;
    }

    public void assignHandWorth(Player playerBeingRanked) {
        HandOfCards currentHandStatus = playerBeingRanked.getCurrentHandInformation();
        ArrayList<Card> handBeingProcessed = currentHandStatus.getCards();
        Collections.sort(handBeingProcessed, byCardRank);


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

            currentHandStatus.setBestCards(getHighCard(handBeingProcessed));
            System.out.println(currentHandStatus.getCurrentHandRankName()  + " " + currentHandStatus.getCurrentHandWorth() +  " " + currentHandStatus.getBestCards());
        } else if(isFourOfAKind(handBeingProcessed)) {
            System.out.println("The hand is a Four of a Kind!");
            currentHandStatus.setCurrentHandRankName(handWorth.FOUR_OF_A_KIND.handName);
            currentHandStatus.setCurrentHandWorth(handWorth.FOUR_OF_A_KIND.handWorth);

            currentHandStatus.setBestCards(getCardsInMatchingSets(handBeingProcessed, 4));
            System.out.println(currentHandStatus.getCurrentHandRankName()  + " " + currentHandStatus.getCurrentHandWorth() +  " " + currentHandStatus.getBestCards());
        } else if(isFullHouse(handBeingProcessed)) {
            System.out.println("The hand is a Full House!");
            currentHandStatus.setCurrentHandRankName(handWorth.FULL_HOUSE.handName);
            currentHandStatus.setCurrentHandWorth(handWorth.FULL_HOUSE.handWorth);

            currentHandStatus.setBestCards(getCardsInMatchingSets(handBeingProcessed, 3));
            currentHandStatus.printBestCards();
            System.out.println(currentHandStatus.getCurrentHandRankName()  + " " + currentHandStatus.getCurrentHandWorth() +  " " + currentHandStatus.getBestCards());
        } else if(isFlush(handBeingProcessed)) {
            System.out.println("The hand is a Flush!");
            currentHandStatus.setCurrentHandRankName(handWorth.FLUSH.handName);
            currentHandStatus.setCurrentHandWorth(handWorth.FLUSH.handWorth);

            currentHandStatus.setBestCards(getHighCard(handBeingProcessed));
            System.out.println(currentHandStatus.getCurrentHandRankName()  + " " + currentHandStatus.getCurrentHandWorth() +  " " + currentHandStatus.getBestCards());
        } else if(isStraight(handBeingProcessed)) {
            System.out.println("The hand is a Straight!");
            currentHandStatus.setCurrentHandRankName(handWorth.STRAIGHT.handName);
            currentHandStatus.setCurrentHandWorth(handWorth.STRAIGHT.handWorth);

            currentHandStatus.setBestCards(getHighCard(handBeingProcessed));
            System.out.println(currentHandStatus.getCurrentHandRankName()  + " " + currentHandStatus.getCurrentHandWorth() +  " " + currentHandStatus.getBestCards());
        } else if(isThreeOfAKind(handBeingProcessed)) {
            System.out.println("The hand is a Three of a Kind!");
            currentHandStatus.setCurrentHandRankName(handWorth.THREE_OF_A_KIND.handName);
            currentHandStatus.setCurrentHandWorth(handWorth.THREE_OF_A_KIND.handWorth);

            currentHandStatus.setBestCards(getCardsInMatchingSets(handBeingProcessed, 3));
            System.out.println(currentHandStatus.getCurrentHandRankName()  + " " + currentHandStatus.getCurrentHandWorth() +  " " + currentHandStatus.getBestCards());
        } else if(isTwoPair(handBeingProcessed)) {
            System.out.println("The hand is a Two Pair!");
            currentHandStatus.setCurrentHandRankName(handWorth.TWO_PAIR.handName);
            currentHandStatus.setCurrentHandWorth(handWorth.TWO_PAIR.handWorth);

            ArrayList twoPairCards = new ArrayList(handBeingProcessed.subList(1, 5));
            currentHandStatus.setBestCards(twoPairCards);
            System.out.println(currentHandStatus.getCurrentHandRankName()  + " " + currentHandStatus.getCurrentHandWorth() +  " " + currentHandStatus.getBestCards());
        } else if(isPair(handBeingProcessed)) {
            System.out.println("The hand is a Pair!");
            System.out.println("Setting the following rank name and hand worth: ");

            currentHandStatus.setCurrentHandRankName(handWorth.PAIR.handName);
            currentHandStatus.setCurrentHandWorth(handWorth.PAIR.handWorth);
            ArrayList<Card> cardsComprisingPair;
            cardsComprisingPair = getCardsInMatchingSets(handBeingProcessed, 2);

            currentHandStatus.setBestCards(cardsComprisingPair);
            for(Card card : cardsComprisingPair){
                handBeingProcessed.remove(card);
            }
            System.out.println("Let's see what's left in hand after a pair is detected...");
            currentHandStatus.printCards();
            System.out.println(currentHandStatus.getCurrentHandRankName()  + " " + currentHandStatus.getCurrentHandWorth() +  " " + currentHandStatus.getBestCards());
        } else {
            System.out.println("No special ranks. The player can only win on high card");
            getHighCard(handBeingProcessed);
            currentHandStatus.setCurrentHandRankName(handWorth.HIGH_CARD.handName);
            currentHandStatus.setCurrentHandWorth(handWorth.HIGH_CARD.handWorth);

            currentHandStatus.setBestCards(getHighCard(handBeingProcessed));
            System.out.println(currentHandStatus.getCurrentHandRankName()  + " " + currentHandStatus.getCurrentHandWorth() +  " " + currentHandStatus.getBestCards());
        }
    }

}
