package msc.ddb.international.ranks.numbers;

import msc.ddb.international.abstracts.Rank;

public class Six extends Rank {
    private static Six instance = null;

    private Six() {
        super("Six");
    }

    public static Six getInstance()
    {
        if (instance == null)
            instance = new Six();
  
        return instance;
    }
}
