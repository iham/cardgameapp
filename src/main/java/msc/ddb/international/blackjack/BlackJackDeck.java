package msc.ddb.international.blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class BlackJackDeck {
    private ArrayList<BlackJackCard> cards = new ArrayList<BlackJackCard>();

    public BlackJackDeck() {
        setCards();
        shuffle();
    }

    // BlackJack consists of 6 Packs of BlackJack Cards
    private void setCards() {
        BlackJackPack pack = new BlackJackPack("BlackJackPack");
        for (int i = 0; i < 6; i++) {
            cards.addAll(pack.getCards()); 
        }
    }

    public ArrayList<BlackJackCard> getCards() {
        return cards;
    }

    public void shuffle() {
        Collections.shuffle(cards, new Random());
    }

    public BlackJackCard getCard() {
        return cards.remove( cards.size() - 1 );
    }
    @Override
    public String toString() {
        String output = "";
        for (BlackJackCard card : cards) {
            output += card + "\n";
        }
        return output;
    }
}
