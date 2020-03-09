package ru.job4j.list.stack;

import ru.job4j.list.node.ContainerNodeDynamic;

/**
 * Class SimpleStack
 *
 * @author Petr B.
 * @since 11.10.2019, 11:00
 */
public class SimpleStack<T> {
    private ContainerNodeDynamic<T> storage = new ContainerNodeDynamic<>();

    public void push(T value) {
        storage.add(value);
    }

    public T poll() {
        return storage.delete();
    }

    public int getSize() {
        return storage.getSize();
    }
}
