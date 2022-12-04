package msc.ddb.international.suits.french;

import msc.ddb.international.abstracts.Suit;

public class Diamond extends Suit {
    private static Diamond instance = null;

    private Diamond() {
        super("Diamond");
    }

    public static Diamond getInstance()
    {
        if (instance == null)
            instance = new Diamond();
  
        return instance;
    }
}
