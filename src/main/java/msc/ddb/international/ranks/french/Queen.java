package msc.ddb.international.ranks.french;

import msc.ddb.international.abstracts.Rank;

public class Queen extends Rank {
    private static Queen instance = null;

    private Queen() {
        super("Queen");
    }

    public static Queen getInstance()
    {
        if (instance == null)
            instance = new Queen();
  
        return instance;
    }
}
