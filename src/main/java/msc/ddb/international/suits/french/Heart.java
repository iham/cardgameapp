package msc.ddb.international.suits.french;

import msc.ddb.international.abstracts.Suit;

public class Heart extends Suit {
    private static Heart instance = null;

    private Heart() {
        super("Heart");
    }

    public static Heart getInstance()
    {
        if (instance == null)
            instance = new Heart();
  
        return instance;
    }
}
