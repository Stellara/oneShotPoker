package oneShotPoker;

import java.util.ArrayList;
import java.util.Map;

import static java.util.Collections.frequency;

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

    private void countSameSuits(ArrayList<Card> handOfCards) {
        System.out.println("Inside countSameSuits...");

        Map<String, Integer> suitCounts = Map.of(
                "Clubs", 0,
                "Diamonds", 0,
                "Hearts", 0,
                "Spades", 0
        );

      suitCounts.forEach((k, v)->{
       for(int i=0; i<handOfCards.size(); i++){
          System.out.println("Checking this suit for each player in countSameSuits " + handOfCards.get(i).getSuit() );
              if(handOfCards.get(i).getSuit().equals(k)){
                  suitCounts.put(k, suitCounts.get(k) + 1);
              }
           }
        });

        System.out.println("Here's the counts of suits bitches: " + suitCounts);
    }

    public void assignHandWorth(Player playerBeingRanked) {
        ArrayList<Card> handBeingProcessed = playerBeingRanked.getCurrentHandOfCards();
        System.out.println(handBeingProcessed);

        checkStraightFlush(handBeingProcessed);
    }

    public void checkStraightFlush(ArrayList<Card> handBeingChecked) {
        System.out.println("Checking for Straight Flush...");
        countSameSuits(handBeingChecked);
    }

}
