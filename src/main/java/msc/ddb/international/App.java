package msc.ddb.international;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    static Scanner input = new Scanner(System.in);
    public static void main( String[] args )
    {
        // create a game
        Game game = new Game();
        Player player01 = new Player("Harald");
        game.setPlayer(player01);
        game.startGame();
        // lets play!
        System.out.println("--------------------\nWelcome to BlackJack!\n\n");
        int decision = 1;
        while(decision == 1) {
            try{
                System.out.println("Would you like to:\n1) Pick another Card?\n2) Chicken out?");
                decision = input.nextInt();
                switch (decision) {
                    case 1:
                        game.dealCard();
                        System.out.println(player01.getHand());
                        break;
                    case 2:
                        game.stopGame();
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
        // how did it run
        System.out.println(game);
    }
}
