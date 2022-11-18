package ddb.international;

import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("Lets start a card game!");
        BlackJack game = new BlackJack();
        int count = 0;
        ArrayList<BlackJackCard> pickedCards = new ArrayList<BlackJackCard>();
        while(count < 18) {
            BlackJackCard card = game.pickCard();
            pickedCards.add(card);
            count += card.getValue();
        }
        if(count > 21) {
            System.out.println("you LOST");
        }
        else
            System.out.println("you WON");
        System.out.println("you picked those cards:");
        for (BlackJackCard card : pickedCards) {
            System.out.println(card);
        }
        System.out.println( "Finished card game!" );
    }
}
