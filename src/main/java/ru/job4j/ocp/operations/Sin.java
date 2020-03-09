package ru.job4j.ocp.operations;

import ru.job4j.srp.abstractions.BasicFunctionality;
import ru.job4j.srp.event.EventHandler;
import java.util.List;

/**
 * Class Sin
 *
 * @author Petr B.
 * @since 01.12.2019, 18:31
 */
public class Sin extends BasicFunctionality {
    private final String nameOperation;

    public Sin(String nameOfOperation, int keyOfOperation) {
        super(nameOfOperation, keyOfOperation);
        nameOperation = nameOfOperation;
    }

    @Override
    public double doOperation(EventHandler handle) {
        System.out.println(nameOperation);
        List<Double> number = handle.commonHandler(1);
        return Math.sin(number.get(0));
    }
}
