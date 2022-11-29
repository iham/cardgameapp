package msc.ddb.international;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {
    private ArrayList<Card> cards = new ArrayList<Card>();
    private final int packsUsed = 6;

    public Deck() {
        setCards();
        shuffle();
    }

    // BlackJack consists of 6 Packs of BlackJack Cards
    private void setCards() {
        Pack pack = new Pack();
        for (int i = 0; i < packsUsed; i++) {
            cards.addAll(pack.getCards()); 
        }
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void shuffle() {
        Collections.shuffle(cards, new Random());
    }

    public Card pickCard() {
        return cards.remove( cards.size() - 1 );
    }
    @Override
    public String toString() {
        String output = "";
        for (Card card : cards) {
            output += card + "\n";
        }
        return output;
    }
}
