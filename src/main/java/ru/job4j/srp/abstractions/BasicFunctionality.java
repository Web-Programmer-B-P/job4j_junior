package ru.job4j.srp.abstractions;

import ru.job4j.srp.event.EventHandler;
import ru.job4j.srp.interfaces.CommonOperation;

/**
 * Class BasicFunctionality
 *
 * @author Petr B.
 * @since 30.11.2019, 15:29
 */
abstract public class BasicFunctionality implements CommonOperation {
    private final String typeOfOperation;
    private final int keyOfOperation;

    public BasicFunctionality(String nameOfOperation, int nameOfKey) {
        typeOfOperation = nameOfOperation;
        keyOfOperation = nameOfKey;
    }

    @Override
    public String getInfoOfOperation() {
        return String.format("%s - %s\n",  keyOfOperation, typeOfOperation);
    }

    @Override
    public int getKeyOfOperation() {
        return keyOfOperation;
    }

    @Override
    public abstract double doOperation(EventHandler handle);
}
