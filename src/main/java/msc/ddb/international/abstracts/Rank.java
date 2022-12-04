package msc.ddb.international.abstracts;

import msc.ddb.international.interfaces.Rankable;

public abstract class Rank extends Name implements Rankable {

    public Rank(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Rank [name=" + super.getName() + "]";
    }
}
