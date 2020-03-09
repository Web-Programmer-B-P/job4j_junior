package ru.job4j.ocp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.ocp.menu.MenuEngineeringCalc;
import ru.job4j.srp.input.FakeInputData;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class EngineeringCalcTest
 *
 * @author Petr B.
 * @since 01.12.2019, 18:35
 */
public class EngineeringCalcTest {
    private final ByteArrayOutputStream bufferOutputContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final static String MENU =
            "0 - Операция сложение\n"
                    + "1 - Операция вычитание\n"
                    + "2 - Операция умножение\n"
                    + "3 - Операция деление\n"
                    + "4 - Операция вычисления косинуса\n"
                    + "5 - Операция вычисления синуса\n";

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(bufferOutputContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void whenCos() {
        ArrayList<String> dataForMenu = new ArrayList<>(Arrays.asList("4", "y"));
        ArrayList<String> dataForOperation = new ArrayList<>(Arrays.asList("45"));
        EngineeringCalc calc = new EngineeringCalc(new MenuEngineeringCalc(new FakeInputData(dataForOperation)),
                new FakeInputData(dataForMenu)
        );
        calc.init();
        assertThat(bufferOutputContent.toString(),
                is(new StringBuffer()
                        .append(MENU)
                        .append("Выберите операцию :  4\n")
                        .append("Операция вычисления косинуса\n")
                        .append("Введите число:  45\n")
                        .append("Результат = 0.5253219888177297\n\n")
                        .append("Exit y/n?:  y")
                        .append(System.lineSeparator()).toString()

                )
        );
    }

    @Test
    public void whenSin() {
        ArrayList<String> dataForMenu = new ArrayList<>(Arrays.asList("5", "y"));
        ArrayList<String> dataForOperation = new ArrayList<>(Arrays.asList("45"));
        EngineeringCalc calc = new EngineeringCalc(new MenuEngineeringCalc(new FakeInputData(dataForOperation)),
                new FakeInputData(dataForMenu)
        );
        calc.init();
        assertThat(bufferOutputContent.toString(),
                is(new StringBuffer()
                        .append(MENU)
                        .append("Выберите операцию :  5\n")
                        .append("Операция вычисления синуса\n")
                        .append("Введите число:  45\n")
                        .append("Результат = 0.8509035245341184\n\n")
                        .append("Exit y/n?:  y")
                        .append(System.lineSeparator()).toString()

                )
        );
    }
}