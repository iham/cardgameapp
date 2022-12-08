package msc.ddb.international;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Random;
import java.util.Scanner;

public class BlackJack {

    private String name = "BlackJack (17+4)";

    // Actors in the Game
    private String dealer;
    private int minimumPlayers = 2;
    private int maximumPlayers = 10;
    // hands
    private LinkedHashMap<String, LinkedHashMap<String, Integer>> players = new LinkedHashMap<String, LinkedHashMap<String, Integer>>();
    // states
    private LinkedHashMap<String, String> playersWithState = new LinkedHashMap<String, String>();

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

    public BlackJack(String dealer) {
        setDealer(dealer);
        addDealer(this.dealer);
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
            if (maximumPlayers < 15) {
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

    public String getDealer() {
        return dealer;
    }
    
    public void setDealer(String dealer) {
        if(dealer.equals(""))
            dealer = "Dealer";
        this.dealer = dealer;
    }

    public void addDealer(String dealer) {
        // if dealer isn't set, do that upfront 
        if(this.dealer.isEmpty() == true) {
            setDealer(dealer);
        }
        // a dealer is a Player too
        if(!players.containsKey(dealer)) {
            addPlayer(dealer);
        }
        else {
            // TODO: Exception
            System.out.println("Dealer already added!");
        }
    }

    // Set Players - no getters and setters needed here.
    public void addPlayer(String player) {
        if(players.size() < maximumPlayers) {
            if(player.equals(""))
                player = "Player " + (players.size() + 1);
            // a newly added Player comes empty handed
            LinkedHashMap<String, Integer> hand = new LinkedHashMap<String, Integer>();
            this.players.put(player, hand);
            initializeStateOfPlayer(player);
        }
    }

    public void initializeStateOfPlayer(String player) {
        playersWithState.put(player, "HIT");
    }

    public void initializeStateOfPlayers() {
        // init players with state "PLAY"
        players.forEach((String player, LinkedHashMap<String, Integer> hand) -> {
            initializeStateOfPlayer(player);
        });
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

    public void addCardToHand(LinkedHashMap<String, Integer> hand, String card) {
        int value = getValueForCard(card);
        if (value == 11 && calculateHand(hand) >= 11)
            value = 1;
        hand.put(card, value);
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

    public int calculateHand(LinkedHashMap<String, Integer> hand) {
        return hand.values().stream().reduce(0, (a, b) -> a + b);
    }

    public boolean gameHasParticipants() {
        // is there any player still playing?
        return playersWithState.containsValue("HIT");
    }

    public boolean isPlayerParticipating(String player) {
        // is player still playing?
        return playersWithState.get(player).contains("HIT");
    }

    public String getPlayerState(String player) {
        return playersWithState.get(player);
    }

    public void setPlayerState(String player) {
        // iterate all players based on the last change
        int value = calculateHand(players.get(player));
        boolean isDealer = player == dealer;
        if (value > 21) {
            playersWithState.put(player, "LOST");
            if(isDealer == true) {
                players.forEach((String opponent, LinkedHashMap<String, Integer> hand) -> {
                    if(opponent != player && playersWithState.get(opponent) != "LOST") {
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
        int dealerValue = calculateHand(players.get(dealer));
        players.forEach((String player, LinkedHashMap<String, Integer> hand) -> {
            if(player != dealer && playersWithState.get(player).equals("HOLD")) {
                int playerValue = calculateHand(hand);
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
                            .filter(x -> x.getKey() != dealer)
                            .filter(x -> x.getValue() == "LOST")
                            .count();
            // only dealer is not a looser, so its a WON round
            if ((players.size() - count) == 1) {
                playersWithState.put(dealer, "WON");
            }
            count = playersWithState.entrySet().stream()
                            .filter(x -> x.getKey() != dealer)
                            .filter(x -> x.getValue() == "WON")
                            .count();
            // all players are winners? -> the dealer must be the looser
            if ((players.size() - 1) == count) {
                playersWithState.put(dealer, "LOST");
            }
            // lets check if all players who hasn't LOST is below dealer
            count = playersWithState.entrySet().stream()
                            .filter(player -> player.getKey() != dealer)
                            .filter(player -> calculateHand(players.get(player.getKey())) < calculateHand(players.get(dealer)))
                            .count();
            if ((players.size() - count) == 1) {
                playersWithState.put(dealer, "WON");
            }
        }
    }

    public boolean isPlayerContinuing(String player) {
        boolean decision = false;
        if (player != dealer) {
            decision = interactWithPlayer(player);
        }
        else if(calculateHand(players.get(player)) < 17) {
            decision = true;
        }
        System.out.println(player + " decided to " + ((decision == true) ? "continue" : "stall"));

        return decision;
    }

    public boolean interactWithPlayer(String player) {
        boolean getAnotherCard = false;
        int decision = 0;
        while(decision == 0) {
            try{
                System.out.println(player + ", would you like to:\n1) HIT\n2) HOLD");
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
        players.forEach((String player, LinkedHashMap<String, Integer> hand) -> {
            addCardToHand(hand, pickCardFromDeck());
            addCardToHand(hand, pickCardFromDeck());
            setPlayerState(player);
        });
    }

    public void initializeGame() {
        if(dealer.isEmpty() == false && players.size() >= minimumPlayers) {
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
            players.forEach((String player, LinkedHashMap<String, Integer> hand) -> {
                System.out.println(player + "'s turn.\n");
                System.out.println(createPlayerReport(player, hand));
                if(isPlayerParticipating(player) == true) {
                    if(isPlayerContinuing(player) == true) {
                        String card = pickCardFromDeck();
                        System.out.println(player + " picks card: " + card + "\n");
                        addCardToHand(hand, card);
                        setPlayerState(player);
                    }
                }   
            });
            round += 1;
        }
        endGame();
    }

    public void endGame() {
        // setFinalStates();
        System.out.println(name + " is finished.");
        System.out.println(createGameReport());;
    }

    public String createPlayerReport(String player, LinkedHashMap<String, Integer> hand) {
        StringBuilder report = new StringBuilder();
        report.append(player + " is in state \"" + getPlayerState(player) + "\" and has Hand: \n");
        hand.forEach((String card, Integer value) -> {
            report.append(card + " (" + value + ")\n");
        });
        report.append("Total: " + calculateHand(hand) + "\n\n");
        return report.toString();
    }

    public String createGameReport() {
        StringBuilder report = new StringBuilder();
        players.forEach((String player, LinkedHashMap<String, Integer> hand) -> {
            report.append(createPlayerReport(player, hand) + "\n");
        });
        return report.toString();
    }

    public String toString() {
        return name+ "\n" + createGameReport();
    }
}
