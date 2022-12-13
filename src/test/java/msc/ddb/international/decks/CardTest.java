package msc.ddb.international.decks;

import static org.junit.Assert.*;
import org.junit.Test;

public class CardTest {
    
    @Test
	public void testgetRank() {
		Card card = new Card("King");
        assertEquals("King", card.getRank());
	}

    @Test
	public void testsetSuit() {
		Card card = new Card("Queen", "Hearts");
        assertEquals("Hearts", card.getSuit());
	}
}
