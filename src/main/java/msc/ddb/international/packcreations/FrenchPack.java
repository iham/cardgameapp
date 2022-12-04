package msc.ddb.international.packcreations;

import java.util.ArrayList;
import java.util.EnumSet;

import msc.ddb.international.Card;
import msc.ddb.international.interfaces.Packable;
import msc.ddb.international.interfaces.Rankable;
import msc.ddb.international.interfaces.Suitable;
import msc.ddb.international.ranks.FrenchRank;
import msc.ddb.international.suits.FrenchSuit;

public abstract class FrenchPack implements Packable {
    private EnumSet<FrenchRank> usedRanks = EnumSet.range(FrenchRank.DEUCE, FrenchRank.JOKER);
    private ArrayList<Card> cards = new ArrayList<Card>();

    public void setUsedRanks(EnumSet<FrenchRank> ranks) {
        usedRanks = ranks;
    }

    @Override
    public ArrayList<Card> createPack() {
        // lets create some cards!
        for (Suitable suit : FrenchSuit.values()) {
            for (Rankable rank : usedRanks) {
                cards.add( new Card(rank, suit));
            }     
        }
        return cards;
    }
}
