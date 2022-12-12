package msc.ddb.international;

import java.util.ArrayList;
import msc.ddb.international.actors.Dealer;
import msc.ddb.international.actors.Hand;
import msc.ddb.international.actors.Person;
import msc.ddb.international.decks.Card;
import msc.ddb.international.decks.Deck;
import msc.ddb.international.utils.Name;

/* 
 * <p><b> Game Class</b></p>
 * <p><i> Specialization of Name Class </i></p> 
 */

public abstract class Game extends Name {

    private int minimumPlayers = 2;
    private int maximumPlayers = 10;

    // Actors in the Game
    private Person dealer;
    private ArrayList<Person> players = new ArrayList<Person>();

    // the Deck of Cards
    private Deck deck;

    public Game(String name) {
        super(name);
        setDealer(new Dealer("Dealer"));
    }

    
    /** 
     * @return int
     */
    public int getMinimumPlayers() {
        return minimumPlayers;
    }

    
    /** 
     * @param minimumPlayers
     */
    public void setMinimumPlayers(int minimumPlayers) {
        if(minimumPlayers < 2)
            this.minimumPlayers = minimumPlayers;
        else
            // TODO: Exception here.
            System.out.println("A Game needs at least 2 Players: a Dealer AND an Opponent!");
    }

    
    /** 
     * @return int (#maximum Players)
     */
    public int getMaximumPlayers() {
        return maximumPlayers;
    }

    
    /** 
     * @param maximumPlayers ()
     */
    public void setMaximumPlayers(int maximumPlayers) {
        try {
           if(maximumPlayers > minimumPlayers) {
                if (maximumPlayers < this.maximumPlayers) {
                    this.maximumPlayers = maximumPlayers;
                }
                else {
                    // TODO: Exception here
                    System.out.println("a maximum of 15 should do it.");
                }
            }
        } catch (Exception e) {
            System.out.println("you can't set a maximum lower than the minimum amout of players.");
        }
    }

    
    /** 
     * @return Person
     */
    public Person getDealer() {
        return dealer;
    }
    
    
    /** 
     * @param dealer
     */
    private void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }
    
    
    /** 
     * @return ArrayList<Person>
     */
    public ArrayList<Person> getPlayers() {
        return players;
    }

    
    /** 
     * @param player
     */
    // Set Players - no getters and setters needed here.
    public void addPlayer(Person player) {
        if(players.size() < maximumPlayers) {
            players.add(player);
        }
    }

    
    /** 
     * @param player
     * @param card
     */
    public void addCardToHand(Person player, Card card) {
        int value = getValueForCard(card);
        Hand hand = player.getHand();
        if (value == 11 && hand.calculateHand() >= 11)
            value = 1;
        hand.addCard(card, value);
    }

    
    /** 
     * @return Deck
     */
    public Deck getDeck() {
        return deck;
    }

    
    /** 
     * @param deck
     */
    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public abstract int getValueForCard(Card card);

    public abstract boolean gameHasParticipants();

    public abstract boolean isPlayerParticipating(Person player);

    
    /** 
     * @param player
     * @return boolean (Is the player continuing the game 0|1)
     */
    public boolean isPlayerContinuing(Person player) {
        return interactWithPlayer(player);
    }

    public abstract boolean interactWithPlayer(Person player);

    public abstract void initialDeal();

    public abstract void initializeGame();

    public abstract void startGame();

    public abstract void endGame();

    
    /** 
     * @param player (Person of player)
     * @return String (return the complete Hand of the player)
     */
    public String createPlayerReport(Person player) {
        StringBuilder report = new StringBuilder();
        Hand hand = player.getHand();
        report.append(player.getName() + "\" and has Hand: \n");
        hand.getCards().forEach((Card card, Integer value) -> {
            report.append(card + "\n");
        });
        report.append("Total: " + hand.calculateHand() + "\n\n");
        return report.toString();
    }

    
    /** 
     * @return String (Stringbuilde = a mutable sequence of characters will be returned containing the status of the hand)
     */
    public String createGameReport() {
        StringBuilder report = new StringBuilder();
        players.forEach(player -> {
            report.append(createPlayerReport(player) + "\n");
        });
        return report.toString();
    }

    
    /** 
     * @return String
     */
    public String toString() {
        return getName() + "\n" + createGameReport();
    }

}
