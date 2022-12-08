package msc.ddb.international.actors;

import java.util.LinkedHashMap;
import java.util.StringJoiner;

public class Hand {
    LinkedHashMap<String, Integer> cards = new LinkedHashMap<String, Integer>();

    public Hand() {}

    public LinkedHashMap<String, Integer> getCards() {
        return cards;
    }

    public void addCard(String card, int value) {
        cards.put(card, value);
    }

    public void setCards(LinkedHashMap<String, Integer> cards) {
        this.cards = cards;
    }

    public int calculateHand() {
        return cards.values().stream().reduce(0, (a, b) -> a + b);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cards == null) ? 0 : cards.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Hand other = (Hand) obj;
        if (cards == null) {
            if (other.cards != null)
                return false;
        } else if (!cards.equals(other.cards))
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringJoiner output = new StringJoiner(", ");
        cards.forEach((String name, Integer value) -> {
            output.add(String.format("Card [name=%s, value=%d]", name, value));
        });
        return String.format("Hand [cards=%s, sum=%d]", output.toString(), calculateHand());
    }


}
