package ru.job4j.io.zip;

import ru.job4j.io.zip.parse.Args;
import ru.job4j.io.zip.search.Search;

import java.io.*;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Class Main
 *
 * @author Petr B.
 * @since 28.10.2019, 16:33
 */
public class Main {
    private Search search = new Search();

    public void pack(List<File> source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (File file : source) {
                zip.putNextEntry(new ZipEntry(file.getPath()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(file))) {
                    zip.write(out.readAllBytes());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public List<File> seekBy(String root, String ext) {
        return search.file(root, ext);
    }

    public static void main(String[] args) {
        Main zip = new Main();
        Args call = new Args(args);
        zip.pack(zip.seekBy(call.getDirectory(), call.getExclude()), new File(call.getOutput()));
    }
}
