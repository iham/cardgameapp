package msc.ddb.international.ranks.french;

import msc.ddb.international.abstracts.Rank;

public class Joker extends Rank {
    private static Joker instance = null;

    private Joker() {
        super("Joker");
    }

    public static Joker getInstance()
    {
        if (instance == null)
            instance = new Joker();
  
        return instance;
    }
}
