package msc.ddb.international.abstracts;

import msc.ddb.international.interfaces.Nameable;

public abstract class Name implements Nameable {
    private String name;

    public Name(String name) {
        setName(name);
    }

    public void setName(String name) {
        if(name.equals(""))
            name = "Unknown";
        this.name = name;
            
    }
    
    public String getName() {
        return name;
    }
    
    @Override
    public String toString() {
        return "Name [name=" + name + "]";
    }
}
