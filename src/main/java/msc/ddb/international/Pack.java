package msc.ddb.international;

import java.util.ArrayList;

public class Pack {
    private ArrayList<Card> cards = new ArrayList<Card>();

    public Pack() {
        createCards();
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    private void createCards() {
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                Card card = new Card(suit, rank, rank.value);
                cards.add(card);
            }   
        }
    };

    @Override
    public String toString() {
        String output = "";
        for (Card card : cards) {
            output += card + "\n";
        }
        return output;
    }
}
