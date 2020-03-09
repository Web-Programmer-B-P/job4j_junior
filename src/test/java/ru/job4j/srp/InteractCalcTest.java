package ru.job4j.srp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.srp.input.FakeInputData;
import ru.job4j.srp.menu.Menu;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class InteractCalcTest
 *
 * @author Petr B.
 * @since 01.12.2019, 11:44
 */
public class InteractCalcTest {
    private final ByteArrayOutputStream bufferOutputContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final static String MENU =
                    "0 - Операция сложение\n"
                    + "1 - Операция вычитание\n"
                    + "2 - Операция умножение\n"
                    + "3 - Операция деление\n";

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(bufferOutputContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void whenAdd() {
        ArrayList<String> dataForMenu = new ArrayList<>(Arrays.asList("0", "y"));
        ArrayList<String> dataForOperation = new ArrayList<>(Arrays.asList("10", "10"));
        InteractCalc calc = new InteractCalc(new Menu(new FakeInputData(dataForOperation)), new FakeInputData(dataForMenu));
        calc.init();
        assertThat(bufferOutputContent.toString(),
                is(new StringBuffer()
                        .append(MENU)
                        .append("Выберите операцию :  0\n")
                        .append("Операция сложение\n")
                        .append("Введите число:  10\n")
                        .append("Введите число:  10\n")
                        .append("Результат = 20.0\n\n")
                        .append("Exit y/n?:  y")
                        .append(System.lineSeparator()).toString()

                )
        );
    }

    @Test
    public void whenSubtrack() {
        ArrayList<String> dataForMenu = new ArrayList<>(Arrays.asList("1", "y"));
        ArrayList<String> dataForOperation = new ArrayList<>(Arrays.asList("10", "5"));
        InteractCalc calc = new InteractCalc(new Menu(new FakeInputData(dataForOperation)), new FakeInputData(dataForMenu));
        calc.init();
        assertThat(bufferOutputContent.toString(),
                is(new StringBuffer()
                        .append(MENU)
                        .append("Выберите операцию :  1\n")
                        .append("Операция вычитание\n")
                        .append("Введите число:  10\n")
                        .append("Введите число:  5\n")
                        .append("Результат = 5.0\n\n")
                        .append("Exit y/n?:  y")
                        .append(System.lineSeparator()).toString()

                )
        );
    }

    @Test
    public void whenMultiply() {
        ArrayList<String> dataForMenu = new ArrayList<>(Arrays.asList("2", "y"));
        ArrayList<String> dataForOperation = new ArrayList<>(Arrays.asList("10", "5"));
        InteractCalc calc = new InteractCalc(new Menu(new FakeInputData(dataForOperation)), new FakeInputData(dataForMenu));
        calc.init();
        assertThat(bufferOutputContent.toString(),
                is(new StringBuffer()
                        .append(MENU)
                        .append("Выберите операцию :  2\n")
                        .append("Операция умножение\n")
                        .append("Введите число:  10\n")
                        .append("Введите число:  5\n")
                        .append("Результат = 50.0\n\n")
                        .append("Exit y/n?:  y")
                        .append(System.lineSeparator()).toString()

                )
        );
    }

    @Test
    public void whenDiv() {
        ArrayList<String> dataForMenu = new ArrayList<>(Arrays.asList("3", "y"));
        ArrayList<String> dataForOperation = new ArrayList<>(Arrays.asList("10", "5"));
        InteractCalc calc = new InteractCalc(new Menu(new FakeInputData(dataForOperation)), new FakeInputData(dataForMenu));
        calc.init();
        assertThat(bufferOutputContent.toString(),
                is(new StringBuffer()
                        .append(MENU)
                        .append("Выберите операцию :  3\n")
                        .append("Операция деление\n")
                        .append("Введите число:  10\n")
                        .append("Введите число:  5\n")
                        .append("Результат = 2.0\n\n")
                        .append("Exit y/n?:  y")
                        .append(System.lineSeparator()).toString()

                )
        );
    }

    @Test
    public void whenDoAddThanDiv() {
        ArrayList<String> dataForMenu = new ArrayList<>(Arrays.asList("0", "n", "3", "y"));
        ArrayList<String> dataForOperation = new ArrayList<>(Arrays.asList("10", "5", "д", "н", "3"));
        InteractCalc calc = new InteractCalc(new Menu(new FakeInputData(dataForOperation)), new FakeInputData(dataForMenu));
        calc.init();
        assertThat(bufferOutputContent.toString(),
                is(new StringBuffer()
                        .append(MENU)
                        .append("Выберите операцию :  0\n")
                        .append("Операция сложение\n")
                        .append("Введите число:  10\n")
                        .append("Введите число:  5\n")
                        .append("Результат = 15.0\n\n")
                        .append("Exit y/n?:  n\n")
                        .append("Выберите операцию :  3\n")
                        .append("Операция деление\n")
                        .append("Вы хотите использовать предыдущий результат д/н? д\n")
                        .append("Вы хотите использовать предыдущий результат д/н? н\n")
                        .append("Введите число:  3\n")
                        .append("Результат = 5.0\n\n")
                        .append("Exit y/n?:  y")
                        .append(System.lineSeparator()).toString()
                )
        );
    }
}