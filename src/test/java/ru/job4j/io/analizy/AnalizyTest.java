package ru.job4j.io.analizy;

import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class AnalizyTest
 *
 * @author Petr B.
 * @since 26.10.2019, 19:42
 */
public class AnalizyTest {
    @Test
    public void whenCheckLog() throws IOException {
        Analizy call = new Analizy();
        call.unavailable("unavailable.csv", "server.log");
        assertThat(call.getLog(), is("[22:05:11 to 23:34:16, 00:55:02 to 01:49:08]"));
    }
}