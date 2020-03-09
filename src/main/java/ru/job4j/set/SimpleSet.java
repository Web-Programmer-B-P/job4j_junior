package ru.job4j.set;

import ru.job4j.list.dynamic.DynamicArrayContainer;

import java.util.Iterator;

/**
 * Class SimpleSet
 *
 * @author Petr B.
 * @since 12.10.2019, 14:36
 */
public class SimpleSet<T> implements Iterable<T> {
    private DynamicArrayContainer<T> store = new DynamicArrayContainer<>();

    public boolean add(T value) {
        boolean result = false;
        if (!contains(value)) {
            store.add(value);
            result = true;
        }
        return result;
    }

    private boolean contains(T value) {
        Iterator<T> iter = store.iterator();
        boolean result = false;
        while (iter.hasNext()) {
            if (iter.next().equals(value)) {
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public Iterator<T> iterator() {
        return store.iterator();
    }
}
