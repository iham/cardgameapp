package msc.ddb.international;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import msc.ddb.international.exceptions.MaximumPlayersBelowAllowedMinimumException;
import msc.ddb.international.exceptions.MaximumPlayersBeyondAllowedMaximumException;
import msc.ddb.international.exceptions.TooManyPlayersException;

/**
 * Unit test for simple App.
 * 
 * <p><b> CardGameApp Unit test </b></p>
 * 
 * @author Felix Ossmann
 * @version 4.1
 * 
 */
 
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test(expected = MaximumPlayersBelowAllowedMinimumException.class)
    public void tryToSetMaximumPlayersBelowAllowedMinimum() throws MaximumPlayersBelowAllowedMinimumException, MaximumPlayersBeyondAllowedMaximumException {
        BlackJack blackJack;
        try {
            blackJack = new BlackJack();
            blackJack.setMaximumPlayers(1);
        } catch (TooManyPlayersException e) {
            e.printStackTrace();
        }
    }
}
