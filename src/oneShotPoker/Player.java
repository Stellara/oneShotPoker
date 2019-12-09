package oneShotPoker;

import java.util.ArrayList;

public class Player {
    private boolean isWinner;
    private ArrayList<oneShotPoker.Card> currentHandOfCards = new ArrayList<>();

    public void setWinner(boolean wonLastGame) {
        this.isWinner = wonLastGame;
    }

    public boolean isWinner() {
        return this.isWinner;
    }

    public ArrayList<Card> getCurrentHandOfCards(){
        return this.currentHandOfCards;
    }

    public void setCurrentHandOfCards(ArrayList<Card> newHand){
        this.currentHandOfCards = newHand;
    }
}
