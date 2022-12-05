package msc.ddb.international.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.StringJoiner;

import msc.ddb.international.abstracts.DealStrategy;

public class Deck {
    private ArrayList<Card> cards = new ArrayList<Card>();
    private int amountPacks = 1;
    private Pack pack;
    private DealStrategy dealStrategy;

    public Deck(Pack pack) {
        this.pack = pack;
        setCards();
    }

    public Deck(Pack pack, int amountPacks) {
        this.amountPacks = amountPacks;
        this.pack = pack;
        setCards();
    }

    private void setCards() {
        for (int i = 0; i < amountPacks; i++)
            cards.addAll(pack.getCards());
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void shuffle() {
        Collections.shuffle(cards, new Random());
    }

    @Override
    public String toString() {
        StringJoiner output = new StringJoiner(", ");
        for (Card card : cards) {
            output.add( card.toString() );
        }
        return "Deck [" + output.toString() + "]";
    }

    public String listCards() {
        StringJoiner output = new StringJoiner("\n");
        for (Card card : cards) {
            output.add( card.toString() );
        }
        return "Deck:\n" + output.toString();
    }
}
