package msc.ddb.international.ranks.numbers;

import msc.ddb.international.abstracts.Rank;

public class Ten extends Rank {
    private static Ten instance = null;

    private Ten() {
        super("Ten");
    }

    public static Ten getInstance()
    {
        if (instance == null)
            instance = new Ten();
  
        return instance;
    }
}
