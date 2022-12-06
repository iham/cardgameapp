package msc.ddb.international;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class BlackJack {

    public String name = "BlackJack (17+4)";

    // Actors in the Game
    public String dealer;
    public int minimumPlayers = 2;
    public int maximumPlayers = 10;
    // hands
    public HashMap<String, HashMap<String, Integer>> players = new HashMap<String, HashMap<String, Integer>>();
    // states
    public List<String> playersWithStateHold = new ArrayList<String>();
    public List<String> playersWithStateLost = new ArrayList<String>();
    public List<String> playersWithStateWon = new ArrayList<String>();

    // the Deck of Cards
    public List<String> deck = new ArrayList<String>();
    public static final List<String> suits = new ArrayList<String>(Arrays.asList(
        "Hearts",
        "Diamonds",
        "Spades",
        "Clubs"
    ));
    public static final String[] ranks = {
    // public static final List<String> ranks = new ArrayList<String>(Arrays.asList(
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
    // ));
    };

    // utils we use within the game
    public Random random = new Random();
    public Scanner input = new Scanner(System.in);

    public BlackJack(String dealer) {
        setDealer(dealer);
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
        if(this.dealer.isEmpty()) {
            setDealer(dealer);
            // a dealer is a Player too
            addPlayer(dealer);
        }
        else
            // TODO: Exception
            System.out.println("Dealer already added!");
    }

    // Set Players - no getters and setters needed here.
    public void addPlayer(String player) {
        if(players.size() < maximumPlayers) {
            if(player.equals(""))
                player = "Player " + (players.size() + 1);
            // a newly added Player comes empty handed
            HashMap<String, Integer> hand = new HashMap<String, Integer>();
            this.players.put(player, hand);
        }
    }

    // public void initializePlayerStates() {}

    public void createDeck() {
        // lets create a deck of 52 cards
        for (String suit : suits) {
            for (String rank : ranks) {
                deck.add(rank + " of " + suit);
            }                
        }
        // BlackJack has 6 decks, so lets add 5 copies
        for (int i = 0; i < 6; i++) {
            deck.addAll(deck);
        }
    }

    public void shuffleDeck() {
        Collections.shuffle(deck, new Random());
    }

    public String pickCardFromDeck() {
        // remove the last card from deck and return it
        return deck.remove(deck.size() - 1);
    }

    public void initialDeal() {
        // each player gets two card when the game starts
        players.forEach((String player, HashMap<String, Integer> hand) -> {
            addCardToHand(hand, pickCardFromDeck());
            addCardToHand(hand, pickCardFromDeck());
            setPlayerState(player);
        });
    }

    public void addCardToHand(HashMap<String, Integer> hand, String card) {
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

    public int calculateHand(HashMap<String, Integer> hand) {
        return hand.values().stream().reduce(0, (a, b) -> a + b);
    }

    public boolean gameHasParticipants() {
        // if all players are in states lost, won or hold -> nobody plays anymore
        int inactivePlayers = playersWithStateHold.size();
        inactivePlayers += playersWithStateLost.size();
        inactivePlayers += playersWithStateWon.size();
        return players.size() != inactivePlayers;
    }

    public boolean isPlayerParticipating(String player) {
        // if the player is not in one of the lists, he is still in the game
        return (
            (!playersWithStateHold.contains(player)) == true ||
            (!playersWithStateLost.contains(player)) == true ||
            (!playersWithStateWon.contains(player)) == true
        );
    }

    public void setPlayerState(String player) {
        int value = calculateHand(players.get(player));
        // no matter who you are... beyond 21 you are done.
        if (value > 21) {
            playersWithStateLost.add(player);
            return;
        }
        boolean isDealer = player == dealer;
        if(isDealer == true) {
            // hold dealer, if 17+
            if(value >= 17 && value < 21) {
                playersWithStateHold.add(player);
                return;
            }
        }
        else {
            boolean isDealerOnLost = playersWithStateLost.contains(dealer);
            if(isDealerOnLost == true) {
                playersWithStateWon.add(player);
                return;
            }
            boolean isDealerOnHold = playersWithStateHold.contains(dealer);
            if(isDealerOnHold == true) {
                int valueDealer = calculateHand(players.get(player));
                if(valueDealer <= value) {
                    // in case of a tie the player is in advance too
                    playersWithStateWon.add(player);
                    return;
                }
                else if (valueDealer > value) {
                    playersWithStateLost.add(player);
                    return;
                }
            }
        }
    }

    public boolean isPlayerContinuing(String player) {
        boolean decision = false;
        if (player != dealer) {
            decision = interactWithPlayer(player);
        }
        else if(calculateHand(players.get(player)) < 17)
            decision = true;

        return decision;
    }

    public void initializeGame() {
        if(dealer.isEmpty() == false && players.size() > minimumPlayers) {
            createDeck();
            shuffleDeck();
            initialDeal();
        }
        else
            // TODO: throw Exception here
            System.out.println("you need at least " + minimumPlayers + "to play.");
    }

    public void startGame() {
        while(gameHasParticipants() == true) {
            players.forEach((String player, HashMap<String, Integer> hand) -> {
                if(isPlayerParticipating(player) == true) {
                    // player is not on lost, won or hold
                    // lets see if this has changed (especially in the first round)
                    if(isPlayerContinuing(player) == true) {
                        addCardToHand(hand, pickCardFromDeck());
                    }
                    setPlayerState(player);
                }
            });
        }
        endGame();
    }

    public void endGame() {
        System.out.println("we are done here...");
        createGameReport();
    }

    public boolean interactWithPlayer(String player) {
        boolean getAnotherCard = false;
        int decision = 0;
        while(decision == 0) {
            try{
                System.out.println("Would you like to:\n1) Pick another Card?\n2) Chicken out?");
                decision = input.nextInt();
                switch (decision) {
                    case 1:
                        getAnotherCard = true;
                        break;
                    case 2:
                        playersWithStateHold.add(player);
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

    public String createGameReport() {
        return "Game Report:";
    }
    public String toString() {
        return "BlackJack Game";
    }
}
