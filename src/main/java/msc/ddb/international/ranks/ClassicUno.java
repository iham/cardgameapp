package msc.ddb.international.ranks;

public enum ClassicUno {
    ZERO("Zero"),
    TWO("Two"),
    THREE("Three"),
    FOUR("Four"),
    FIVE("Five"),
    SIX("Six"),
    SEVEN("Seven"),
    EIGHT("Eight"),
    NINE("Nine"),
    SKIP("Skip"),
    REVERSE("Reverse"),
    DRAW2("Draw 2"),
    WILD("Wild"),
    WILD4("Wild 2");

    String name;
    int rank;

    ClassicUno(String name) {
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
