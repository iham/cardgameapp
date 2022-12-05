package msc.ddb.international.abstracts;

import msc.ddb.international.interfaces.Dealable;

public abstract class DealStrategy implements Dealable {
    private Game game;

    public DealStrategy(Game game) {
        this.game = game;
    }

    
}
