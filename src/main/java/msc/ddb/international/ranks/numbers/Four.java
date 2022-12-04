package msc.ddb.international.ranks.numbers;

import msc.ddb.international.abstracts.Rank;

public class Four extends Rank {
    private static Four instance = null;

    private Four() {
        super("Four");
    }

    public static Four getInstance()
    {
        if (instance == null)
            instance = new Four();
  
        return instance;
    }
}
