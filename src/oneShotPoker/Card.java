package oneShotPoker;

public class Card{
    public enum Suits {
        CLUBS,
        DIAMONDS,
        HEARTS,
        SPADES;
    }

    public enum Ranks {
        TWO("Two", 0),
        THREE("Three", 1),
        FOUR("Four", 2),
        FIVE("Five", 3),
        SIX("Six", 4),
        SEVEN("Seven", 5),
        EIGHT("Eight", 6),
        NINE("Nine", 7),
        TEN("Ten", 8),
        JACK("Jack", 9),
        QUEEN("Queen", 10),
        KING("King", 11),
        ACE("Ace", 12);

        public final String rankName;
        public final int rankWorth;

        private Ranks(String rankName, int rankWorth) {
            this.rankName = rankName;
            this.rankWorth = rankWorth;
        }

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

    public int getRankWorth() {
        return this.rank.rankWorth;
    }

    public Suits getSuit() {
        return this.suit;
    }
}
