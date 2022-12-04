package msc.ddb.international.ranks.numbers;

import msc.ddb.international.abstracts.Rank;

public class Zero extends Rank {
    private static Zero instance = null;

    private Zero() {
        super("Zero");
    }

    public static Zero getInstance()
    {
        if (instance == null)
            instance = new Zero();
  
        return instance;
    }
}
