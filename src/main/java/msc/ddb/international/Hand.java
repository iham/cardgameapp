package msc.ddb.international;

import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> cards = new ArrayList<Card>();

    /**
     * A BlackJackHand represents a list of Cards taken by a <code>Person</code> from the <code>Deck</code>.
     */
    public Hand() {}

    public ArrayList<Card> getCards(){
        return cards;
    }

    /**
     * A <code>BlackJackCard</code> is given to the hand of the Player.
     * 
     * @param card
     */
    public void addCard(Card card) {
        if(card.getRank() == Rank.ACE) {
            // change card value, if the resulting Hand would be beyond 21
            if( (calculateHand() + card.getValue()) >= 21) {
                card.setValue(1);
                System.out.println(card);
            }
        }
        cards.add(card);
    }

    public int calculateHand() {
        int result = 0;
        for (Card card : cards) {
            result += card.getValue();
        }
        return result;
    }
    public String toString() {
        String output = "Hand:\n";
        int sum = calculateHand();
        for (Card card : cards)
            output += card + "\n";
        if(cards.size() < 1)
            output += "Currently no picked Cards in Hand\n";
        else
            output += "total: " + calculateHand() + "\n";
        return output;
    }
}
