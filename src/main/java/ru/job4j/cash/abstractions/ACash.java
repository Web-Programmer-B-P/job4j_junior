package ru.job4j.cash.abstractions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

/**
 * Class ACash
 *
 * @author Petr B.
 * @since 17.12.2019, 16:56
 */
abstract public class ACash {
    protected Map<String, SoftReference<String>> references;
    private static final Logger LOG = LogManager.getLogger(ACash.class.getName());

    public ACash() {
        references = new HashMap<>();
    }

    private String getPath(String fileName) {
        File file = null;
        try {
            file = new File(this.getClass().getResource("/" + fileName).getFile());
        } catch (NullPointerException ne) {
            LOG.trace("Проверте имя файла, такой файл не найден!");
        }
        return file.getAbsolutePath();
    }

    protected String readFile(String key) {
        String res = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(getPath(key)));
            String line;
            while ((line = reader.readLine()) != null) {
                res += line + System.lineSeparator();
            }
        } catch (IOException io) {
            LOG.trace(io.getMessage());
        }
        return res;
    }

    protected abstract String showTextFromFile();
}
