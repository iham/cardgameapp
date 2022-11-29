package msc.ddb.international;

public class Game {
    private Deck deck = new Deck();
    private Player player;
    private boolean state = false;

    public Game() {}

    // methods
    public void setPlayer(Player player) {
        this.player = player;
    }

    public void dealCard() {
        Card card = deck.pickCard();
        player.getHand().addCard(card);
    }

    public void startGame() {
        state = true;
    }
    public void stopGame() {
        state = false;
    }
    public void writeGame() {
        // write game to filesystem
        // timestamp as filename
        // write tostring to txt file or json
    }

    @Override
    public String toString() {
        String output = "BlackJack (17 + 4): \n\n";
        if(player != null)
            output += player;
        else
            output += "No Player set (yet)\n";
        if(state == false) {
            int sum = player.getHand().calculateHand();
            if(sum <=17)
                output += "You chickened out so low ... but ok: still a WIN.";
            else if(sum > 17 && sum < 21)
                output += "You made a solid WIN";
            else if(sum == 21) {
                if (player.getHand().getCards().size() > 2)
                    output += "(soft) ";
                output += "BLACKJACK!\n";
            }
        }
        return output;
    }
}
