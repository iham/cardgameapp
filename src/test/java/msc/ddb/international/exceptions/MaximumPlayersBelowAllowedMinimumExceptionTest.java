package msc.ddb.international.exceptions;

import org.junit.Test;

import msc.ddb.international.BlackJack;


public class MaximumPlayersBelowAllowedMinimumExceptionTest {

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
