package msc.ddb.international;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 * 
 */
public class App 
{
    /** 
     * @param args
     */
    public static void main( String[] args )
    {
        List<String> l1 = new ArrayList<String>();
        l1.add("l1.1");
        l1.add("l1.2");
        l1.add("l1.3");
        l1.add("l1.4");
        List<String> l2 = new ArrayList<String>();
        l2.add("l2.1");
        l2.add("l2.2");
        l2.add("l2.3");
        l2.add("l2.4");
        List<String> l3 = new ArrayList<String>();
        l3.addAll(l1);
        l3.addAll(l2);
        
        List<String> l4 = new ArrayList<String>();
        l4.add("l4.1");
        l4.add("l4.2");
        l4.add("l4.3");
        l4.add("l4.4");
        
        l4.addAll(20, l4);
        System.out.println(l4);

        // System.out.println("Abstract without overdoing it.");
        // BlackJack game = new BlackJack("");
        // game.addPlayer("Markus");
        // game.startGame();
        // System.out.println(game);
    }
}
