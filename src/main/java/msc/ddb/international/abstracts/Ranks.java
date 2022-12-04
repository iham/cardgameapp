package msc.ddb.international.abstracts;

import java.util.ArrayList;
import java.util.StringJoiner;

import msc.ddb.international.interfaces.Nameable;
import msc.ddb.international.interfaces.Rankable;

public abstract class Ranks {
    private ArrayList<Rankable> available = new ArrayList<Rankable>();

    
    public Ranks() {
        setAvailableRanks();
    }

    public abstract void setAvailableRanks();

    public ArrayList<Rankable> getAvailableRanks() {
        return available;
    }  
    public void addAvailableRank(Rankable rank) {
        available.add(rank);
    }

    @Override
    public String toString() {
        StringJoiner output = new StringJoiner(", ");
        for (Rankable rankable : available) {
            output.add( ((Nameable)rankable).getName() );
        }
        return "Ranks [" + output.toString() + "]";
    }

}
