package msc.ddb.international.suits.french;

import msc.ddb.international.abstracts.Suit;

public class Club extends Suit {
    private static Club instance = null;

    private Club() {
        super("Club");
    }

    public static Club getInstance()
    {
        if (instance == null)
            instance = new Club();
  
        return instance;
    }
}
