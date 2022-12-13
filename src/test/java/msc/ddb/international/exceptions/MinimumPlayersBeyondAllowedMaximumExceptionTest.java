package msc.ddb.international.exceptions;

import org.junit.Test;

import msc.ddb.international.BlackJack;

public class MinimumPlayersBeyondAllowedMaximumExceptionTest {

    @Test(expected = MinimumPlayersBeyondAllowedMaximumException.class)
    public void tryToSetMinimumPlayersBeyondAllowedMaximum() throws MinimumPlayersBelowAllowedMinimumException, MinimumPlayersBeyondAllowedMaximumException {
        BlackJack blackJack;
        try {
            blackJack = new BlackJack();
            blackJack.setMinimumPlayers(18);
        } catch (TooManyPlayersException e) {
            e.printStackTrace();
        }
    }


}
