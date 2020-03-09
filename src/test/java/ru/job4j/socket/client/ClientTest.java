package ru.job4j.socket.client;

import com.google.common.base.Joiner;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.Socket;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Class ClientTest
 *
 * @author Petr B.
 * @since 01.11.2019, 13:30
 */
public class ClientTest {
    private static final String LS = System.clearProperty("line.separator");

    @Test
    public void whenTestExit() throws IOException {
        testClient(
                Joiner.on(LS).join("Hello", "by"),
                Joiner.on(LS).join("Hello, dear friend, I'm a oracle.", "by"),
                Joiner.on(LS).join("Hello", "by", "")
        );

    }

    private void testClient(String messageForServer, String responceOracle, String expected) throws IOException {
        Socket client = mock(Socket.class);
        ByteArrayInputStream consoleInputStream = new ByteArrayInputStream(messageForServer.getBytes());
        System.setIn(consoleInputStream);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(responceOracle.getBytes());
        when(client.getInputStream()).thenReturn(in);
        when(client.getOutputStream()).thenReturn(out);
        new Client(client).connectWithServer();
        assertThat(out.toString(), is(expected));
    }
}