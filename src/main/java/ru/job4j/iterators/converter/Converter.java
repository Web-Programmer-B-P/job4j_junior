package ru.job4j.iterators.converter;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class Converter
 *
 * @author Petr B.
 * @since 02.10.2019, 18:49
 */
public class Converter {
    Iterator<Integer> convert(Iterator<Iterator<Integer>> its) {
        return new Iterator<Integer>() {
            private Iterator<Integer> item = its.next();

            @Override
            public boolean hasNext() {
                while (!this.item.hasNext() && its.hasNext()) {
                    this.item = its.next();
                }
                return this.item.hasNext();
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("It doesn`t have more elements!");
                }
                return this.item.next();
            }
        };
    }
}
