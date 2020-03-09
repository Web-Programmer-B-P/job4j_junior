package ru.job4j.cash.controllers;

import ru.job4j.cash.abstractions.ACash;

import java.lang.ref.SoftReference;

/**
 * Class Cash
 *
 * @author Petr B.
 * @since 17.12.2019, 16:58
 */
public class Cash extends ACash {
    private String fileName;

    public Cash(String fileName) {
        this.fileName = fileName;
    }

    @Override
    protected String showTextFromFile() {
        String show = "";
        if (references.containsKey(fileName)) {
            System.out.println("Взял из кеша");
            show = references.get(fileName).get();
        } else {
            String text = readFile(fileName);
            if (text != null) {
                references.put(fileName, new SoftReference<String>(text));
                System.out.println("Загрузил в кеш");
                show = references.get(fileName).get();
            }
        }
        return show;
    }
}
