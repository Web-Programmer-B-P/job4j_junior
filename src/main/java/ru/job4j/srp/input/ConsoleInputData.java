package ru.job4j.srp.input;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.job4j.srp.interfaces.CommonInputData;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Class ConsoleInputData
 *
 * @author Petr B.
 * @since 30.11.2019, 16:20
 */
public class ConsoleInputData implements CommonInputData {
    private static final Logger LOG = LogManager.getLogger(ConsoleInputData.class.getName());
    private final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public String getAnwser(String anwser) {
        String res = null;
        System.out.print(anwser);
        try {
            res = in.readLine();
        } catch (IOException io) {
            LOG.trace(io.getMessage());
        }
        return res;
    }
}
