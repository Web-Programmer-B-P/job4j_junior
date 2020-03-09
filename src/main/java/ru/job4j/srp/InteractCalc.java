package ru.job4j.srp;

import ru.job4j.srp.input.ConsoleInputData;
import ru.job4j.srp.interfaces.CommonInputData;
import ru.job4j.srp.menu.Menu;

/**
 * Class InteractCalc
 *
 * @author Petr B.
 * @since 28.11.2019, 17:17
 */
public class InteractCalc {
    private final Menu menu;
    private final CommonInputData commonInputData;
    private static final String EXIT = "y";

    public InteractCalc(Menu menuCalculator, CommonInputData inputData) {
        menu = menuCalculator;
        commonInputData = inputData;
    }

    public void init() {
        double prevResult = -1;
        boolean switcher = true;
        int res = -1;
        menu.fillMenuOfOperation();
        menu.showMenu();
        while (switcher) {
            try {
                res = Integer.parseInt(commonInputData.getAnwser("Выберите операцию : "));
            } catch (NumberFormatException nfe) {
                System.out.println("Вы ввели строку, а нужно число!");
                continue;
            }
            prevResult = menu.executeOperation(res, prevResult);
            System.out.println("Результат = " + prevResult);
            String ex = commonInputData.getAnwser("\nExit y/n?: ");
            if (EXIT.equals(ex)) {
                switcher = false;
            }
        }
    }

    public static void main(String[] args) {
        new InteractCalc(new Menu(new ConsoleInputData()), new ConsoleInputData()).init();
    }
}
