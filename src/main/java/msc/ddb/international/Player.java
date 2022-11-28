package msc.ddb.international;

public class Player extends Person {
    public Player(){
        super();
    }
    public Player(String name) {
        setName(name);
    }

    @Override
    public void setName(String name) {
        if(name == "")
            name = "Player";
        super.setName(name);
    }
    public void decide() {

    }
}
