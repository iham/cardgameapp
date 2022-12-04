package msc.ddb.international.packcreations;

import java.util.EnumSet;

import msc.ddb.international.ranks.FrenchRank;

public class FrenchPack52 extends FrenchPack {

    public FrenchPack52() {
        setUsedRanks(EnumSet.range(FrenchRank.DEUCE, FrenchRank.KING));
    }

}
