package ru.job4j.io.zip.search;

import java.io.File;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class Search
 *
 * @author Petr B.
 * @since 29.10.2019, 8:55
 */
public class Search {
    public List<File> file(String pathSearch, String exts) {
        LinkedHashSet<File> res = new LinkedHashSet<>();
        Queue<File> data = new LinkedList<>();
        data.offer(new File(pathSearch));
        while (!data.isEmpty()) {
            File newPath = data.poll();
            if (newPath.isDirectory()) {
                for (String el : newPath.list()) {
                    File concat = new File(newPath + "/" + el);
                    data.offer(concat);
                }
            }
            if (newPath.isFile()) {
                String nameFile = newPath.getName();
                Pattern patternDir = Pattern.compile(exts);
                Matcher off = patternDir.matcher(nameFile);
                if (!off.find()) {
                    res.add(new File(newPath.getPath()));
                }
            }
        }
        List<File> list = new ArrayList<>(res);
        return list;
    }
}
