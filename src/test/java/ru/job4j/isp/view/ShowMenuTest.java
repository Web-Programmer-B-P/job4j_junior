package ru.job4j.isp.view;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.isp.actions.MenuAction;
import ru.job4j.isp.interfaces.DrawMenu;
import ru.job4j.isp.model.Menu;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class ShowMenuTest
 *
 * @author Petr B.
 * @since 06.12.2019, 15:04
 */
public class ShowMenuTest {
    private final ByteArrayOutputStream bufferOutputContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private DrawMenu mainMenu;
    private ShowMenu action;
    private Map<String, Menu> menu = new LinkedHashMap<>();

    @Before
    public void setUp() throws Exception {
        System.setOut(new PrintStream(bufferOutputContent));
        ArrayList<Menu> children2 = new ArrayList<>(Arrays.asList(new Menu("Задача 1.1.1.1"), new Menu("Задача 1.1.1.2")));
        ArrayList<Menu> children1 = new ArrayList<>(Arrays.asList(new Menu("Задача 1.1.1", children2), new Menu("Задача 1.1.2")));
        ArrayList<Menu> list = new ArrayList<>(Arrays.asList(new Menu("Задача 1.1", children1), new Menu("Задача 1.2")));
        action = new ShowMenu(new Menu("Задача 1.", list));
        mainMenu = action;
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void whenShowTreeOfMenu() {
        mainMenu.showMenu();
        String expected = "Задача 1.\n--Задача 1.1\n----Задача 1.1.1\n"
                + "------Задача 1.1.1.1\n------Задача 1.1.1.2\n----Задача 1.1.2\n--Задача 1.2\n";
        assertThat(bufferOutputContent.toString(),
                is(expected)
        );
    }

    @Test
    public void whenDoActionTrue() {
        MenuAction of = new MenuAction(action);
        assertThat(of.action("Задача 1.1.1.1"), is(true));
    }
}