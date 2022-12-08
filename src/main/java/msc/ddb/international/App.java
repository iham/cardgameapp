package msc.ddb.international;

import java.util.Scanner;

import msc.ddb.international.actors.Dealer;
import msc.ddb.international.actors.Hand;
import msc.ddb.international.actors.Person;
import msc.ddb.international.actors.Player;

/**
 * Hello world!
 * 
 */
public class App 
{
    public static Scanner input = new Scanner(System.in);

    /** 
     * @param args
     */
    public static void main( String[] args )
    {
        // Hand hand = new Hand();
        // hand.addCard("Jack", 10);
        // hand.addCard("5", 5);

        // Person player = new Player("Markus", hand);
        
        // Person dealer = new Dealer("Markus", hand);
        // System.out.println(((Person)dealer).equals((Person)player));
        // System.out.println(player.equals(dealer));
        BlackJack game = new BlackJack();
        game.addPlayer(new Player("Player 1"));
        game.addPlayer(new Player("Player 2"));
        game.initializeGame();
        game.startGame();
    }
}
