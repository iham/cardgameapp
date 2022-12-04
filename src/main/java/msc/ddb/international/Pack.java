package msc.ddb.international;

import java.util.ArrayList;

import msc.ddb.international.interfaces.Packable;

public class Pack {
    private ArrayList<Card> cards = new ArrayList<Card>();

    public Pack(Packable packCreation) {
        cards = packCreation.createPack();
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        for (Card card : cards) {
            output.append(card);
            output.append("\n");
        }
        return output.toString();
    }
}
