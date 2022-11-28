package msc.ddb.international.blackjack;

public enum BlackJackSuit {
    CLUB("Club"),
    DIAMOND("Diamond"),
    HEART("Heart"),
    SPADE("Spade");

    String name;

    private BlackJackSuit(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
 
}
