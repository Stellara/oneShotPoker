package oneShotPoker;

public class Card {
    private char value;
    private char suit = 'X';

    public char getValue() {
        return this.value;
    }

    public void setValue(char newValue) {
        System.out.println("Inside of Card class...setting value onto a card...");
        System.out.println("Setting this value: " + newValue);

        this.value = newValue;
    }

    public char getSuit() {
        return suit;
    }

    public void setSuit(char newSuit) {
        this.suit = newSuit;
    }
}
