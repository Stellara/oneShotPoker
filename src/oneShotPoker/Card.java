package oneShotPoker;

public class Card {
    private int value = 99;
    private char suit = 'X';

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
