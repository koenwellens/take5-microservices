package be.wellens.it.take5.table.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ResponseStatus(BAD_REQUEST)
public class CardCannotBeAddedToTableException extends RuntimeException {

    private static final String MESSAGE = "Card cannot be added to the table. There is no row in which it can be played.";

    public CardCannotBeAddedToTableException() {
        super(MESSAGE);
    }
}
