package ru.job4j.ocp.operations;

import ru.job4j.srp.abstractions.BasicFunctionality;
import ru.job4j.srp.event.EventHandler;
import java.util.List;

/**
 * Class Cos
 *
 * @author Petr B.
 * @since 01.12.2019, 15:57
 */
public class Cos extends BasicFunctionality {
    private final String nameOperation;

    public Cos(String nameOfOperation, int keyOfOperation) {
        super(nameOfOperation, keyOfOperation);
        nameOperation = nameOfOperation;
    }

    @Override
    public double doOperation(EventHandler handle) {
        System.out.println(nameOperation);
        List<Double> number = handle.commonHandler(1);
        return Math.cos(number.get(0));
    }
}
