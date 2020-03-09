package ru.job4j.map;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class HashMap
 *
 * @author Petr B.
 * @since 15.10.2019, 9:59
 */
public class HashMap<K, V> implements Iterable<V> {
    private static final int SIZE_MIN = 8;
    private int currentSize = SIZE_MIN;
    private int numberOfElements;
    private Node<K, V>[] store = new Node[currentSize];

    public boolean insert(K key, V value) {
        boolean result = false;
        if (numberOfElements == currentSize - 1) {
            resize();
        }
        if (!contain(key)) {
            store[getIndex(key)] = new Node<>(key, value);
            numberOfElements++;
            result = true;
        }
        return result;
    }

    public V get(K key) {
        V result = null;
        if (contain(key)) {
            result = store[getIndex(key)].value;
        }
        return result;
    }

    public boolean delete(K key) {
        boolean result = false;
        if (contain(key)) {
            store[getIndex(key)] = null;
            numberOfElements--;
            result = true;
        }
        return result;
    }

    private int getIndex(K key) {
        return (store.length - 1) & key.hashCode();
    }

    private void resize() {
        currentSize = SIZE_MIN << 1;
        Node<K, V>[] resizeTable = new Node[currentSize];
        Node<K, V>[] oldValue = store;
        store = resizeTable;
        numberOfElements = 0;
        for (int i = 0; i < oldValue.length; i++) {
            if (oldValue[i] != null) {
                if (!contain(oldValue[i].key)) {
                    store[getIndex(oldValue[i].key)] = new Node<>(oldValue[i].key, oldValue[i].value);
                    numberOfElements++;
                }
            }
        }
    }

    private boolean contain(K key) {
        boolean result = false;
        int index = getIndex(key);
        if (compareKeys(key) != -1 && index == compareKeys(key)) {
            result = true;
        }
        return result;
    }

    private int compareKeys(K k) {
        int i = getIndex(k);
        int compare = -1;
        if (store[i] != null) {
            compare = getIndex(store[i].key);
        }
        return compare;
    }

    public int getNumberOfElements() {
        return numberOfElements;
    }

    @Override
    public Iterator<V> iterator() {
        return new Iterator<V>() {
            private int index;
            @Override
            public boolean hasNext() {
                boolean result = false;
                if (index < numberOfElements) {
                    result = true;
                }
                return result;
            }

            @Override
            public V next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                V result = null;
                for (int i = index; i < store.length; i++) {
                    if (store[i] != null) {
                        result = store[i].value;
                        index++;
                        break;
                    }
                }
                return result;
            }
        };
    }

    private class Node<K, V> {
        private K key;
        private V value;

        public Node(K k, V v) {
            key = k;
            value = v;
        }
    }
}
