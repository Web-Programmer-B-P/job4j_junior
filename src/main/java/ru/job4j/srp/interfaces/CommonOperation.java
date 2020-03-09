package ru.job4j.srp.interfaces;

import ru.job4j.srp.event.EventHandler;

/**
 * Class CommonOperation
 *
 * @author Petr B.
 * @since 30.11.2019, 15:48
 */
public interface CommonOperation {
    String getInfoOfOperation();
    int getKeyOfOperation();
    double doOperation(EventHandler handle);
}
