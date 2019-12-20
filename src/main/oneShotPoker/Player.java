package main.oneShotPoker;

public class Player {
    public String playerName;
    private HandOfCards currentHandOfCards;
    private boolean isWinner;

    public void setPlayerName(int index) {
        this.playerName = "Player" + Integer.toString(index + 1);
    }

    public String getPlayerName() {
        return this.playerName;
    }

    public HandOfCards getCurrentHandInformation(){
        return this.currentHandOfCards;
    }

    public void setCurrentHandOfCards(HandOfCards newHand){
        this.currentHandOfCards = newHand;
    }

    public void setWinner(boolean wonLastGame) {
        this.isWinner = wonLastGame;
    }

    public boolean isWinner() {
        return this.isWinner;
    }

}
