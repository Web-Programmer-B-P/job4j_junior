package ru.job4j.io.search;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class SearchTest
 *
 *                                      Tree root directory
 *                                              root
 *                                               |
 *                                |--------------|--------------|
 *                              dir1                           dir3
 *                            first.txt                         |
 *                            kilo.xml                         red
 *                                                          name.txt
 *                            ======================================
 *                            total: 2 txt, 1 xml
 *
 * @author Petr B.
 * @since 27.10.2019, 15:25
 */
public class SearchTest {
    private File rootPath;
    private List<File> files;
    private List<String> ext = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        File tmp = new File(System.getProperty("java.io.tmpdir"));
        rootPath = new File(tmp, "root");
        File rootDir1 = new File(rootPath, "/dir1");
        File rootDir3Red = new File(rootPath, "/dir3/red");
        rootPath.mkdir();
        rootDir1.mkdirs();
        rootDir3Red.mkdirs();
        new FileOutputStream(rootDir1.getPath() + "/first.txt");
        new FileOutputStream(rootDir1.getPath() + "/kilo.xml");
        new FileOutputStream(rootDir3Red.getPath() + "/name.txt");
        ext.add("txt");
        ext.add("xml");
    }

    @Test
    public void whenWolkInTree() throws IOException {
        Search call = new Search();
        assertThat(
                call.file(rootPath.getPath(), ext).size(),
                is(3)
        );
    }

    @Test
    public void whenShowFile() throws IOException {
        Search call = new Search();
        assertThat(
                call.file(
                        rootPath.getPath(), ext).get(2).getName(),
                is("name.txt")
        );
    }
}