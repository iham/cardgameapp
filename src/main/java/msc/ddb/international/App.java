package msc.ddb.international;


import msc.ddb.international.actors.Player;

public class App 
{
    public static void main( String[] args )
    {
        BlackJack game = new BlackJack();
        game.addPlayer(new Player("Player 1"));
        game.addPlayer(new Player("Player 2"));
        game.initializeGame();
        game.startGame();
    }
}
