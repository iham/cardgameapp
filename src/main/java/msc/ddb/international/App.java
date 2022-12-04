package msc.ddb.international;

import java.util.Scanner;

import msc.ddb.international.abstracts.Ranks;
import msc.ddb.international.abstracts.Suits;
import msc.ddb.international.packs.FrenchExtendedPackCreator;
import msc.ddb.international.packs.FrenchFullPackCreator;
import msc.ddb.international.ranks.french.FrenchRanks;
import msc.ddb.international.suits.french.FrenchSuits;

/**
 * This implementation is a collection of ideas to make use of several Software Design Patterns, such as:
 * - ABSTRACTION
 * - INTERFACE
 * - SINGLETON
 * - STRATEGY
 * - COMMAND
 * - STATE
 * - MEMENTO
 * - PROXY
 * 
 */
public class App 
{
    static Scanner input = new Scanner(System.in);
    
    /** 
     * @param args
     */
    public static void main( String[] args )
    {
        // Pack pack = new Pack(new FrenchPack52WithJokers());
        // System.out.println(pack);
        // Suitable club = Club.getInstance();
        // Suits frenchSuits = new FrenchSuits();
        Ranks frenchRanks = new FrenchRanks();
        Pack frenchPack = new Pack(new FrenchFullPackCreator(new FrenchRanks().getAvailableRanks(), new FrenchSuits().getAvailableSuits()) );
        // System.out.println(frenchSuits);
        // System.out.println(frenchRanks);
        System.out.println(frenchPack.listCards());
    }
}
