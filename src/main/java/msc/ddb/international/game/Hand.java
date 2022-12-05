package msc.ddb.international.game;

import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> cards = new ArrayList<Card>();
    
    public void addCard(Card card) {
        cards.add(card);
    }

    public void addCards(ArrayList<Card> cards) {
        cards.addAll(cards);
    }

    public int calculate() {
        return 0;
    }
}
