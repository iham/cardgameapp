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
    
    /**
     * @param suit
     */
    private void setSuit(Suit suit) {
        this.suit = suit;
    }
    
    /** 
     * @param rank - this is a Rank ENUM value
     */
    private void setRank(Rank rank) {
        this.rank = rank;
    }
    
    /** 
     * @param value
     */
    public void setValue(int value) {
        this.value = value;
    }

    
    /** 
     * @return Suit
     */
    public Suit getSuit() {
        return suit;
    }
    
    /** 
     * @return Rank
     */
    public Rank getRank() {
        return rank;
    }
    
    /** 
     * @return int
     */
    public int getValue() {
        return value;
    }

    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return rank + "(" + value + ") of " + suit;
    }
}
