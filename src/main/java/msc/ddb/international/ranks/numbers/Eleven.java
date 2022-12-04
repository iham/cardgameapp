package msc.ddb.international.ranks.numbers;

import msc.ddb.international.abstracts.Rank;

public class Eleven extends Rank {
    private static Eleven instance = null;

    private Eleven() {
        super("Eleven");
    }

    public static Eleven getInstance()
    {
        if (instance == null)
            instance = new Eleven();
  
        return instance;
    }
}
