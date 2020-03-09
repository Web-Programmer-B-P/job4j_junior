package ru.job4j.io.criteria;

import ru.job4j.io.criteria.model.Args;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Class Find
 *
 * @author Petr B.
 * @since 04.11.2019, 9:29
 */
public class Start {
    private Args param;
    private List<String> res = new ArrayList<>();
    private static final String LS = System.lineSeparator();
    private String pathTargetFile;

    public Start(Args p) {
        param = p;
    }

    public void file() throws IOException {
        Queue<File> data = new LinkedList<>();
        data.offer(new File(param.getDirectory()));
        while (!data.isEmpty()) {
            File newPath = data.poll();
            if (newPath.isDirectory()) {
                for (String el : newPath.list()) {
                    File concat = new File(newPath + "/" + el);
                    data.offer(concat);
                }
            }
            if (newPath.isFile()) {
                searchByCriterian(newPath);
            }
        }
        writeDataToTargetFile(res, pathTargetFile);
    }

    /**
     * This one search file by criteria for example: serch by regex or by mask or by full name.
     * @param file
     */
    private void searchByCriterian(File file) {
        String name = param.getName();
        String keySearch = param.getMask();
        String ext = findExt(file);
        pathTargetFile = param.getDirectory() + "/" + param.getTargetPath();
        if (keySearch.equals("-m") && ext.equals(name.substring(2))) {
            res.add(file.getName());
        }
        if (keySearch.equals("-f") && file.getName().equals(name)) {
            res.add(file.getName());
        }
        if (keySearch.equals("-r")) {
            if (searchByRegex(name, file.getName())) {
                res.add(file.getName());
            }
        }
    }

    private boolean searchByRegex(String regex, String name) {
        boolean result = false;
        Pattern pattern = Pattern.compile(regex);
        Matcher match = pattern.matcher(name);
        if (match.matches()) {
            result = true;
        }
        return result;
    }

    /**
     * Method write find data in target file
     *
     * @param fileName    data to be written
     * @param pathToWrite target file to be write data
     * @throws IOException
     */
    private void writeDataToTargetFile(List<String> fileName, String pathToWrite) throws IOException {
        FileOutputStream f = new FileOutputStream(pathToWrite, true);
        for (String el : fileName) {
            f.write((el + LS).getBytes());
        }
        f.close();
    }

    /**
     * Method read data from target file and return
     *
     * @return Set collection of data
     * @throws FileNotFoundException
     */
    public Set getDataTargetFile() throws FileNotFoundException {
        Set<String> res = new HashSet<>();
        BufferedReader read = new BufferedReader(new FileReader(pathTargetFile));
        res = read.lines().collect(Collectors.toSet());
        return res;
    }

    /**
     * Method find extension file and retur without character "."
     *
     * @param file
     * @return extension
     */
    private String findExt(File file) {
        String ext = file.getName();
        return ext.substring(ext.indexOf(".") + 1);
    }

    public static void main(String[] args) throws IOException {
        List<String> stream = Arrays.asList(args);
        List<String> res = stream.stream().filter(el->el.matches("([-dnmfro]+)")).collect(Collectors.toList());

        if (args.length == 7 && res.size() == 4) {
            new Start(new Args(args[1], args[3], args[4], args[6])).file();
        } else {
            System.err.println("The pattern of command must be:"
                    + "\n -d directory path example: /home/projects/job4j where you find"
                    + "\n -n name of file or extends of files example: file.txt or *.txt"
                    + "\n -m/-f/-r you must choose one of these type of search"
                    + "\n -o place to save example: log.txt"
            );
        }
    }
}
