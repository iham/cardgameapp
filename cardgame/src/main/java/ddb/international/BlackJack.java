package ddb.international;

import java.util.ArrayList;
import java.util.Collections;

public class BlackJack {
    final String name = "BlackJack (17+4)";
    final int amountCardsPerDeck = 52;
    final BlackJackCardDeck cardDeck = new BlackJackCardDeck();
    final int amountCardDecks = 6;
    private ArrayList<BlackJackCard> cardStack = new ArrayList<BlackJackCard>();
    private ArrayList<String> players = new ArrayList<String>();

    // constructors
    public BlackJack() {
        this.setCardStack();
        Collections.shuffle(cardStack);
    };

    // methods
    public void addPlayer(String player) {
        if (player.length() <= 0)
            player = "Player " + (players.size() + 1);
        this.players.add(player);
    }

    public BlackJackCard pickCard() {
        try {
            return cardStack.remove(cardStack.size() - 1);
        } catch (IndexOutOfBoundsException e) {
            // TODO: raise CouldntPickCard
            return new BlackJackCard();
        }
    }

    public ArrayList<BlackJackCard> getCardStack() {
        return cardStack;
    }

    // public ArrayList<String> getPlayers() {
    //     return players;
    // }

    // setters
    private void setCardStack() {
        for (int i = 0; i < amountCardDecks; i++) {
            cardStack.addAll(cardDeck.getCards());    
        }
    }

    // public void setPlayers(String[] players) {
    //     this.players = players;
    // }

}
