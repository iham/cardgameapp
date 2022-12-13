package msc.ddb.international.exceptions;

public class NotEnoughPlayersException extends Exception {
    public NotEnoughPlayersException(String errorMessage) {
        super(errorMessage);
    }
}
