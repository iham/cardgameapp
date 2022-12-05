package msc.ddb.international.abstracts;

import java.util.ArrayList;
import java.util.Iterator;

import msc.ddb.international.game.Card;
import msc.ddb.international.interfaces.Packable;
import msc.ddb.international.interfaces.Rankable;
import msc.ddb.international.interfaces.Suitable;

public abstract class PackCreator implements Packable {
    private ArrayList<Card> cards = new ArrayList<Card>();
    private ArrayList<Rankable> availableRanks;
    private ArrayList<Suitable> availableSuits;

    public PackCreator(ArrayList<Rankable> availableRanks, ArrayList<Suitable> availableSuits) {
        this.availableRanks = availableRanks;
        this.availableSuits = availableSuits;
    }
    
    public ArrayList<Card> createPack() {
        for (Suitable suitable : availableSuits) {
            for (Rankable rankable : availableRanks) {
                addCard(new Card(rankable, suitable));                
            }  
        }
        manipulateCards();
        return cards;
    }

    protected void addCard(Card card) {
        cards.add(card);
    }
    protected void removeRank(Rankable rankable) {
        Iterator<Card> itr = cards.iterator();
        while (itr.hasNext()) {
            Card card = itr.next();
            if(card.getRank().equals(rankable)) {
                itr.remove();
            }
            
        }
    }
    protected abstract void manipulateCards();

}
