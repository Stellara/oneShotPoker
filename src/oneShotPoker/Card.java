package oneShotPoker;

public class Card{
    public enum Suits {
        SPADES,
        HEARTS,
        DIAMONDS,
        CLUBS;
    }

    public enum Ranks {
        TWO,
        THREE,
        FOUR,
        FIVE,
        SIX,
        SEVEN,
        EIGHT,
        NINE,
        TEN,
        JACK,
        QUEEN,
        KING,
        ACE;
    }

    private Suits suit;
    private Ranks rank;

    public Card(Suits suit, Ranks rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Ranks getRank() {
        return this.rank;
    }

    public Suits getSuit() {
        return this.suit;
    }
}
