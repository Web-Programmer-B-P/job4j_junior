package ru.job4j.io.config;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Class config
 *
 * @author Petr B.
 * @since 26.10.2019, 11:12
 */
public class Config {
    private final String path;
    private Map<String, String> values = new HashMap<String, String>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        try (BufferedReader read = new BufferedReader(new FileReader(path))) {
            values = read.lines().filter(
                    (n) -> n.length() > 0 && !n.startsWith("#")
            ).collect(
                    Collectors.toMap(
                            (n) -> n.substring(0, n.indexOf("=")),
                            (n) -> n.substring(n.indexOf("=") + 1))
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String value(String key) {
        return values.get(key);
    }
}
