package msc.ddb.international.exceptions;

import org.junit.Test;

import msc.ddb.international.BlackJack;

public class MaximumPlayersBeyondAllowedMaximumExceptionTest {

    @Test(expected = MaximumPlayersBeyondAllowedMaximumException.class)
    public void tryToSetMaximumPlayersBeyondAllowedMaximum() throws MaximumPlayersBelowAllowedMinimumException, MaximumPlayersBeyondAllowedMaximumException {
        BlackJack blackJack;
        try {
            blackJack = new BlackJack();
            blackJack.setMaximumPlayers(18);
        } catch (TooManyPlayersException e) {
            e.printStackTrace();
        }
    }

}

