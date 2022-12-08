package msc.ddb.international;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Random;
import java.util.Scanner;

import msc.ddb.international.actors.Dealer;
import msc.ddb.international.actors.Hand;
import msc.ddb.international.actors.Person;
import msc.ddb.international.utils.Name;

public class BlackJack extends Name {

    // Actors in the Game
    private final Person dealer = new Dealer("Dealer");
    private int minimumPlayers = 2;
    private int maximumPlayers = 10;

    // hands
    private ArrayList<Person> players = new ArrayList<Person>();

    // states
    private LinkedHashMap<Person, String> playersWithState = new LinkedHashMap<Person, String>();

    // the Deck of Cards
    private List<String> deck = new ArrayList<String>();
    private static final List<String> suits = new ArrayList<String>(Arrays.asList(
        "Hearts",
        "Diamonds",
        "Spades",
        "Clubs"
    ));
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

    // utils we use within the game
    private Random random = new Random();
    private Scanner input = new Scanner(System.in);

    public BlackJack() {
        super("BlackJack (17+4)");
        addDealer(dealer);
    }
    
    public int getMinimumPlayers() {
        return minimumPlayers;
    }

    public void setMinimumPlayers(int minimumPlayers) {
        if(minimumPlayers < 2)
            this.minimumPlayers = minimumPlayers;
        else
            // TODO: Exception here.
            System.out.println("A Game needs at least 2 Players: a Dealer AND an Opponent!");
    }

    public int getMaximumPlayers() {
        return maximumPlayers;
    }

    public void setMaximumPlayers(int maximumPlayers) {
        if(maximumPlayers > minimumPlayers) {
            if (maximumPlayers < this.maximumPlayers) {
                this.maximumPlayers = maximumPlayers;
            }
            else {
                // TODO: Exception here
                System.out.println("a maximum of 15 should do it.");
            }
        }
        else {
            // TODO: Exception here
            System.out.println("you can't set a maximum lower than the minimum amout of players.");
        }
    }

    public Person getDealer() {
        return dealer;
    }
    
    public void addDealer(Person dealer) {
        // if dealer isn't set, do that upfront
        if(!players.contains(dealer)) {
            addPlayer(dealer);
        }
        else {
            // TODO: Exception
            System.out.println("Dealer already added!");
        }
    }

    // Set Players - no getters and setters needed here.
    public void addPlayer(Person player) {
        if(players.size() < maximumPlayers) {
            players.add(player);
            initializeStateOfPlayer(player);
        }
    }

    public void initializeStateOfPlayer(Person player) {
        playersWithState.put(player, "HIT");
    }

    public void initializeStateOfPlayers() {
        // init players with state "PLAY"
        players.forEach(player -> initializeStateOfPlayer(player));
    }

    public void createDeck() {
        // lets create a deck of 52 cards
        ArrayList<String> tempDeck = new ArrayList<String>();
        for (String suit : suits) {
            for (String rank : ranks) {
                tempDeck.add(rank + " of " + suit);
            }                
        }
        // BlackJack has 6 decks, so lets add 5 copies
        for (int i = 0; i < 6; i++) {
            deck.addAll(tempDeck);    
        }
    }

    public void shuffleDeck() {
        Collections.shuffle(deck, random);
    }

    public String pickCardFromDeck() {
        // remove the last card from deck and return it
        return deck.remove(deck.size() - 1);
    }

    public void addCardToHand(Person player, String card) {
        int value = getValueForCard(card);
        Hand hand = player.getHand();
        if (value == 11 && hand.calculateHand() >= 11)
            value = 1;
        hand.addCard(card, value);
    }

    public int getValueForCard(String card) {
        int value = 0;
        for (int i = 0; i < ranks.length; i++) {
            if(card.contains(ranks[i])) {
                if (i < 9)
                    value = i+2;
                // Jack, Queen, King have 10
                else if (i >= 9 && i < 12)
                    value = 10;
                // Ace is 11
                else
                    value = 11;
            }
        }
        return value;
    }

    public boolean gameHasParticipants() {
        // is there any player still playing?
        return playersWithState.containsValue("HIT");
    }

    public boolean isPlayerParticipating(Person player) {
        // is player still playing?
        return playersWithState.get(player).contains("HIT");
    }

    public String getPlayerState(Person player) {
        return playersWithState.get(player);
    }

    public void setPlayerState(Person player) {
        // iterate all players based on the last change
        int value = player.getHand().calculateHand();
        boolean isDealer = player.equals(dealer);
        if (value > 21) {
            playersWithState.put(player, "LOST");
            if(isDealer == true) {
                players.forEach(opponent -> {
                    if(!opponent.equals(player) && playersWithState.get(opponent) != "LOST") {
                        playersWithState.put(opponent, "WON");
                    }
                });
                return;
            }
            return;
        }
        if(isDealer == true) {
            if(value >= 17 && value <= 21) {
                playersWithState.put(player, "HOLD");
                // if all other players LOST, Dealer wins
                return;
            }
        }
        else if (value == 21) {
            // player which reach 21 are winners.
            playersWithState.put(player, "WON");
            return;
        }
    }

