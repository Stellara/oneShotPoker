package oneShotPoker;

import java.util.ArrayList;

public class Player {
    private boolean isWinner;
    private HandOfCards currentHandOfCards;


    public void setWinner(boolean wonLastGame) {
        this.isWinner = wonLastGame;
    }

    public boolean isWinner() {
        return this.isWinner;
    }

    //TODO: reconsider, has a smell
    public ArrayList<Card> getCurrentHandOfCards(){
        return this.currentHandOfCards.getCards();
    }

    public void setCurrentHandOfCards(HandOfCards newHand){
        this.currentHandOfCards = newHand;
    }
}
