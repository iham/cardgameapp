package msc.ddb.international;

import java.util.ArrayList;
import msc.ddb.international.actors.Dealer;
import msc.ddb.international.actors.Hand;
import msc.ddb.international.actors.Person;
import msc.ddb.international.decks.Card;
import msc.ddb.international.decks.Deck;
import msc.ddb.international.exceptions.MaximumPlayersBelowAllowedMinimumException;
import msc.ddb.international.exceptions.MaximumPlayersBeyondAllowedMaximumException;
import msc.ddb.international.exceptions.MinimumPlayersBelowAllowedMinimumException;
import msc.ddb.international.exceptions.MinimumPlayersBeyondAllowedMaximumException;
import msc.ddb.international.exceptions.NotEnoughPlayersException;
import msc.ddb.international.exceptions.TooManyPlayersException;
import msc.ddb.international.utils.Name;

/** 
 * <p><b> Game Class</b></p>
 * <p><i> Specialization of Class Name </i></p> 
 * 
 * @author Markus Hilbert
 * 
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
     * @return int (#minimumPlayers)
     */
    public int getMinimumPlayers() {
        return minimumPlayers;
    }

    
    /** 
     * @param minimumPlayers (#minimumPlayers)
     */
    public void setMinimumPlayers(int minimumPlayers) throws MinimumPlayersBelowAllowedMinimumException, MinimumPlayersBeyondAllowedMaximumException {
        if(minimumPlayers <= maximumPlayers) {
            if (minimumPlayers >= this.minimumPlayers) {
                this.minimumPlayers = minimumPlayers;
            }
            else
                throw new MinimumPlayersBelowAllowedMinimumException("The Minimum is " + this.minimumPlayers + " with " + minimumPlayers + " you go below that");
        }
        else
            throw new MinimumPlayersBeyondAllowedMaximumException("You tried to set the minimum " + minimumPlayers + " amount of Players beyond the allowed maximum of " + maximumPlayers + ".");
    }

    
    /** 
     * @return int (#maximum Players)
     */
    public int getMaximumPlayers() {
        return maximumPlayers;
    }

    
    /** 
     * @param maximumPlayers (#maximumPlayers for this game)
     * @throws MaximumPlayersBelowAllowedMinimumException (Exception if )
     * @throws MaximumPlayersBeyondAllowedMaximumException (Exception if )
     */
    public void setMaximumPlayers(int maximumPlayers) throws MaximumPlayersBelowAllowedMinimumException, MaximumPlayersBeyondAllowedMaximumException {
        if(maximumPlayers >= minimumPlayers) {
            if (maximumPlayers  <= this.maximumPlayers) {
                this.maximumPlayers = maximumPlayers;
            }
            else
                throw new MaximumPlayersBeyondAllowedMaximumException("You can't set the maximum " + maximumPlayers + " beyond the allowed maximum of" + this.maximumPlayers);
        }
        else
            throw new MaximumPlayersBelowAllowedMinimumException("a maximum of 15 should do it.");
    }

    
    /** 
     * @return Person (Dealer)
     */
    public Person getDealer() {
        return dealer;
    }
    
    
    /** 
     * @param dealer (Dealer)
     */
    private void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }
    
    
    /** 
     * @return ArrayList<Person> (players)
     */
    public ArrayList<Person> getPlayers() {
        return players;
    }

    
    /** 
     * @param player (add player check maximumSize of Players)
     */
    // Set Players - no getters and setters needed here.
    public void addPlayer(Person player) throws TooManyPlayersException {
        if(players.size() < maximumPlayers) {
            players.add(player);            
        }
        else
            throw new TooManyPlayersException("Game already has " + getPlayers().size() + " players; the allowed maximum is "+ getMaximumPlayers() + ".");

    }

    
    /** 
     * @param player (person)
     * @param card (card)
     */
    public void addCardToHand(Person player, Card card) {
        int value = getValueForCard(card);
        Hand hand = player.getHand();
        if (value == 11 && hand.calculateHand() >= 11)
            value = 1;
        hand.addCard(card, value);
    }

    
    /** 
     * @return Deck (deck)
     */
    public Deck getDeck() {
        return deck;
    }

    
    /** 
     * @param deck (deck)
     */
    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public abstract int getValueForCard(Card card);

    public abstract boolean gameHasParticipants();

    public abstract boolean isPlayerParticipating(Person player);

    
    /** 
     * @param player (person)
     * @return boolean (Is the player continuing the game 0|1)
     */
    public boolean isPlayerContinuing(Person player) {
        return interactWithPlayer(player);
    }

    public abstract boolean interactWithPlayer(Person player);

    public abstract void initialDeal();

    public abstract void initializeGame() throws NotEnoughPlayersException;

    public abstract void startGame();

    public abstract void endGame();

    
    /** 
     * @param player (Person of player)
     * @return String (return the complete Hand of the player)
     */
    public String createPlayerReport(Person player) {
        StringBuilder report = new StringBuilder();
        Hand hand = player.getHand();
        report.append(player.getName() + "\" and has " + hand);
        return report.toString();
    }

    
    /** 
     * @return String (Stringbuilder = a mutable sequence of characters will be returned containing the status of the hand)
     */
    public String createGameReport() {
        StringBuilder report = new StringBuilder();
        players.forEach(player -> {
            report.append(createPlayerReport(player) + "\n\n");
        });
        return report.toString();
    }

    
    /** 
     * @return String (name of the Game)
     */
    public String toString() {
        return getName() + "\n" + createGameReport();
    }

}
