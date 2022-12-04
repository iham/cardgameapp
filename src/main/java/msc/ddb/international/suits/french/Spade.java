package msc.ddb.international.suits.french;

import msc.ddb.international.abstracts.Suit;

public class Spade extends Suit {
    private static Spade instance = null;

    private Spade() {
        super("Spade");
    }

    public static Spade getInstance()
    {
        if (instance == null)
            instance = new Spade();
  
        return instance;
    }
}
