package ru.job4j.io.chat.input;

import ru.job4j.io.chat.interfaces.Phrase;

import java.util.Iterator;
import java.util.List;

/**
 * Class InputImitation
 *
 * @author Petr B.
 * @since 30.10.2019, 13:49
 */

/**
 * Class InputImitation
 *
 * This one we need for test fake work bot
 * @author Petr B.
 * @since 29.10.2019, 22:32
 */
public class InputImitation implements Phrase {
    private final List<String> list;
    private final Iterator<String> itr;

    public InputImitation(List<String> phrase) {
        list = phrase;
        itr = list.iterator();
    }

    @Override
    public String inputPhrase(String phrase) {
        return itr.next();
    }
}
