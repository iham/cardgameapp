package msc.ddb.international;

import msc.ddb.international.interfaces.Nameable;
import msc.ddb.international.interfaces.Rankable;
import msc.ddb.international.interfaces.Suitable;

public abstract class Card {
    private Suitable suit;
    private Rankable rank;
    private int value;
    
    
    public Card(Rankable rank) {
        setRank(rank);
    }

    public Card(Suitable suit, Rankable rank) {
        setSuit(suit);
        setRank(rank);
    }

    public Suitable getSuit() {
        return suit;
    }
    public void setSuit(Suitable suit) {
        this.suit = suit;
    }
    public Rankable getRank() {
        return rank;
    }
    public void setRank(Rankable rank) {
        this.rank = rank;
    }
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Card [suit=" + ((Nameable)suit).getName() + ", rank=" + ((Nameable)rank).getName() + ", value=" + value + "]";
    }
    
    
}
