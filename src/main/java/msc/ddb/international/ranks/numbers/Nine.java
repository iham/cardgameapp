package msc.ddb.international.ranks.numbers;

import msc.ddb.international.abstracts.Rank;

public class Nine extends Rank {
    private static Nine instance = null;

    private Nine() {
        super("Nine");
    }

    public static Nine getInstance()
    {
        if (instance == null)
            instance = new Nine();
  
        return instance;
    }
}
