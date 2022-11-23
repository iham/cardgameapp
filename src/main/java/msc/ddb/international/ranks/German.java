package msc.ddb.international.ranks;

public enum German {
    SIX("Six"),
    SEVEN("Seven"),
    EIGHT("Eight"),
    NINE("Nine"),
    TEN("Ten"),
    UNTER("Unter"),
    OBER("Ober"),
    KING("King"),
    ACE("Ace");

    String name;
    int rank;

    German(String name) {
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
