package ru.job4j.iterators.doublearray;


import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class JaggedArrayIterator
 *
 * @author Petr B.
 * @since 02.10.2019, 10:37
 */

/**
 * Class IteratorArray
 *
 * @author Petr B.
 * @since 01.10.2019, 9:42
 */
public class JaggedArrayIterator implements Iterator {
    private final int[][] array;
    private int outer;
    private int inner;
    private int count;
    private int size;

    public JaggedArrayIterator(final int[][] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        boolean result = false;
        if (this.array.length > this.outer + 1 || this.inner < this.count) {
            result = true;
        }
        return result;
    }

    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException("Sorry, you can`t use this method with empty array!");
        } else if (this.outer >= this.size && this.outer <= this.array.length - 1) {
            this.count = 0;
            for (int value : this.array[this.outer]) {
                this.count++;
            }
        }

        if (this.inner < this.count) {
            this.size++;
        } else {
            this.size = this.outer;
            this.inner = 0;
            this.outer++;
        }
        return this.array[this.outer][this.inner++];
    }
}