    public void setFinalStates() {
        int dealerValue = dealer.getHand().calculateHand();
        players.forEach(player -> {
            if(!player.equals(dealer) && playersWithState.get(player).equals("HOLD")) {
                int playerValue = player.getHand().calculateHand();
                if(playerValue >= dealerValue) {
                    playersWithState.put(player, "WON");
                }
                else {
                    playersWithState.put(player, "LOST");
                }
            }
        });
        // if dealer is only player not lost
        if(playersWithState.get(dealer).equals("HOLD")) {
            // count players which are not the dealer and have LOST
            long count;
            count = playersWithState.entrySet().stream()
                            .filter(x -> !x.getKey().equals(dealer))
                            .filter(x -> x.getValue() == "LOST")
                            .count();
            // only dealer is not a looser, so its a WON round
            if ((players.size() - count) == 1) {
                playersWithState.put(dealer, "WON");
            }
            count = playersWithState.entrySet().stream()
                            .filter(x -> !x.getKey().equals(dealer))
                            .filter(x -> x.getValue() == "WON")
                            .count();
            // all players are winners? -> the dealer must be the looser
            if ((players.size() - 1) == count) {
                playersWithState.put(dealer, "LOST");
            }
            // lets check if all players who hasn't LOST is below dealer
            count = playersWithState.entrySet().stream()
                            .filter(x -> !x.getKey().equals(dealer))
                            .filter(player -> player.getKey().getHand().calculateHand() < dealer.getHand().calculateHand())
                            .count();
            if ((players.size() - count) == 1) {
                playersWithState.put(dealer, "WON");
            }
        }
    }

    public boolean isPlayerContinuing(Person player) {
        boolean decision = false;
        if (!player.equals(dealer)) {
            decision = interactWithPlayer(player);
        }
        else if(player.getHand().calculateHand() < 17) {
            decision = true;
        }
        System.out.println(player + " decided to " + ((decision == true) ? "continue" : "stall"));

        return decision;
    }

    public boolean interactWithPlayer(Person player) {
        boolean getAnotherCard = false;
        int decision = 0;
        while(decision == 0) {
            try{
                System.out.println(player.getName() + ", would you like to:\n1) HIT\n2) HOLD");
                decision = input.nextInt();
                switch (decision) {
                    case 1:
                        getAnotherCard = true;
                        break;
                    case 2:
                        playersWithState.put(player, "HOLD");
                        break;
                    default:
                        break;
                }
            }
            catch(Exception e){
                System.out.println("Invalid Input");
                input.next();
            }
        }
        return getAnotherCard;
    }

    public void initialDeal() {
        // each player gets two card when the game starts
        players.forEach((Person player) -> {
            String card;
            Hand hand = player.getHand();
            card = pickCardFromDeck();
            hand.addCard(card, getValueForCard(card));
            card = pickCardFromDeck();
            hand.addCard(card, getValueForCard(card));
            setPlayerState(player);
        });
    }

    public void initializeGame() {
        if(dealer != null && players.size() >= minimumPlayers) {
            createDeck();
            shuffleDeck();
            initialDeal();
        }
        else
            // TODO: throw Exception here
            System.out.println("you need at least " + minimumPlayers + " to play.");
    }

    public void startGame() {
        System.out.println("Game starts");
        System.out.println(createGameReport());
        int round = 1;
        while(gameHasParticipants() == true) {
            System.out.println("Round " + round + " started\n");
            players.forEach(player -> {
                System.out.println(player.getName() + "'s turn.\n");
                System.out.println(createPlayerReport(player));
                if(isPlayerParticipating(player) == true) {
                    if(isPlayerContinuing(player) == true) {
                        String card = pickCardFromDeck();
                        System.out.println(player.getName() + " picks card: " + card + "\n");
                        player.getHand().addCard(card, getValueForCard(card));
                        setPlayerState(player);
                    }
                }   
            });
            round += 1;
        }
        endGame();
    }

    public void endGame() {
        setFinalStates();
        System.out.println(getName() + " is finished.");
        System.out.println(createGameReport());;
    }

    public String createPlayerReport(Person player) {
        StringBuilder report = new StringBuilder();
        Hand hand = player.getHand();
        report.append(player.getName() + " is in state \"" + getPlayerState(player) + "\" and has Hand: \n");
        hand.getCards().forEach((String card, Integer value) -> {
            report.append(card + " (" + value + ")\n");
        });
        report.append("Total: " + hand.calculateHand() + "\n\n");
        return report.toString();
    }

    public String createGameReport() {
        StringBuilder report = new StringBuilder();
        players.forEach(player -> {
            report.append(createPlayerReport(player) + "\n");
        });
        return report.toString();
    }

    public String toString() {
        return getName() + "\n" + createGameReport();
    }

}
