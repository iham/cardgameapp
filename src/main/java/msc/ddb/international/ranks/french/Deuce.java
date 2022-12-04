package msc.ddb.international.ranks.french;

import msc.ddb.international.abstracts.Rank;

public class Deuce extends Rank {
    private static Deuce instance = null;

    private Deuce() {
        super("Deuce");
    }

    public static Deuce getInstance()
    {
        if (instance == null)
            instance = new Deuce();
  
        return instance;
    }
}
