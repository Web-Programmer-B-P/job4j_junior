package ru.job4j.socket.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Class Client
 *
 * @author Petr B.
 * @since 31.10.2019, 10:54
 */
public class Client {
    private final Socket sock;
    private static final String EXIT_PHRASE = "by";
    private static final String CLOSE_CONNECTION = "Connection is closing.....";

    public Client(final Socket socket) {
        sock = socket;
    }

    public void connectWithServer() throws IOException {
        PrintWriter out = new PrintWriter(sock.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
        BufferedReader readerFromConsole = new BufferedReader(new InputStreamReader(System.in));
        String str;
        String consoleString;
        String echo;
        do {
            System.out.print("Enter your message: ");
            consoleString = readerFromConsole.readLine();
            out.println(consoleString);
            out.flush();
            str = in.readLine();
            echo = str.equals(EXIT_PHRASE) ? CLOSE_CONNECTION : str;
            System.out.println("\t" + echo);
        } while (!str.equals(EXIT_PHRASE));
    }

    public static void main(String[] args) {
        try (Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 4500)) {
            new Client(socket).connectWithServer();
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}
