package msc.ddb.international.suits.french;

import msc.ddb.international.abstracts.Suits;

public class FrenchSuits extends Suits {

    @Override
    public void setAvailableSuits() {
        addAvailableSuit(Club.getInstance());
        addAvailableSuit(Diamond.getInstance());
        addAvailableSuit(Heart.getInstance());
        addAvailableSuit(Spade.getInstance());
    }
}
