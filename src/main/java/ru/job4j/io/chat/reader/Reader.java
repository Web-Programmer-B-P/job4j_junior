package ru.job4j.io.chat.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Class Reader
 *
 * @author Petr B.
 * @since 30.10.2019, 13:49
 */

/**
 * Class Reader
 *
 * @author Petr B.
 * @since 29.10.2019, 18:46
 */
public class Reader {
    private String path;
    private List<String> phrasesForTest;
    private List<String> phrasesFromFile;
    private Iterator<String> itr;

    /**
     * Constructor for real work with console
     * @param pathFile
     */
    public Reader(String pathFile) {
        path = pathFile;
        getBotPhrase();
    }

    /**
     * Constructor for fake simulation, you can use it for test
     * @param listPhrases this list of phrases for bot.
     */
    public Reader(List<String> listPhrases) {
        phrasesForTest = listPhrases;
        itr = phrasesForTest.iterator();
    }

    /**
     * This one read all phrases from special file and addAll its to list phrasesFromFile
     */
    private void getBotPhrase() {
        try (BufferedReader read = new BufferedReader(new FileReader(path))) {
            phrasesFromFile = read.lines().collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method generate random phrase
     * @return random phrase from special file
     */
    public String getBotAnwser() {
        Random rand = new Random();
        return phrasesFromFile.get(rand.nextInt(phrasesFromFile.size()));
    }

    /**
     * This method get phrase for test bot
     * @return next phrase from list
     */
    public String getBotAnwserTest() {
        String res = "";
        if (itr.hasNext()) {
            res = itr.next();
        }
        return res;
    }

    /**
     * This method get status true if list for test bot is full or false if it`s empty
     * @return true/false
     */
    public boolean statusForUseTestMethod() {
        return phrasesForTest != null;
    }

    public List<String> getPhrasesFromFile() {
        return phrasesFromFile;
    }

    public List<String> getPhrasesForTest() {
        return phrasesForTest;
    }
}
