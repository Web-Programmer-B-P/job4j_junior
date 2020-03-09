package ru.job4j.srp.operations;

import ru.job4j.srp.abstractions.BasicFunctionality;
import ru.job4j.srp.event.EventHandler;

import java.util.List;

/**
 * Class Add
 *
 * @author Petr B.
 * @since 30.11.2019, 15:35
 */
public class Add extends BasicFunctionality {
    private final String nameOperation;

    public Add(String nameOfOperation, int keyOfOperation) {
        super(nameOfOperation, keyOfOperation);
        nameOperation = nameOfOperation;
    }

    @Override
    public double doOperation(EventHandler handle) {
        System.out.println(nameOperation);
        List<Double> number = handle.commonHandler(2);
        return number.get(0) + number.get(1);
    }
}
