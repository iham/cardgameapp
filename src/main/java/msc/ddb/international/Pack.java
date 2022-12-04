package msc.ddb.international;

import java.util.ArrayList;
import java.util.StringJoiner;

import msc.ddb.international.abstracts.PackCreator;

public class Pack {
    private ArrayList<Card> cards = new ArrayList<Card>();

    public Pack(PackCreator creator) {
        cards = creator.createPack();
    }

    @Override
    public String toString() {
        StringJoiner output = new StringJoiner(", ");
        for (Card card : cards) {
            output.add( card.toString() );
        }
        return "Pack [" + output.toString() + "]";
    }

    public String listCards() {
        StringJoiner output = new StringJoiner("\n");
        for (Card card : cards) {
            output.add( card.toString() );
        }
        return "Pack:\n" + output.toString();
    }
}
