package msc.ddb.international.packs;

import java.util.ArrayList;

import msc.ddb.international.interfaces.Rankable;
import msc.ddb.international.interfaces.Suitable;
import msc.ddb.international.ranks.french.Joker;
import msc.ddb.international.ranks.numbers.Eleven;
import msc.ddb.international.ranks.numbers.Thirteen;
import msc.ddb.international.ranks.numbers.Twelve;

public class FrenchFullPackCreator extends FrenchExtendedPackCreator {

    // public FrenchFullPackCreator(ArrayList<Rankable> availableRanks, ArrayList<Suitable> availableSuits) {
    //     super(availableRanks, availableSuits);
    // }

    public FrenchFullPackCreator(ArrayList<Rankable> availableRanks, ArrayList<Suitable> availableSuits) {
        super(availableRanks, availableSuits);
    }

    protected void manipulateCards() {
        removeRank(Joker.getInstance());
        removeRank(Eleven.getInstance());
        removeRank(Twelve.getInstance());
        removeRank(Thirteen.getInstance());
    }

}
