package ru.job4j.io.chat;

import ru.job4j.io.chat.input.InputPhrase;
import ru.job4j.io.chat.interfaces.Phrase;
import ru.job4j.io.chat.reader.Reader;

import java.util.function.Consumer;

/**
 * Class StartChat
 *
 * @author Petr B.
 * @since 30.10.2019, 13:49
 */

/**
 * Class StartChat
 *
 * @author Petr B.
 * @since 29.10.2019, 16:17
 */
public class StartChat {
    private final Phrase inputPh;
    private final Reader read;
    private final Consumer<String> output;
    private static final String EXIT_PHRASE = "закончить";
    private static final String BREAK = "стоп";
    private static final String CONTINUE = "продолжить";
    private boolean switcher = true;

    public StartChat(Phrase startConsole, Reader reader, Consumer<String> out) {
        inputPh = startConsole;
        read = reader;
        output = out;
    }

    public void init() {
        boolean stopLoop = true;
        do {
            String botPhrase = read.statusForUseTestMethod() ? read.getBotAnwserTest() : read.getBotAnwser();
            String anwser = inputPh.inputPhrase("Введите фразу: ");
            switch (anwser) {
                case EXIT_PHRASE:
                    stopLoop = false;
                    break;
                case BREAK:
                    switcher = false;
                    break;
                case CONTINUE:
                    switcher = true;
                    output.accept(botPhrase);
                    break;
                default:
                    if (switcher) {
                        output.accept(botPhrase);
                    }
                    break;
            }
        } while (stopLoop);
    }

    public static void main(String[] args) {
        new StartChat(new InputPhrase(), new Reader("Phrase.txt"), System.out::println).init();
    }
}
