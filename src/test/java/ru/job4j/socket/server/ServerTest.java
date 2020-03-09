package ru.job4j.socket.server;

import org.junit.Test;
import ru.job4j.io.chat.reader.Reader;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Class ServerTest
 *
 * @author Petr B.
 * @since 31.10.2019, 23:26
 */
public class ServerTest {
    @Test
    public void whenTestExit() throws IOException {
        test(
                String.format("by%n"),
                String.format("by%n")
        );
    }

    @Test
    public void whenOracleAnwserForHello() throws IOException {
        test(
                String.format("Hello%nby%n"),
                String.format("Hello, dear friend, I'm a oracle.%nby%n")
        );
    }

    @Test
    public void whenAskOracleSamethingWrong() throws IOException {
        test(
                String.format("yahhh%nby"),
                String.format("I don`t known anwser%nby%n")
        );
    }

    private void test(String input, String expected) throws IOException {
        Socket sock = mock(Socket.class);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        when(sock.getInputStream()).thenReturn(in);
        when(sock.getOutputStream()).thenReturn(out);
        new Server(sock, new Reader(Arrays.asList("I don`t known anwser", "Yes"))).startServer();
        assertThat(out.toString(), is(expected));
    }
}