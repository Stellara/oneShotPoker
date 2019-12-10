package oneShotPoker;

import java.util.ArrayList;

public class HandOfCards {
    private ArrayList<Card> cards = new ArrayList<>();
    //TODO: Should this be on the player or on the hand?
    private int currentValue = 0;
    private String currentRankName = "";

    public ArrayList<Card> getCards() {
        return this.cards;
    }

    public void setNewCard(Card newCardToAdd) {
        this.cards.add(newCardToAdd);
    }

    public int getCurrentValue() {
        return this.currentValue;
    }

    public void setCurrentHandValue(int newHandValue) {
        this.currentValue = newHandValue;
    }

    public String getCurrentHandRankName() {
        return this.currentRankName;
    }

    public void setCurrentHandRankName(String newHandRankName) {
        this.currentRankName = newHandRankName;
    }
}
