package msc.ddb.international.ranks.numbers;

import msc.ddb.international.abstracts.Rank;

public class Thirteen extends Rank {
    private static Thirteen instance = null;

    private Thirteen() {
        super("Thirteen");
    }

    public static Thirteen getInstance()
    {
        if (instance == null)
            instance = new Thirteen();
  
        return instance;
    }
}
