package msc.ddb.international.ranks.french;

import msc.ddb.international.abstracts.Rank;

public class Ace extends Rank {
    private static Ace instance = null;

    private Ace() {
        super("Ace");
    }

    public static Ace getInstance()
    {
        if (instance == null)
            instance = new Ace();
  
        return instance;
    }
}
