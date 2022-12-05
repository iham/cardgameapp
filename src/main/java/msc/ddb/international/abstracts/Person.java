package msc.ddb.international.abstracts;

import java.util.Date;

import msc.ddb.international.game.Hand;
import msc.ddb.international.states.PlayerState;

public abstract class Person extends Name {
    private Date dateOfBirthDate;
    private Hand hand;
    private PlayerState state;

    public Person(String name) {
        super(name);
    }
    
}
