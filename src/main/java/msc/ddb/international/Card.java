package msc.ddb.international;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import msc.ddb.international.interfaces.Nameable;
import msc.ddb.international.interfaces.Rankable;
import msc.ddb.international.interfaces.Suitable;

public class Card {
    private Suitable suit;
    private Rankable rank;    
    
    public Card(Rankable rank) {
        setRank(rank);
    }

    public Card(Rankable rank, Suitable suit) {
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

    @Override
    public String toString() {
        String attributes = Stream.of(
            (rank == null) ? null : "rank=" + ((Nameable)rank).getName(),
            (suit == null) ? null : "suit=" + ((Nameable)suit).getName()
        ).filter(s -> s != null && !s.isEmpty())
        .collect(Collectors.joining(", "));

        return "Card [" + attributes + "]";
    }

    /* 
     * hashCode based on suit and rank.
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((suit == null) ? 0 : suit.hashCode());
        result = prime * result + ((rank == null) ? 0 : rank.hashCode());
        return result;
    }

    /* 
     * Comparing cards based on suit and rank.
     * if a game does different, the game needs to take care of that.
     * (Maybe games could come with the needed Comperator)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Card other = (Card) obj;
        if (suit == null) {
            if (other.suit != null)
                return false;
        } else if (!suit.equals(other.suit))
            return false;
        if (rank == null) {
            if (other.rank != null)
                return false;
        } else if (!rank.equals(other.rank))
            return false;
        return true;
    }


    
}
