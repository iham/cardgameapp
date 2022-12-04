package msc.ddb.international.ranks.numbers;

import msc.ddb.international.abstracts.Rank;

public class Five extends Rank {
    private static Five instance = null;

    private Five() {
        super("Five");
    }

    public static Five getInstance()
    {
        if (instance == null)
            instance = new Five();
  
        return instance;
    }
}
