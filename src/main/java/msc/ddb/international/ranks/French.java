package msc.ddb.international.ranks;

public enum French {
    DEUCE("Deuce"),
    THREE("Three"),
    FOUR("Four"),
    FIVE("Five"),
    SIX("Six"),
    SEVEN("Seven"),
    EIGHT("Eight"),
    NINE("Nine"),
    TEN("Ten"),
    ELEVEN("Eleven"),
    TWELVE("Twelve"),
    THIRTEEN("Thirteen"),
    JACK("Jack"),
    QUEEN("Queen"),
    KING("King"),
    ACE("Ace"),
    JOKER("Joker");

    String name;
    int rank;

    French(String name) {
        this.setName(name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }

    public String toString() {
        return "name: " + name + "; rank: " + rank;
    }
}
