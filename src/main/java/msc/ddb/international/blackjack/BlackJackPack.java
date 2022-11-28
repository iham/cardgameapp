package msc.ddb.international.blackjack;

import java.util.ArrayList;

public class BlackJackPack {
    private ArrayList<BlackJackCard> cards = new ArrayList<BlackJackCard>();

    public BlackJackPack(String name) {
        createCards();
    }

    public ArrayList<BlackJackCard> getCards() {
        return cards;
    }

    private void createCards() {
        for (BlackJackSuit suit : BlackJackSuit.values()) {
            for (BlackJackRank rank : BlackJackRank.values()) {
                BlackJackCard card = new BlackJackCard(suit, rank);
                cards.add(card);
            }   
        }
    };

    @Override
    public String toString() {
        String output = "";
        for (BlackJackCard card : cards) {
            output += card + "\n";
        }
        return output;
    }
}
