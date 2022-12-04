package msc.ddb.international;

import java.util.Scanner;

import msc.ddb.international.packcreations.FrenchPack52WithJokers;

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
        Pack pack = new Pack(new FrenchPack52WithJokers());
        System.out.println(pack);
    }
}
