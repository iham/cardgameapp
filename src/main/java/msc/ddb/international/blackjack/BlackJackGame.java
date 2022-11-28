package msc.ddb.international.blackjack;

import java.util.ArrayList;

import msc.ddb.international.Dealer;
import msc.ddb.international.Person;

public class BlackJackGame {
    final String name = "BlackJack (17+4)";
    final BlackJackDeck deck = new BlackJackDeck();
    private Dealer dealer = new Dealer();
    private ArrayList<Person> players = new ArrayList<Person>();

    public BlackJackGame() {}

    // methods
    public void addPlayer(Person player) {
        players.add(player);
    }

    @Override
    public String toString() {
        String output = "";
        output += "Game: " + name + "\n";
        output += "Players:\n";
        for (Person person : players) {
            output += person + "\n";
        }
        return output;
    }
}
