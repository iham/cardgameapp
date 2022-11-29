package msc.ddb.international;

public enum Rank {
    DEUCE("Deuce", 2),
    THREE("Three", 3),
    FOUR("Four", 4),
    FIVE("Five", 5),
    SIX("Six", 6),
    SEVEN("Seven", 7),
    EIGHT("Eight", 8),
    NINE("Nine", 9),
    TEN("Ten", 10),
    JACK("Jack", 10),
    QUEEN("Queen", 10),
    KING("King", 10),
    ACE("Ace", 11);

    String name;
    int value;

    Rank(String name, int value) {
        this.name = name;
        this.value = value;
    }

    void setValue(int value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return name;
    }
}
