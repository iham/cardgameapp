package msc.ddb.international.blackjack;

import java.util.ArrayList;

public class BlackJackHand {
    private ArrayList<BlackJackCard> hand = new ArrayList<BlackJackCard>();

    /**
     * A BlackJackHand represents a list of Cards taken by a <code>Person</code> from the <code>Deck</code>.
     */
    public BlackJackHand() {}

    public ArrayList<BlackJackCard> getHand(){
        return hand;
    }

    /**
     * A <code>BlackJackCard</code> is given to the hand of the Player.
     * 
     * @param card
     */
    public void addCard(BlackJackCard card) {
        hand.add(card);
    }
    public void addCardFromDeck(BlackJackDeck deck){
        BlackJackCard pickedCard = deck.getCard();
        if(pickedCard.getRank() == BlackJackRank.ACE) {
            if( (calculateHand() + pickedCard.getRank().value) > 21) {
                pickedCard.getRank().setValue(1);
            }
        }
        hand.add(pickedCard);
    }

    public int calculateHand() {
        int result = 0;
        for (BlackJackCard card : hand) {
            result += card.getRank().value;
        }
        return result;
    }
    public String toString() {
        String output = "";
        for (BlackJackCard card : hand) {
            output += card + "\n";
        }
        return output;
    }
}
