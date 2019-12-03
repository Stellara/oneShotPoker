package oneShotPoker;

public class Card {
    private int value;
    private char suit;

    public int getValue() {
        return value;
    }

    public void setValue(int newValue) {
        this.value = newValue;
    }

    public int getSuit() {
        return suit;
    }

    public void setSuit(char newSuit) {
        this.suit = newSuit;
    }
}
