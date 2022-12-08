package msc.ddb.international;

import java.util.Scanner;

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
        BlackJack game = new BlackJack("");
        game.addPlayer("Player 1");
        game.addPlayer("Player 2");
        game.initializeGame();
        game.startGame();
    }
}
