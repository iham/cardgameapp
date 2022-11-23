package msc.ddb.international.packs;

import java.util.ArrayList;

import msc.ddb.international.cards.Card;

public abstract class Pack {
    private String label;
    private ArrayList<Card> cards;

    public Pack(String label) {
        this.setLabel(label);
        this.setCards();
    }

    public String getLabel() {
        return this.label;
    }
    public ArrayList<Card> getCards() {
        return this.cards;
    }

    public void setLabel(String label) {
        if(label.length() == 0)
            label = "Unknown";
        this.label = label;
    }

    // each specific Pack of Cards need to define there own cards.
    protected abstract void setCards();

    @Override
    public String toString() {
        return "Pack [" + label + " consists of " + cards + "]";
    }
}
