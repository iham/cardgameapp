package msc.ddb.international.ranks.numbers;

import msc.ddb.international.abstracts.Rank;

public class Three extends Rank {
    private static Three instance = null;

    private Three() {
        super("Three");
    }

    public static Three getInstance()
    {
        if (instance == null)
            instance = new Three();
  
        return instance;
    }
}
