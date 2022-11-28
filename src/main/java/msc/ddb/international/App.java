package msc.ddb.international;

import msc.ddb.international.blackjack.BlackJackCard;
import msc.ddb.international.blackjack.BlackJackDeck;
import msc.ddb.international.blackjack.BlackJackGame;
import msc.ddb.international.blackjack.BlackJackPack;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // BlackJackPack pack = new BlackJackPack("BlackJackPack");
        // System.out.println(pack.getCards().size());
        // System.out.println(pack);
        // BlackJackDeck deck = new BlackJackDeck();
        // System.out.println(deck.getCards().size());
        // System.out.println(deck);
        // BlackJackCard lastCardFromDeck = deck.getCard();
        // System.out.println(lastCardFromDeck);
        // System.out.println(deck.getCards().size());
        // lastCardFromDeck = deck.getCard();
        // System.out.println(lastCardFromDeck);

        BlackJackGame game = new BlackJackGame();
        Person player01 = new Player("Player 01");
        Person player02 = new Player("Player 02");
        game.addPlayer(player01);
        game.addPlayer(player02);
        game.startGame();
        System.out.println(game);
    }
}
