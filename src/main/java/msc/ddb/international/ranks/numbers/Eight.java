package msc.ddb.international.ranks.numbers;

import msc.ddb.international.abstracts.Rank;

public class Eight extends Rank {
    private static Eight instance = null;

    private Eight() {
        super("Eight");
    }

    public static Eight getInstance()
    {
        if (instance == null)
            instance = new Eight();
  
        return instance;
    }
}
