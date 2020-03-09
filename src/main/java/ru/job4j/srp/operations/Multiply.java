package ru.job4j.srp.operations;

import ru.job4j.srp.abstractions.BasicFunctionality;
import ru.job4j.srp.event.EventHandler;
import java.util.List;

/**
 * Class Multiply
 *
 * @author Petr B.
 * @since 30.11.2019, 16:05
 */
public class Multiply extends BasicFunctionality {
    private final String nameOperation;

    public Multiply(String nameOfOperation, int nameOfKey) {
        super(nameOfOperation, nameOfKey);
        nameOperation = nameOfOperation;
    }

    @Override
    public double doOperation(EventHandler handle) {
        System.out.println(nameOperation);
        List<Double> number = handle.commonHandler(2);
        return number.get(0) * number.get(1);
    }
}
