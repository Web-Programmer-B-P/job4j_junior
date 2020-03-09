package ru.job4j.io.chat.input;

import ru.job4j.io.chat.interfaces.Phrase;

import java.util.Scanner;

/**
 * Class InputPhrase
 *
 * @author Petr B.
 * @since 30.10.2019, 13:49
 */

/**
 * Class InputPhrase
 *
 * @author Petr B.
 * @since 29.10.2019, 17:15
 */
public class InputPhrase implements Phrase {
    private Scanner in = new Scanner(System.in);

    @Override
    public String inputPhrase(String phrase) {
        System.out.print(phrase);
        return this.in.nextLine();
    }
}
