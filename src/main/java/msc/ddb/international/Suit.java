package msc.ddb.international;

public enum Suit {
    CLUB("Club"),
    DIAMOND("Diamond"),
    HEART("Heart"),
    SPADE("Spade");

    String name;

    private Suit(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
 
}
