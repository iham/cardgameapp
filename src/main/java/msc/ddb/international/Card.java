package msc.ddb.international;

public class Card {
    private Suit suit;
    private Rank rank;
    private int value;

    /**
     * A BlackJackCard is defined by a Suit and Rank
     * ...
     * @param suit
     * @param rank
     */
    public Card(Suit suit, Rank rank, int value) {
        setSuit(suit);
        setRank(rank);
        setValue(value);
    }
    
    private void setSuit(Suit suit) {
        this.suit = suit;
    }
    private void setRank(Rank rank) {
        this.rank = rank;
    }
    public void setValue(int value) {
        this.value = value;
    }

    public Suit getSuit() {
        return suit;
    }
    public Rank getRank() {
        return rank;
    }
    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return rank + "(" + value + ") of " + suit;
    }
    
}
