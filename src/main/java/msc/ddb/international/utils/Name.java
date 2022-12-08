package msc.ddb.international.utils;

public class Name implements Nameable {
    String name;

    public Name(String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.isEmpty())
            name = "Unknown";
        this.name = name;
    }

    @Override
    public String toString() {
        return "Name [name=" + name + "]";
    }
    
}
