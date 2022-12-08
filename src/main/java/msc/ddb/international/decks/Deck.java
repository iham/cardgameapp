package msc.ddb.international.decks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {
    private ArrayList<Card> cards = new ArrayList<Card>();
    private int multiplier = 1;

    private Random random = new Random();

    private static final String[] suits = {
        "Hearts",
        "Diamonds",
        "Spades",
        "Clubs"
    };
    private static final String[] ranks = {
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

    public Deck() {
        createDeck();
        shuffleDeck();
    }

    public Deck(int multiplier) {
        setMultiplier(multiplier);
        createDeck();
        shuffleDeck();
    }

    private void createDeck() {
        // lets create a deck of 52 cards
        ArrayList<Card> temp = new ArrayList<Card>();
        for (String suit : suits) {
            for (String rank : ranks) {
                temp.add(new Card(rank, suit));
            }                
        }
        // BlackJack has 6 decks, so lets add 5 copies
        for (int i = 0; i < 6; i++) {
            cards.addAll(temp);    
        }
    }

    private void shuffleDeck() {
        Collections.shuffle(cards, random);
    }

    public Card pickCard() {
        // remove the last card from deck and return it
        return cards.remove(cards.size() - 1);
    }    

    private void setMultiplier(int multiplier) {
        if(multiplier > 0)
            this.multiplier = multiplier;
        else {
            // TODO: throw Exception
            System.out.println("no negativ values allowed.");
        }
    }

    @Override
    public String toString() {
        return "Deck [multiplier=" + multiplier + ", cardAmount=" + cards.size() + "]";
    }
 
}
