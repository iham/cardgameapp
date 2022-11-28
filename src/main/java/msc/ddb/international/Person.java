package msc.ddb.international;

import msc.ddb.international.blackjack.BlackJackHand;

public abstract class Person {

    private String name;
    private BlackJackHand hand = new BlackJackHand();

    public Person() {}
    public Person(String name){
        setName(name);
    }

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }

    public BlackJackHand getHand() {
        return hand;
    }

    @Override
    public String toString() {
        return name + " has those cards in hand:\n" + hand;
    }
}
