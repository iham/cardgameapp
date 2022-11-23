package msc.ddb.international.packs;

public enum Suit {
    CLUB("Club"),
    DIAMOND("Diamond"),
    HEART("Heart"),
    SPADE("Spade");

    String name;

    private Suit(String name) {
        this.name = name;
    }

}
