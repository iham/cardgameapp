package msc.ddb.international.ranks.numbers;

import msc.ddb.international.abstracts.Rank;

public class Two extends Rank {
    private static Two instance = null;

    private Two() {
        super("Two");
    }

    public static Two getInstance()
    {
        if (instance == null)
            instance = new Two();
  
        return instance;
    }
}
