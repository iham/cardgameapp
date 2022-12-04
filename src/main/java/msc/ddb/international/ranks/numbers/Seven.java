package msc.ddb.international.ranks.numbers;

import msc.ddb.international.abstracts.Rank;

public class Seven extends Rank {
    private static Seven instance = null;

    private Seven() {
        super("Seven");
    }

    public static Seven getInstance()
    {
        if (instance == null)
            instance = new Seven();
  
        return instance;
    }
}
