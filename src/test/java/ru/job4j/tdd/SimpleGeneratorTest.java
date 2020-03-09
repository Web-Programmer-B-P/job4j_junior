package ru.job4j.tdd;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.tdd.exception.WrongException;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class SimpleGeneratorTest
 *
 * @author Petr B.
 * @since 08.12.2019, 19:22
 */
public class SimpleGeneratorTest {
    private Pattern pattern;

    @Before
    public void setUp() throws Exception {
        pattern = Pattern.compile("\\$(.*?)}");
    }

    @Test
    public void whenPutTwoPhraseAndGetCorrectResult() {
        Map<String, String> values = new HashMap<>();
        values.put("name", "Petr");
        values.put("subject", "you");
        SimpleGenerator call = new SimpleGenerator(pattern);
        String result = call.generate("I am a ${name}, Who are ${subject}?", values);
        String expected = "I am a Petr, Who are you?";
        assertThat(result, is(expected));
    }

    @Test
    public void whenPutOnePhraseAndGetCorrectResult() {
        Map<String, String> values = new HashMap<>();
        values.put("sos", "Aaa");
        SimpleGenerator call = new SimpleGenerator(pattern);
        String result = call.generate("Help, ${sos}, ${sos}, ${sos}", values);
        String expected = "Help, Aaa, Aaa, Aaa";
        assertThat(result, is(expected));
    }

    @Test(expected = WrongException.class)
    public void whenPutInputStringWithWrongAndGetAnException() {
        Map<String, String> values = new HashMap<>();
        values.put("sos", "Aaa");
        SimpleGenerator call = new SimpleGenerator(pattern);
        String result = call.generate("Help, ${sos}, ${sos}, ${Sos}", values);
        String expected = "Help, Aaa, Aaa, Aaa";
        assertThat(result, is(expected));
    }
}