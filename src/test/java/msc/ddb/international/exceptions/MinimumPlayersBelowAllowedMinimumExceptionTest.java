package msc.ddb.international.exceptions;

import org.junit.Test;

import msc.ddb.international.BlackJack;

public class MinimumPlayersBelowAllowedMinimumExceptionTest {

    @Test(expected = MinimumPlayersBelowAllowedMinimumException.class)
    public void tryToSetMinimumPlayersBelowAllowedMinimum() throws MinimumPlayersBelowAllowedMinimumException, MinimumPlayersBeyondAllowedMaximumException {
        BlackJack blackJack;
        try {
            blackJack = new BlackJack();
            blackJack.setMinimumPlayers(1);
        } catch (TooManyPlayersException e) {
            e.printStackTrace();
        }
    }


}
