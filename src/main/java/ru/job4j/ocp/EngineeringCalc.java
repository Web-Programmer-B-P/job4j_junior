package ru.job4j.ocp;

import ru.job4j.ocp.menu.MenuEngineeringCalc;
import ru.job4j.srp.InteractCalc;
import ru.job4j.srp.input.ConsoleInputData;
import ru.job4j.srp.interfaces.CommonInputData;
import ru.job4j.srp.menu.Menu;

/**
 * Class EngineeringCalc
 *
 * @author Petr B.
 * @since 01.12.2019, 15:47
 */
public class EngineeringCalc extends InteractCalc {
    public EngineeringCalc(Menu menuCalculator, CommonInputData inputData) {
        super(menuCalculator, inputData);
    }

    public static void main(String[] args) {
        new EngineeringCalc(new MenuEngineeringCalc(new ConsoleInputData()), new ConsoleInputData()).init();
    }
}
