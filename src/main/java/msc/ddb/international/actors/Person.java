package msc.ddb.international.actors;

import msc.ddb.international.utils.Name;

public abstract class Person extends Name {
    private Hand hand = new Hand();


    public Person(String name) {
        super(name);
        setHand(hand);
        hand = new Hand();
    }

    public Person(String name, Hand hand) {
        super(name);
        setHand(hand);
    }
    
    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand.setCards(hand.getCards());
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        // if (getClass() != obj.getClass())
        //     return false;
        Person other = (Person) obj;
        if (getName() == null) {
            if (other.getName() != null)
                return false;
        } else if (!getName().equals(other.getName()))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " [" + super.toString() + ", hand=" + hand + "]";
    }

}
