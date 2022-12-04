package msc.ddb.international.ranks.french;

import msc.ddb.international.abstracts.Rank;

public class King extends Rank {
    private static King instance = null;

    private King() {
        super("King");
    }

    public static King getInstance()
    {
        if (instance == null)
            instance = new King();
  
        return instance;
    }
}
