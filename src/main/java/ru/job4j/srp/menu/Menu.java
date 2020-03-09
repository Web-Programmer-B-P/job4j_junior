package ru.job4j.srp.menu;

import ru.job4j.srp.event.EventHandler;
import ru.job4j.srp.interfaces.CommonInputData;
import ru.job4j.srp.interfaces.CommonOperation;
import ru.job4j.srp.operations.*;
import java.util.ArrayList;

/**
 * Class Menu
 *
 * @author Petr B.
 * @since 30.11.2019, 16:13
 */
public class Menu {
    protected ArrayList<CommonOperation> listOfOperations = new ArrayList<>();
    private final CommonInputData inputData;
    protected int indexOfOperation;

    public Menu(CommonInputData commonInputData) {
        inputData = commonInputData;
    }

    public void fillMenuOfOperation() {
        listOfOperations.add(new Add("Операция сложение", indexOfOperation++));
        listOfOperations.add(new SubTrack("Операция вычитание", indexOfOperation++));
        listOfOperations.add(new Multiply("Операция умножение", indexOfOperation++));
        listOfOperations.add(new Div("Операция деление", indexOfOperation++));
    }

    public void showMenu() {
        for (CommonOperation oneLineOfMenu : listOfOperations) {
            System.out.print(oneLineOfMenu.getInfoOfOperation());
        }
    }

    public double executeOperation(int key, double prevResult) {
        return listOfOperations.get(key).doOperation(new EventHandler(inputData, prevResult));
    }
}
