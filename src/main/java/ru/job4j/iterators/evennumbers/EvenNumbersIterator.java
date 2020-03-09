package ru.job4j.iterators.evennumbers;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class EvenIterator
 *
 * @author Petr B.
 * @since 02.10.2019, 10:42
 */
public class EvenNumbersIterator implements Iterator {
    private final int[] array;
    private int next;

    public EvenNumbersIterator(final int[] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        int has = this.next;
        boolean result = false;
        while (this.array.length > has) {
            if (this.array[has] % 2 == 0) {
                result = true;
                this.next = has;
                break;
            } else {
                has++;
            }
        }
        return result;
    }

    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException("Doesn`t have next element!");
        }
        return this.array[this.next++];
    }
}
