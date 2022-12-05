package msc.ddb.international.states;

import msc.ddb.international.abstracts.Person;

public abstract class PlayerState {
    Person person;

    public PlayerState(Person person) {
        this.person = person;
    }

    public abstract String onLock();
    public abstract String onPlay();
    public abstract String onNext();
    public abstract String onPrevious();
    
}
