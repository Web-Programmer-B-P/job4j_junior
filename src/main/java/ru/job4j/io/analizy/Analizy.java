package ru.job4j.io.analizy;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class Analizy
 *
 * @author Petr B.
 * @since 26.10.2019, 17:32
 */
public class Analizy {
    private List<String> data = new ArrayList<>();

    public void unavailable(String source, String target) {
        try (BufferedReader read = new BufferedReader(new FileReader(source))) {
            data = read.lines().collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<String> log = sortLog(data);
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(target))) {
            for (String line : log) {
                writer.println(line);
            }
        } catch (FileNotFoundException fnf) {
            fnf.printStackTrace();
        }
    }

    private List<String> sortLog(List<String> file) {
        List<String> result = new ArrayList<>();
        String buffer = "";
        for (String line : file) {
            if (buffer.isEmpty() && (line.charAt(0) == '5' || line.charAt(0) == '4')) {
                buffer += line.substring(4);
            } else if (!buffer.isEmpty() && (line.charAt(0) != '5' || line.charAt(0) != '4')) {
                result.add(buffer + " to " + line.substring(4));
                buffer = "";
            }
        }
        return result;
    }

    public String getLog() throws IOException {
        List<String> result = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("server.log"))) {
            result = reader.lines().collect(Collectors.toList());
        } catch (FileNotFoundException fnf) {
            fnf.getStackTrace();
        }
        return result.toString();
    }
}
