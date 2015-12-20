package com.orogersilva.empregocerto.utils.exception;

/**
 * Created by note-roger on 20/12/2015.
 */
public class ValidationFailedException extends RuntimeException {

    // region CONSTRUCTORS

    public ValidationFailedException() {}

    public ValidationFailedException(String detailMessage) {
        super(detailMessage);
    }

    // endregion
}
