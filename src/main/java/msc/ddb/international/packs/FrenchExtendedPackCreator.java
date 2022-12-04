package msc.ddb.international.packs;

import java.util.ArrayList;

import msc.ddb.international.Card;
import msc.ddb.international.abstracts.PackCreator;
import msc.ddb.international.interfaces.Rankable;
import msc.ddb.international.interfaces.Suitable;
import msc.ddb.international.ranks.french.Joker;

public class FrenchExtendedPackCreator extends PackCreator {

    public FrenchExtendedPackCreator(ArrayList<Rankable> availableRanks, ArrayList<Suitable> availableSuits) {
        super(availableRanks, availableSuits);
    }

    protected void manipulateCards() {
        addCard(new Card(Joker.getInstance()));
        addCard(new Card(Joker.getInstance()));
    }

}
