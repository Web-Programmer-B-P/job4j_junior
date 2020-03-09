package ru.job4j.ocp.menu;

import ru.job4j.ocp.operations.Cos;
import ru.job4j.ocp.operations.Sin;
import ru.job4j.srp.interfaces.CommonInputData;
import ru.job4j.srp.menu.Menu;

/**
 * Class MenuEngineeringCalc
 *
 * @author Petr B.
 * @since 01.12.2019, 15:54
 */
public class MenuEngineeringCalc extends Menu {
    public MenuEngineeringCalc(CommonInputData commonInputData) {
        super(commonInputData);
    }

    @Override
    public void fillMenuOfOperation() {
        super.fillMenuOfOperation();
        listOfOperations.add(new Cos("Операция вычисления косинуса", indexOfOperation++));
        listOfOperations.add(new Sin("Операция вычисления синуса", indexOfOperation++));
    }
}
