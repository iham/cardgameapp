package msc.ddb.international.blackjack;

public class BlackJackCard {
    private BlackJackSuit suit;
    private BlackJackRank rank;

    public BlackJackCard(BlackJackSuit suit, BlackJackRank rank) {
        setSuit(suit);
        setRank(rank);
    }
    
    private void setSuit(BlackJackSuit suit) {
        this.suit = suit;
    }
    private void setRank(BlackJackRank rank) {
        this.rank = rank;
    }

    public BlackJackSuit getSuit() {
        return suit;
    }
    public BlackJackRank getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return rank.toString() + " of " + suit.toString();
    }
    
}
