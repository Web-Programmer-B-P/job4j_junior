package ru.job4j.io.chat;

import org.junit.Test;
import ru.job4j.io.chat.input.InputImitation;
import ru.job4j.io.chat.reader.Reader;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.function.Consumer;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class StartChatTest
 *
 * @author Petr B.
 * @since 30.10.2019, 13:49
 */
public class StartChatTest {
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final Consumer<String> output = new Consumer<String>() {
        private final PrintStream stdout = new PrintStream(out);

        @Override
        public void accept(String s) {
            stdout.println(s);
        }

        @Override
        public String toString() {
            return out.toString();
        }
    };

    @Test
    public void whenTolkWithBot() {
        new StartChat(new InputImitation(Arrays.asList(
                "Привет", "стоп", "Я продолжаю, а ты молчишь", "продолжить", "закончить")
        ), new Reader(Arrays.asList(
                "Здарова", "Как так", "Почему меня заткнули", "Мне снова дали слово, спасибо!")
        ), output).init();
        assertThat(output.toString(),
                is(new StringBuffer()
                        .append("Здарова\n")
                        .append("Мне снова дали слово, спасибо!")
                        .append(System.lineSeparator()).toString())
        );
    }

    @Test
    public void whenReturCountPhrases() {
        Reader phrases = new Reader("Phrase.txt");
        int result = phrases.getPhrasesFromFile().size();
        assertThat(result, is(28));
    }

    @Test
    public void whenReturAllFakePhrases() {
        Reader phrases = new Reader(Arrays.asList("Привет!", "Давайте начнем", "Все поговорили"));
        int result = phrases.getPhrasesForTest().size();
        assertThat(result, is(3));
    }
}