package msc.ddb.international.ranks;

public enum Swiss {
    DEUCE("Deuce"),
    THREE("Three"),
    FOUR("Four"),
    FIVE("Five"),
    SIX("Six"),
    SEVEN("Seven"),
    EIGHT("Eight"),
    NINE("Nine"),
    BANNER("Banner"),
    UNDER("Under"),
    OBER("Ober"),
    KING("King"),
    ACE("Ace");

    String name;
    int rank;

    Swiss(String name) {
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
