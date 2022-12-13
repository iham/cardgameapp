package msc.ddb.international;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;

import msc.ddb.international.actors.Hand;
import msc.ddb.international.actors.Person;
import msc.ddb.international.decks.Card;
import msc.ddb.international.decks.Deck;
import msc.ddb.international.exceptions.NotEnoughPlayersException;
import msc.ddb.international.exceptions.TooManyPlayersException;

/* 
 * <p><b> Game Class</b></p>
 * <p><i> Specialization of Class Game </i></p> 
 */

public class BlackJack extends Game {
    // states
    private LinkedHashMap<Person, String> playersWithState;

    // utils we use within the game
    private Scanner input = new Scanner(System.in);

    public BlackJack() throws TooManyPlayersException {
        super("BlackJack (17+4)");
        addDealerToPlayers(getDealer());
    }
    
    @Override
    public void addPlayer(Person player) throws TooManyPlayersException {
        super.addPlayer(player);
        initializeStateOfPlayer(player);
    }

    public void addDealerToPlayers(Person dealer) throws TooManyPlayersException {
        // if dealer isn't set, do that upfront
        if(!getPlayers().contains(dealer)) {
            addPlayer(dealer);
        }
        else {
            // TODO: Exception
            System.out.println("Dealer already added!");
        }
    }

    public void initializeStateOfPlayer(Person player) {
        if(playersWithState == null)
            playersWithState = new LinkedHashMap<Person, String>();
        playersWithState.put(player, "HIT");
    }

    public void initializeStateOfPlayers() {
        // init players with state "PLAY"
        getPlayers().forEach(player -> initializeStateOfPlayer(player));
    }

    public String getPlayerState(Person player) {
        return playersWithState.get(player);
    }

    public void setPlayerState(Person player) {
        // iterate all players based on the last change
        int value = player.getHand().calculateHand();
        boolean isDealer = player.equals(getDealer());
        // instanceof Dealer
        if (value > 21) {
            playersWithState.put(player, "LOST");
            if(isDealer == true) {
                getPlayers().forEach(opponent -> {
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
        Person dealer = getDealer();
        ArrayList<Person> players = getPlayers();
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

    @Override
    public int getValueForCard(Card card) {
        int value = 0;
        switch (card.getRank()) {
            case "Two":
                value = 2;
                break;
            case "Three":
                value = 3;
                break;
            case "Four":
                value = 4;
                break;
            case "Five":
                value = 5;
                break;
            case "Six":
                value = 6;
                break;
            case "Seven":
                value = 7;
                break;
            case "Eight":
                value = 8;
                break;
            case "Nine":
                value = 9;
                break;
            case "Ten":
                value = 10;
                break;
            case "Jack":
                value = 10;
                break;
            case "Queen":
                value = 10;
                break;
            case "King":
                value = 10;
                break;
            case "Ace":
                value = 11;
                break;
            default:
                break;
        }
        return value;
    }

    @Override
    public boolean gameHasParticipants() {
        // is there any player still playing?
        return playersWithState.containsValue("HIT");
    }

    @Override
    public boolean isPlayerParticipating(Person player) {
        // is player still playing?
        return playersWithState.get(player).contains("HIT");
    }

    @Override
    public boolean isPlayerContinuing(Person player) {
        boolean decision = false;
        // player ! isinstance of dealer
        if (!player.equals(getDealer())) {
            decision = interactWithPlayer(player);
        }
        else if(player.getHand().calculateHand() < 17) {
            decision = true;
        }
        // System.out.println(player.getName() + " decided to " + ((decision == true) ? "continue" : "stall"));

        return decision;
    }

    @Override
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

    @Override
    public void initialDeal() {
        // each player gets two card when the game starts
        Deck deck = getDeck();
        getPlayers().forEach((Person player) -> {
            Card card;
            Hand hand = player.getHand();
            card = deck.pickCard();
            hand.addCard(card, getValueForCard(card));
            card = deck.pickCard();
            hand.addCard(card, getValueForCard(card));
            setPlayerState(player);
        });
    }

    @Override
    public void initializeGame() throws NotEnoughPlayersException {
        if(getDealer() != null && getPlayers().size() >= getMinimumPlayers()) {
            setDeck(new Deck(6));
            initialDeal();
        }
        else
            throw new NotEnoughPlayersException("You need at least " + getMinimumPlayers() + " to play.");;
    }

    @Override
    public void startGame() {
        System.out.println("\n====================\nGame starts\n\n\n");
        int round = 1;
        while(gameHasParticipants() == true) {
            System.out.println("Round " + round + " started\n");
            getPlayers().forEach(player -> {
                if(isPlayerParticipating(player) == true) {
                    System.out.println("\nIt is " + player.getName() + "'s turn:");
                    System.out.println(createPlayerReport(player));
                    if(isPlayerContinuing(player) == true) {
                        Card card = getDeck().pickCard();
                        player.getHand().addCard(card, getValueForCard(card));
                        setPlayerState(player);
                        System.out.println(createPlayerReport(player));
                    }
                }   
            });
            round += 1;
        }
        endGame();
    }

    @Override
    public void endGame() {
        setFinalStates();
        System.out.println("\n\n\n" + getName() + " is finished.");
        System.out.println(createGameReport());;
    }

    @Override
    public String createPlayerReport(Person player) {
        StringBuilder report = new StringBuilder();
        Hand hand = player.getHand();
        report.append(player.getName() + " is in state \"" + getPlayerState(player) + "\" and has " + hand);
        return report.toString();
    }

}