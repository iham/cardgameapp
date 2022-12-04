package msc.ddb.international.ranks.numbers;

import msc.ddb.international.abstracts.Rank;

public class One extends Rank {
    private static One instance = null;

    private One() {
        super("One");
    }

    public static One getInstance()
    {
        if (instance == null)
            instance = new One();
  
        return instance;
    }
}
