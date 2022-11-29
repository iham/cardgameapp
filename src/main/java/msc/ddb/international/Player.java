package msc.ddb.international;

public class Player {

    private String name;
    private Hand hand = new Hand();

    public Player() {
        setName("Anonymous");
    }
    public Player(String name){
        setName(name);
    }

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        // TODO: Exception for empty String
        this.name = name;
    }

    public Hand getHand() {
        return hand;
    }

    @Override
    public String toString() {
        return "\"" + name + "\"\n" + hand;
    }
}
