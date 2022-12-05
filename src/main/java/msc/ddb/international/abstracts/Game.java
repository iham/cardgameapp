package msc.ddb.international.abstracts;

import java.util.ArrayList;

public class Game extends Name {
    private int rounds = 0;
    private int minPlayers = 0;
    private int maxPlayers;
    private boolean direction = false;
    private ArrayList<Person> players;
    private Person dealer;
    
    public Game(String name) {
        super(name);
    }
    
}
