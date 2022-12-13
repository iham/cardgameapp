package msc.ddb.international.decks;

import java.util.StringJoiner;

import msc.ddb.international.utils.Name;

public class Card extends Name {
    private String rank;
    private String suit;

    private Card() {
        super("");
    }

    public Card(String rank, String suit) {
        super("");
        this.rank = rank;
        this.suit = suit;
        setName();
    }

    public Card(String rank) {
        super("");
        this.rank = rank;
        setName();
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public void setName() {
        StringJoiner name = new StringJoiner(" of ");
        name.add(rank);
        name.add(suit);
        super.setName(name.toString());
    }

    @Override
    public String toString() {
        return "Card [rank=" + rank + ", suit=" + suit + "]";
    }

    
}
