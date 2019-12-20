package main.oneShotPoker;

public class Card{
    public enum Suits {
        CLUBS,
        DIAMONDS,
        HEARTS,
        SPADES;
    }

    public enum Ranks {
        TWO(2,"Two", 0),
        THREE(3,"Three", 1),
        FOUR(4,"Four", 2),
        FIVE(5,"Five", 3),
        SIX(6,"Six", 4),
        SEVEN(7,"Seven", 5),
        EIGHT(8,"Eight", 6),
        NINE(9,"Nine", 7),
        TEN(10,"Ten", 8),
        JACK(11,"Jack", 9),
        QUEEN(12,"Queen", 10),
        KING(12,"King", 11),
        ACE(14,"Ace", 12);

        public final int rankAsInt;
        public final String rankName;
        public final int rankWorth;

        Ranks(int rankAsInt, String rankName, int rankWorth) {
            this.rankAsInt = rankAsInt;
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

    public int getRankAsInt() {
        return this.rank.rankAsInt;
    }

    public String getRankName() {
        return this.rank.rankName;
    }

    public int getRankWorth() {
        return this.rank.rankWorth;
    }

    public Suits getSuit() {
        return this.suit;
    }

    public void printCardInfo() {
        System.out.println(getRank());
        System.out.println(getSuit());
    }
}
