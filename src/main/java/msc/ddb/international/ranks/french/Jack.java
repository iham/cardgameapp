package msc.ddb.international.ranks.french;

import msc.ddb.international.abstracts.Rank;

public class Jack extends Rank {
    private static Jack instance = null;

    private Jack() {
        super("Jack");
    }

    public static Jack getInstance()
    {
        if (instance == null)
            instance = new Jack();
  
        return instance;
    }
}
