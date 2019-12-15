package oneShotPoker;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class HandOfCards {
    private ArrayList<Card> cards = new ArrayList<>();
    private int currentHandWorth = 0;
    private String currentRankName = "";
    private ArrayList<Card> bestCards = new ArrayList<>();

    public ArrayList<Card> getCards() {
        return this.cards;
    }

    public void setNewCard(Card newCardToAdd) {
        this.cards.add(newCardToAdd);
    }

    public int getCurrentHandWorth() {
        return this.currentHandWorth;
    }

    public void setCurrentHandWorth(int newHandWorth) {
        this.currentHandWorth = newHandWorth;
    }

    public String getCurrentHandRankName() {
        return this.currentRankName;
    }

    public void setCurrentHandRankName(String newHandRankName) {
        this.currentRankName = newHandRankName;
    }

    public ArrayList<Card> getBestCards() {
        return this.bestCards;
    }

    public void setBestCards(ArrayList<Card> subHandOfBestCards) {
        this.bestCards = subHandOfBestCards;
    }
}
