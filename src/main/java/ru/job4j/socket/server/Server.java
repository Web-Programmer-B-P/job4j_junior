package ru.job4j.socket.server;

import ru.job4j.io.chat.reader.Reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * Class Server
 *
 * @author Petr B.
 * @since 31.10.2019, 10:52
 */
public class Server {
    private final Reader randomPhrases;
    private final Socket serverSocket;
    private Map<String, String> bufferAnwsers = new HashMap<>();

    public Server(final Socket socket, final Reader pathFile) {
        randomPhrases = pathFile;
        serverSocket = socket;
    }

    public void startServer() throws IOException {
        bufferAnwsers.put("by", "by");
        bufferAnwsers.put("Hello", "Hello, dear friend, I'm a oracle.");
        PrintWriter out = new PrintWriter(serverSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
        System.out.println("Connection is ready...");
        String ask = null;
        String botAnwser = null;
        do {
            ask = in.readLine();
            System.out.println("Message from client: " + ask);
            botAnwser = bufferAnwsers.getOrDefault(ask,
                    randomPhrases.statusForUseTestMethod() ? randomPhrases.getBotAnwserTest()
                            : randomPhrases.getBotAnwser());
            out.println(botAnwser);
        } while (!ask.equals("by"));
    }

    public static void main(String[] args) {
        System.out.println("Waiting for connection....");
        try (Socket socket = new ServerSocket(4500).accept()) {
            new Server(socket, new Reader("Phrase.txt")).startServer();
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}

