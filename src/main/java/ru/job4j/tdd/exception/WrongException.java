package ru.job4j.tdd.exception;

/**
 * Class WrongException
 *
 * @author Petr B.
 * @since 08.12.2019, 19:04
 */
public class WrongException extends RuntimeException {
    public WrongException(String exception) {
        super(exception);
    }
}
