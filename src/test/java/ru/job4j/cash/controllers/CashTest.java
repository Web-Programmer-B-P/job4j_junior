package ru.job4j.cash.controllers;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class CashTest
 *
 * @author Petr B.
 * @since 18.12.2019, 12:04
 */
public class CashTest {
    private ByteArrayOutputStream out = new ByteArrayOutputStream();
    private PrintStream stdout = System.out;

    @Before
    public void loadOut() {
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void loadOutBack() {
        System.setOut(this.stdout);
    }

    @Test
    public void whenCashIsEmpty() {
        Cash cash = new Cash("file.txt");
        cash.showTextFromFile();
        assertThat(out.toString(), is("Загрузил в кеш\n"));
    }

    @Test
    public void whenGetFromCash() {
        Cash cash = new Cash("file.txt");
        cash.showTextFromFile();
        out.reset();
        cash.showTextFromFile();
        assertThat(out.toString(), is("Взял из кеша\n"));
    }

    @Test
    public void whenGetTextFromFile() {
        Cash cash = new Cash("file.txt");
        assertThat(cash.showTextFromFile(), is("Hello world!\nПривет мир!\n"));
    }

    @Test(expected = NullPointerException.class)
    public void whenInputWrongNameOfFile() {
        Cash cash = new Cash("wrong.txt");
        assertThat(cash.showTextFromFile(), is("Загрузил в кеш\n"));
    }
}