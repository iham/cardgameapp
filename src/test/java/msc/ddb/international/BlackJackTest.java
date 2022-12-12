package msc.ddb.international;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.NoSuchElementException;

public class BlackJackTest {

	BlackJack blackjacktest = new BlackJack("BlackJack (17+4)");

	@Test
	public void ConstructorTest() {

		assertTrue(blackjacktest instanceof BlackJack);
	}

	@Test
	public void testgetName() {
		assertEquals("BlackJack (17+4)", blackjacktest.getName());
	}

	@Test
	public void testsetName() {
		blackjacktest.setName("BlackJack");
		assertEquals("BlackJack", blackjacktest.getName());
	}

	@Test
	public void testGetMinimumPlayers() {
		assertEquals(2, blackjacktest.getMinimumPlayers());
	}

	@Test(expected = NoSuchElementException.class)
	public void testsetMinimumPlayers() {

		blackjacktest.setMinimumPlayers(3);
		blackjacktest.getMinimumPlayers();
	}

	@Test
	public void testGetMaximumPlayers() {
		assertEquals(10, blackjacktest.getMaximumPlayers());
	}

	@Test(expected = NoSuchElementException.class)
	public void testSetMaximumPlayers() {

		blackjacktest.setMaximumPlayers(18);
		blackjacktest.getMaximumPlayers();
	}

	@Test
	public void testgetDealer() {
		assertEquals("BlackJack (17+4)", blackjacktest.getDealer());
	}

	@Test
	public void testsetDealer() {
		blackjacktest.setDealer("");
		assertEquals("Dealer", blackjacktest.getDealer());
	}

	@Test
	public void testgetValueForCard() {

		assertEquals(10, blackjacktest.getValueForCard("King"));
	}

	@Test
	public void testaddPlayer() {

		blackjacktest.addPlayer("Player 3");
		assertEquals(2, blackjacktest.players.size());
	}

}
