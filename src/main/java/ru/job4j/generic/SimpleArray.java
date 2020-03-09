package ru.job4j.generic;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class SimpleArray
 *
 * @author Petr B.
 * @since 05.10.2019, 15:41
 */
public class SimpleArray<T> implements Iterable<T> {
    private T[] data;
    private int position = 0;

    public SimpleArray(int size) {
        this.data = (T[]) new Object[size];
    }

    public void add(T model) {
        if (this.position == this.data.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        this.data[this.position++] = model;
    }

    public void set(int index, T model) {
        if (index < this.position) {
            this.data[index] = model;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public void remove(int index) {
        T[] arr = (T[]) new Object[this.data.length];
        if (index < this.data.length) {
            for (int i = 0; i < this.data.length; i++) {
                if (i == index) {
                    this.data[i] = null;
                }
            }

            for (int o = 0, i = 0; o < this.data.length; o++) {
                if (this.data[o] != null) {
                    arr[i] = this.data[o];
                    i++;
                }
            }
            this.data = Arrays.copyOf(arr, this.data.length);
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public T get(int index) {
        return this.data[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                boolean result = false;
                if (this.index < position && data[this.index] != null) {
                    result = true;
                }
                return result;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return data[this.index++];
            }
        };
    }
}
