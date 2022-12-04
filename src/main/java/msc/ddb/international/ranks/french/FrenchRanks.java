package msc.ddb.international.ranks.french;

import msc.ddb.international.abstracts.Ranks;
import msc.ddb.international.ranks.numbers.Eight;
import msc.ddb.international.ranks.numbers.Eleven;
import msc.ddb.international.ranks.numbers.Five;
import msc.ddb.international.ranks.numbers.Four;
import msc.ddb.international.ranks.numbers.Nine;
import msc.ddb.international.ranks.numbers.Seven;
import msc.ddb.international.ranks.numbers.Six;
import msc.ddb.international.ranks.numbers.Ten;
import msc.ddb.international.ranks.numbers.Thirteen;
import msc.ddb.international.ranks.numbers.Three;
import msc.ddb.international.ranks.numbers.Twelve;

public class FrenchRanks extends Ranks {

    @Override
    public void setAvailableRanks() {
        addAvailableRank(Deuce.getInstance());
        addAvailableRank(Three.getInstance());
        addAvailableRank(Four.getInstance());
        addAvailableRank(Five.getInstance());
        addAvailableRank(Six.getInstance());
        addAvailableRank(Seven.getInstance());
        addAvailableRank(Eight.getInstance());
        addAvailableRank(Nine.getInstance());
        addAvailableRank(Ten.getInstance());
        addAvailableRank(Eleven.getInstance());
        addAvailableRank(Twelve.getInstance());
        addAvailableRank(Thirteen.getInstance());
        addAvailableRank(Jack.getInstance());
        addAvailableRank(Queen.getInstance());
        addAvailableRank(King.getInstance());
        addAvailableRank(Ace.getInstance());

    }
}
