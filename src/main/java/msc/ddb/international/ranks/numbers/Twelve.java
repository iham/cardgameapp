package msc.ddb.international.ranks.numbers;

import msc.ddb.international.abstracts.Rank;

public class Twelve extends Rank {
    private static Twelve instance = null;

    private Twelve() {
        super("Twelve");
    }

    public static Twelve getInstance()
    {
        if (instance == null)
            instance = new Twelve();
  
        return instance;
    }
}
