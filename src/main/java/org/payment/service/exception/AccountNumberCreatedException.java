package org.payment.service.exception;

public class AccountNumberCreatedException extends RuntimeException {
    public AccountNumberCreatedException(String message) {
        super(message);
    }
}
