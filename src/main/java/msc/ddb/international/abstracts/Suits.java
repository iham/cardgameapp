package msc.ddb.international.abstracts;

import java.util.ArrayList;
import java.util.StringJoiner;

import msc.ddb.international.interfaces.Nameable;
import msc.ddb.international.interfaces.Suitable;

public abstract class Suits {
    private ArrayList<Suitable> available = new ArrayList<Suitable>();

    public Suits() {
        setAvailableSuits();
    }

    public abstract void setAvailableSuits();

    public ArrayList<Suitable> getAvailableSuits() {
        return available;
    }

    public void addAvailableSuit(Suitable suit) {
        available.add(suit);
    }

    @Override
    public String toString() {
        StringJoiner output = new StringJoiner(", ");
        for (Suitable suitable : available) {
            output.add( ((Nameable)suitable).getName() );
        }
        return "Suits [" + output.toString() + "]";
    }    
}
