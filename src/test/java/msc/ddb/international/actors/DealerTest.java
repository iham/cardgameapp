package msc.ddb.international.actors;

import static org.junit.Assert.*;
import org.junit.Test;

public class DealerTest {

    Dealer dealerTest = new Dealer("Dealer");

    @Test
    public void testGetName() {
        assertEquals("Dealer", dealerTest.getName());

    }

}
