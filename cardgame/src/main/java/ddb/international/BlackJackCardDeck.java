package ddb.international;

import java.util.ArrayList;

public class BlackJackCardDeck {
    private ArrayList<BlackJackCard> cards = new ArrayList<BlackJackCard>();

    public BlackJackCardDeck() {
        setCards();
    }

    public ArrayList<BlackJackCard> getCards() {
        return cards;
    }
    private void setCards() {
        String[] colors = {
            "Hearts",
            "Diamonds",
            "Spades",
            "Clubs"
        };
        String[] names = {
            "Two",
            "Three",
            "Four",
            "Five",
            "Six",
            "Seven",
            "Eight",
            "Nine",
            "Ten",
            "Jack",
            "Queen",
            "King",
            "Ace"
        };

        int[] values = {
            2,
            3,
            4,
            5,
            6,
            7,
            8,
            9,
            10,
            10,
            10,
            10,
            11
        };

        // Combine a Deck of Cards with Color + Name
        for (int i = 0; i < colors.length; i++) {
            // System.out.println(colors[i]);
            for (int j = 0; j < names.length; j++) {
                // System.out.println(cards[j]);
                BlackJackCard card = new BlackJackCard(names[j], colors[i], values[j]);
                cards.add(card);
                // System.out.println(cardDeck[cards.length * i + j]);
            }
        }
    }

}
