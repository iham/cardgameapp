package msc.ddb.international.abstracts;

import msc.ddb.international.interfaces.Suitable;

public abstract class Suit extends Name implements Suitable {

    public Suit(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Suit [name=" + super.getName() + "]";
    }
    
}
